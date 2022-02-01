package com.prylipko.oleg.service;

import com.prylipko.oleg.domain.*;
import com.prylipko.oleg.dto.cast.CreateCastRequest;
import com.prylipko.oleg.dto.cast.PatchCastRequest;
import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.cast.UpdateCastRequest;
import com.prylipko.oleg.dto.castRating.CreateCastRatingRequest;
import com.prylipko.oleg.dto.castRating.PatchCastRatingRequest;
import com.prylipko.oleg.dto.castRating.ReadCastRatingResponse;
import com.prylipko.oleg.dto.castRating.UpdateCastRatingRequest;
import com.prylipko.oleg.dto.credit.CreateCreditRequest;
import com.prylipko.oleg.dto.credit.PatchCreditRequest;
import com.prylipko.oleg.dto.credit.ReadCreditResponse;
import com.prylipko.oleg.dto.credit.UpdateCreditRequest;
import com.prylipko.oleg.dto.crew.CreateCrewRequest;
import com.prylipko.oleg.dto.crew.PatchCrewRequest;
import com.prylipko.oleg.dto.crew.ReadCrewResponse;
import com.prylipko.oleg.dto.crew.UpdateCrewRequest;
import com.prylipko.oleg.dto.genre.CreateGenreRequest;
import com.prylipko.oleg.dto.genre.PatchGenreRequest;
import com.prylipko.oleg.dto.genre.ReadGenreResponse;
import com.prylipko.oleg.dto.genre.UpdateGenreRequest;
import com.prylipko.oleg.dto.movie.CreateMovieRequest;
import com.prylipko.oleg.dto.movie.PatchMovieRequest;
import com.prylipko.oleg.dto.movie.ReadMovieResponse;
import com.prylipko.oleg.dto.movie.UpdateMovieRequest;
import com.prylipko.oleg.dto.movieComplaint.CreateMovieComplaintRequest;
import com.prylipko.oleg.dto.movieComplaint.PatchMovieComplaintRequest;
import com.prylipko.oleg.dto.movieComplaint.ReadMovieComplaintResponse;
import com.prylipko.oleg.dto.movieComplaint.UpdateMovieComplaintRequest;
import com.prylipko.oleg.dto.movieRating.CreateMovieRatingRequest;
import com.prylipko.oleg.dto.movieRating.PatchMovieRatingRequest;
import com.prylipko.oleg.dto.movieRating.ReadMovieRatingResponse;
import com.prylipko.oleg.dto.movieRating.UpdateMovieRatingRequest;
import com.prylipko.oleg.dto.person.CreatePersonRequest;
import com.prylipko.oleg.dto.person.PatchPersonRequest;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.dto.person.UpdatePersonRequest;
import com.prylipko.oleg.dto.personComplaint.CreatePersonComplaintRequest;
import com.prylipko.oleg.dto.personComplaint.PatchPersonComplaintRequest;
import com.prylipko.oleg.dto.personComplaint.ReadPersonComplaintResponse;
import com.prylipko.oleg.dto.personComplaint.UpdatePersonComplaintRequest;
import com.prylipko.oleg.dto.productionCompany.CreateProductionCompanyRequest;
import com.prylipko.oleg.dto.productionCompany.PatchProductionCompanyRequest;
import com.prylipko.oleg.dto.productionCompany.ReadProductionCompanyResponse;
import com.prylipko.oleg.dto.productionCompany.UpdateProductionCompanyRequest;
import com.prylipko.oleg.dto.review.CreateReviewRequest;
import com.prylipko.oleg.dto.review.PatchReviewRequest;
import com.prylipko.oleg.dto.review.ReadReviewResponse;
import com.prylipko.oleg.dto.review.UpdateReviewRequest;
import com.prylipko.oleg.dto.reviewComplaint.CreateReviewComplaintRequest;
import com.prylipko.oleg.dto.reviewComplaint.PatchReviewComplaintRequest;
import com.prylipko.oleg.dto.reviewComplaint.ReadReviewComplaintResponse;
import com.prylipko.oleg.dto.reviewComplaint.UpdateReviewComplaintRequest;
import com.prylipko.oleg.dto.role.CreateRoleRequest;
import com.prylipko.oleg.dto.role.PatchRoleRequest;
import com.prylipko.oleg.dto.role.ReadRoleResponse;
import com.prylipko.oleg.dto.role.UpdateRoleRequest;
import com.prylipko.oleg.dto.user.CreateUserRequest;
import com.prylipko.oleg.dto.user.PatchUserRequest;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import com.prylipko.oleg.dto.user.UpdateUserRequest;
import com.prylipko.oleg.repository.RepositoryHelper;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.brunneng.ot.Configuration;
import org.bitbucket.brunneng.ot.ObjectTranslator;
import org.bitbucket.brunneng.ot.exceptions.TranslationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Slf4j
@Service
public class TranslationService {

