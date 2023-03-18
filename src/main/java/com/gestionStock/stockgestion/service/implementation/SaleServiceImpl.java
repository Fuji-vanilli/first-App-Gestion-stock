package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.SaleMapping;
import com.gestionStock.stockgestion.DTOs.request.SaleRequest;
import com.gestionStock.stockgestion.DTOs.response.SaleResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Sale;
import com.gestionStock.stockgestion.repositories.SaleRepository;
import com.gestionStock.stockgestion.service.SaleService;
import com.gestionStock.stockgestion.validator.SaleValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

        Sale sale= saleMapping.saleRequestToSale(saleRequest);
        sale.setId(UUID.randomUUID().toString());

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
