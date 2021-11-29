package com.prylipko.oleg.service.credit;

import com.prylipko.oleg.domain.Credit;
import com.prylipko.oleg.dto.credit.CreateCreditRequest;
import com.prylipko.oleg.dto.credit.PatchCreditRequest;
import com.prylipko.oleg.dto.credit.ReadCreditResponse;
import com.prylipko.oleg.dto.credit.UpdateCreditRequest;
import com.prylipko.oleg.repository.CreditRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadCreditResponse getCredit(UUID id) {
        Credit credit = repositoryHelper.getEntityRequired(Credit.class, id);

        return translationService.translate(credit, ReadCreditResponse.class);
    }

    public ReadCreditResponse createCredit(CreateCreditRequest create) {
        Credit credit = translationService.translate(create, Credit.class);
        credit = creditRepository.save(credit);

        return translationService.translate(credit, ReadCreditResponse.class);
    }

    public ReadCreditResponse patchCredit(UUID id, PatchCreditRequest patch) {
        Credit credit = repositoryHelper.getEntityRequired(Credit.class, id);
        translationService.map(patch, credit);
        credit = creditRepository.save(credit);

        return translationService.translate(credit, ReadCreditResponse.class);
    }

    public ReadCreditResponse updateCredit(UUID id, UpdateCreditRequest update) {
        Credit credit = repositoryHelper.getEntityRequired(Credit.class, id);
        translationService.map(update, credit);
        credit = creditRepository.save(credit);

        return translationService.translate(credit, ReadCreditResponse.class);
    }

    public void deleteCredit(UUID id) {
        creditRepository.delete(repositoryHelper.getEntityRequired(Credit.class, id));
    }
}