    @Autowired
    private RepositoryHelper repositoryHelper;

    private ObjectTranslator objectTranslator;

    public TranslationService() {
        objectTranslator = new ObjectTranslator(createConfiguration());
    }

    private Configuration createConfiguration() {
        Configuration c = new Configuration();
        configureForAbstractEntity(c);
        configureForCast(c);
        configureForCastRating(c);
        configureForCredit(c);
        configureForCrew(c);
        configureForGenre(c);
        configureForMovie(c);
        configureForMovieComplaint(c);
        configureForMovieRating(c);
        configureForPerson(c);
        configureForPersonComplaint(c);
        configureForProductionCompany(c);
        configureForReview(c);
        configureForReviewComplaint(c);
        configureForRole(c);
        configureForUser(c);

        return c;
    }

    private void configureForCast(Configuration c) {
        c.beanOfClass(CreateCastRequest.class).translationTo(Cast.class);
        c.beanOfClass(UpdateCastRequest.class).translationTo(Cast.class);
        c.beanOfClass(PatchCastRequest.class).translationTo(Cast.class);
        c.beanOfClass(Cast.class).translationTo(ReadCastResponse.class);
        c.beanOfClass(ReadCastResponse.class).translationTo(Cast.class);
        c.beanOfClass(Cast.class).translationTo(CreateCastRequest.class);


    }

    private void configureForCastRating(Configuration c) {
        c.beanOfClass(CreateCastRatingRequest.class).translationTo(CastRating.class);
        c.beanOfClass(UpdateCastRatingRequest.class).translationTo(CastRating.class);
        c.beanOfClass(PatchCastRatingRequest.class).translationTo(CastRating.class);
        c.beanOfClass(CastRating.class).translationTo(ReadCastRatingResponse.class);
    }

    private void configureForCredit(Configuration c) {
        c.beanOfClass(CreateCreditRequest.class).translationTo(Credit.class);
        c.beanOfClass(UpdateCreditRequest.class).translationTo(Credit.class);
        c.beanOfClass(PatchCreditRequest.class).translationTo(Credit.class);
        c.beanOfClass(Credit.class).translationTo(ReadCreditResponse.class);
    }

    private void configureForCrew(Configuration c) {
        c.beanOfClass(CreateCrewRequest.class).translationTo(Crew.class);
        c.beanOfClass(UpdateCrewRequest.class).translationTo(Crew.class);
        c.beanOfClass(PatchCrewRequest.class).translationTo(Crew.class);
        c.beanOfClass(Crew.class).translationTo(ReadCrewResponse.class);
    }

    private void configureForGenre(Configuration c) {
        c.beanOfClass(CreateGenreRequest.class).translationTo(Genre.class);
        c.beanOfClass(UpdateGenreRequest.class).translationTo(Genre.class);
        c.beanOfClass(PatchGenreRequest.class).translationTo(Genre.class);
        c.beanOfClass(Genre.class).translationTo(ReadGenreResponse.class);
    }

    private void configureForMovie(Configuration c) {
        c.beanOfClass(CreateMovieRequest.class).translationTo(Movie.class);
        c.beanOfClass(UpdateMovieRequest.class).translationTo(Movie.class);
        c.beanOfClass(PatchMovieRequest.class).translationTo(Movie.class);
        c.beanOfClass(Movie.class).translationTo(ReadMovieResponse.class);
    }

    private void configureForMovieComplaint(Configuration c) {
        c.beanOfClass(CreateMovieComplaintRequest.class).translationTo(MovieComplaint.class);
        c.beanOfClass(UpdateMovieComplaintRequest.class).translationTo(MovieComplaint.class);
        c.beanOfClass(PatchMovieComplaintRequest.class).translationTo(MovieComplaint.class);
        c.beanOfClass(MovieComplaint.class).translationTo(ReadMovieComplaintResponse.class);
    }

    private void configureForMovieRating(Configuration c) {
        c.beanOfClass(CreateMovieRatingRequest.class).translationTo(MovieRating.class);
        c.beanOfClass(UpdateMovieRatingRequest.class).translationTo(MovieRating.class);
        c.beanOfClass(PatchMovieRatingRequest.class).translationTo(MovieRating.class);
        c.beanOfClass(MovieRating.class).translationTo(ReadMovieRatingResponse.class);
    }

