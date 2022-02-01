package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.productionCompany.CreateProductionCompanyRequest;
import com.prylipko.oleg.dto.productionCompany.PatchProductionCompanyRequest;
import com.prylipko.oleg.dto.productionCompany.ReadProductionCompanyResponse;
import com.prylipko.oleg.dto.productionCompany.UpdateProductionCompanyRequest;
import com.prylipko.oleg.service.productionCompany.ProductionCompanyService;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/production-companies")
public class ProductionCompanyController {

    private ProductionCompanyService productionCompanyService;

    @GetMapping("/id")
    public ReadProductionCompanyResponse getMovie(@PathVariable UUID id) {
        return productionCompanyService.getProductionCompany(id);
    }

    @PostMapping
    public ReadProductionCompanyResponse createProductionCompany(@RequestBody CreateProductionCompanyRequest create) {
        return productionCompanyService.createProductionCompany(create);
    }

    @PatchMapping("/id")
    public ReadProductionCompanyResponse patchProductionCompany(@PathVariable UUID id,
                                                                @RequestBody PatchProductionCompanyRequest patch) {
        return productionCompanyService.patchProductCompany(id, patch);
    }

    @PutMapping("/id")
    public ReadProductionCompanyResponse updateProductionCompany(@PathVariable UUID id,
                                                                 @RequestBody UpdateProductionCompanyRequest update) {
        return productionCompanyService.updateProductCompany(id, update);
    }

    @DeleteMapping("/id")
    public void deleteProductionCompany(@PathVariable UUID id) {
        productionCompanyService.deleteProductCompany(id);
    }
}
