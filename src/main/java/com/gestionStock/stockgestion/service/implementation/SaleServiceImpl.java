package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.LineSaleMapping;
import com.gestionStock.stockgestion.DTOs.mapper.SaleMapping;
import com.gestionStock.stockgestion.DTOs.request.SaleRequest;
import com.gestionStock.stockgestion.DTOs.response.LineSaleResponse;
import com.gestionStock.stockgestion.DTOs.response.SaleResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.LineSale;
import com.gestionStock.stockgestion.models.Sale;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.repositories.LineSaleRepository;
import com.gestionStock.stockgestion.repositories.SaleRepository;
import com.gestionStock.stockgestion.service.SaleService;
import com.gestionStock.stockgestion.validator.SaleValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapping saleMapping;
    private final ArticleRepository articleRepository;
    private final LineSaleRepository lineSaleRepository;
    private final LineSaleMapping lineSaleMapping;

    @Override
    public SaleResponse create(SaleRequest saleRequest) {
        List<String> errors= SaleValidator.validate(saleRequest);

        if(!errors.isEmpty()){
            log.error("sale invalid");
            throw new InvalidEntityException(
                    "sale not valid",
                    ErrorCode.SALE_NOT_VALID,
                    errors
            );
        }

        List<String> articleError= new ArrayList<>();
        saleRequest.getLineSale()
                .forEach(line->{
                    Optional<Articles> articles= articleRepository.findById(line.getArticle().getId());
                    if(articles.isEmpty()){
                        articleError.add("the article doesn't exist ont the database");
                    }
                });

        if(!articleError.isEmpty()){
            log.warn("the article doesn't exist on the database");
            throw new InvalidEntityException(
                    "article unexist on the database",
                    ErrorCode.SALE_NOT_VALID,
                    articleError
            );
        }

        Sale sale= saleMapping.saleRequestToSale(saleRequest);
        sale.setId(UUID.randomUUID().toString());

        saleRequest.getLineSale()
                .forEach(line->{
                    LineSale lineSale= lineSaleMapping.lineSaleRequestToLineSale(line);
                    lineSale.setSale(sale);
                    lineSaleRepository.save(lineSale);
                });

        return saleMapping.saleToSaleResponse(
                saleRepository.save(sale)
        );
    }

    @Override
    public SaleResponse getById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            throw new InvalidEntityException(
                    "the id doesn't null",
                    ErrorCode.SALE_NOT_VALID
            );
        }

        Optional<Sale> sale= saleRepository.findById(id);

        SaleResponse saleResponse= saleMapping.saleToSaleResponse(sale.get());

        return Optional.of(saleResponse)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "the sale with the id: "+id+" doesn't exist in the database",
                                ErrorCode.SALE_NOT_FOUND
                        )
                );
    }

    @Override
    public List<SaleResponse> getAll() {
        return saleRepository.findAll()
                .stream()
                .map(sale-> saleMapping.saleToSaleResponse(sale))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        saleRepository.deleteById(id);
        return true;
    }
}