    private void configureForPerson(Configuration c) {
        c.beanOfClass(CreatePersonRequest.class).translationTo(Person.class);
        c.beanOfClass(UpdatePersonRequest.class).translationTo(Person.class);
        c.beanOfClass(PatchPersonRequest.class).translationTo(Person.class);
        c.beanOfClass(Person.class).translationTo(ReadPersonResponse.class);
        c.beanOfClass(ReadPersonResponse.class).translationTo(Person.class);
    }

    private void configureForPersonComplaint(Configuration c) {
        c.beanOfClass(CreatePersonComplaintRequest.class).translationTo(PersonComplaint.class);
        c.beanOfClass(UpdatePersonComplaintRequest.class).translationTo(PersonComplaint.class);
        c.beanOfClass(PatchPersonComplaintRequest.class).translationTo(PersonComplaint.class);
        c.beanOfClass(PersonComplaint.class).translationTo(ReadPersonComplaintResponse.class);
    }

    private void configureForProductionCompany(Configuration c) {
        c.beanOfClass(CreateProductionCompanyRequest.class).translationTo(ProductionCompany.class);
        c.beanOfClass(UpdateProductionCompanyRequest.class).translationTo(ProductionCompany.class);
        c.beanOfClass(PatchProductionCompanyRequest.class).translationTo(ProductionCompany.class);
        c.beanOfClass(ProductionCompany.class).translationTo(ReadProductionCompanyResponse.class);
    }

    private void configureForReview(Configuration c) {
        c.beanOfClass(CreateReviewRequest.class).translationTo(Review.class);
        c.beanOfClass(UpdateReviewRequest.class).translationTo(Review.class);
        c.beanOfClass(PatchReviewRequest.class).translationTo(Review.class);
        c.beanOfClass(Review.class).translationTo(ReadReviewResponse.class);
    }

    private void configureForReviewComplaint(Configuration c) {
        c.beanOfClass(CreateReviewComplaintRequest.class).translationTo(ReviewComplaint.class);
        c.beanOfClass(UpdateReviewComplaintRequest.class).translationTo(ReviewComplaint.class);
        c.beanOfClass(PatchReviewComplaintRequest.class).translationTo(ReviewComplaint.class);
        c.beanOfClass(ReviewComplaint.class).translationTo(ReadReviewComplaintResponse.class);
    }

    private void configureForRole(Configuration c) {
        c.beanOfClass(CreateRoleRequest.class).translationTo(Role.class);
        c.beanOfClass(UpdateRoleRequest.class).translationTo(Role.class);
        c.beanOfClass(PatchRoleRequest.class).translationTo(Role.class);
        c.beanOfClass(Role.class).translationTo(ReadRoleResponse.class);
    }

    private void configureForUser(Configuration c) {
        c.beanOfClass(CreateUserRequest.class).translationTo(User.class);
        c.beanOfClass(UpdateUserRequest.class).translationTo(User.class);
        c.beanOfClass(PatchUserRequest.class).translationTo(User.class);
        c.beanOfClass(User.class).translationTo(ReadUserResponse.class);
    }


    public <T> T translate(Object srcObject, Class<T> targetClass) {
        try {
            return objectTranslator.translate(srcObject, targetClass);
        }
        catch (TranslationException e) {
            log.warn(e.getMessage());
            throw (RuntimeException) e.getCause();
        }
    }

    public <T> void map(Object srcObject, Object destObject) {
        try {
            objectTranslator.mapBean(srcObject, destObject);
        }
        catch (TranslationException e) {
            log.warn(e.getMessage());
            throw (RuntimeException) e.getCause();
        }
    }

    private void configureForAbstractEntity(Configuration c) {
        c.beanOfClass(AbstractEntity.class).setIdentifierProperty("id");
        c.beanOfClass(AbstractEntity.class).setBeanFinder(
                (beanClass, id) -> repositoryHelper.getReferenceExist(beanClass, (UUID) id));
    }

//    public <E, T> PageResult<T> toPageResult(Page<E> page, Class<T> dtoType) {
//        PageResult<T> res = new PageResult<>();
//        res.setPage(page.getNumber());
//        res.setPageSize(page.getSize());
//        res.setTotalPages(page.getTotalPages());
//        res.setTotalElements(page.getTotalElements());
//        res.setData(page.getContent().stream().map(e -> translate(e, dtoType)).collect(Collectors.toList()));
//        return res;
//    }
}
