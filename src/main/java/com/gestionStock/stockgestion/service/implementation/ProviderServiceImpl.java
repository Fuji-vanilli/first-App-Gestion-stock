package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.ProviderMapping;
import com.gestionStock.stockgestion.DTOs.request.ProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.ProviderResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Provider;
import com.gestionStock.stockgestion.repositories.ProviderRepository;
import com.gestionStock.stockgestion.service.ProviderService;
import com.gestionStock.stockgestion.validator.ProviderValidator;
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
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapping providerMapping;

    @Override
    public ProviderResponse create(ProviderRequest providerRequest) {
        List<String> errors= ProviderValidator.validate(providerRequest);

        if(!errors.isEmpty()){
            log.error("provider invalid");
            throw new InvalidEntityException(
                    "provider not valid",
                    ErrorCode.PROVIDER_NOT_VALID,
                    errors
            );
        }

        Provider provider= providerMapping.providerRequestToProvider(providerRequest);
        provider.setId(UUID.randomUUID().toString());

        return providerMapping.providerToProviderRepsonse(
                providerRepository.save(provider)
        );
    }

    @Override
    public ProviderResponse getById(String id) {
        if (!StringUtils.hasLength(id)) {
            log.error("code doesn't null");
            return null;
        }

        Optional<Provider> provider= providerRepository.findById(id);

        ProviderResponse providerResponse= providerMapping.providerToProviderRepsonse(provider.get());

        return Optional.of(providerResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "provider with the code: "+id+" doesn't exist on the database",
                        ErrorCode.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public ProviderResponse getByEmail(String email) {
        if (!StringUtils.hasLength(email)) {
            log.error("email doesn't null");
            return null;
        }

        Optional<Provider> provider= providerRepository.findByEmail(email);

        ProviderResponse providerResponse= providerMapping.providerToProviderRepsonse(provider.get());

        return Optional.of(providerResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "provider with the email: "+email+" doesn't exist on the database",
                        ErrorCode.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public List<ProviderResponse> getAll() {
        return providerRepository.findAll()
                .stream()
                .map(provider-> providerMapping.providerToProviderRepsonse(provider))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        providerRepository.deleteById(id);
        return true;
    }
}
