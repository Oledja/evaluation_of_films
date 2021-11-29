package com.prylipko.oleg.service.productionCompany;

import com.prylipko.oleg.domain.ProductionCompany;
import com.prylipko.oleg.dto.productionCompany.CreateProductionCompanyRequest;
import com.prylipko.oleg.dto.productionCompany.PatchProductionCompanyRequest;
import com.prylipko.oleg.dto.productionCompany.ReadProductionCompanyResponse;
import com.prylipko.oleg.dto.productionCompany.UpdateProductionCompanyRequest;
import com.prylipko.oleg.repository.ProductionCompanyRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductionCompanyService {

    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadProductionCompanyResponse getProductionCompany(UUID id) {
        ProductionCompany productionCompany = repositoryHelper.getEntityRequired(ProductionCompany.class, id);

        return translationService.translate(productionCompany, ReadProductionCompanyResponse.class);
    }

    public ReadProductionCompanyResponse createProductionCompany(CreateProductionCompanyRequest create) {
        ProductionCompany productionCompany = translationService.translate(create, ProductionCompany.class);
        productionCompany = productionCompanyRepository.save(productionCompany);

        return translationService.translate(productionCompany, ReadProductionCompanyResponse.class);
    }

    public ReadProductionCompanyResponse patchProductCompany(UUID id,PatchProductionCompanyRequest patch) {
        ProductionCompany productionCompany = repositoryHelper.getEntityRequired(ProductionCompany.class, id);
        translationService.map(patch, productionCompany);
        productionCompany = productionCompanyRepository.save(productionCompany);

        return translationService.translate(productionCompany, ReadProductionCompanyResponse.class);
    }

    public ReadProductionCompanyResponse updateProductCompany(UUID id, UpdateProductionCompanyRequest update) {
        ProductionCompany productionCompany = repositoryHelper.getEntityRequired(ProductionCompany.class, id);
        translationService.map(update, productionCompany);
        productionCompany = productionCompanyRepository.save(productionCompany);

        return translationService.translate(productionCompany, ReadProductionCompanyResponse.class);
    }

    public void deleteProductCompany(UUID id) {
        productionCompanyRepository.delete(repositoryHelper.getEntityRequired(ProductionCompany.class, id));
    }



}
