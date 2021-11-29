package com.prylipko.oleg.test;

import com.prylipko.oleg.domain.AbstractEntity;
import com.prylipko.oleg.repository.BaseTestRepository;
import org.bitbucket.brunneng.br.Configuration;
import org.bitbucket.brunneng.br.RandomObjectGenerator;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Sql(statements = {
        "delete from cast_rating",
        "delete from casts",
        "delete from credit",
        "delete from credit_crews",
        "delete from crew",
        "delete from genre",
        "delete from movie",
        "delete from movie_complaint",
        "delete from movie_genres",
        "delete from movie_production_companies",
        "delete from movie_rating",
        "delete from person",
        "delete from person_complaint",
        "delete from production_company",
        "delete from review",
        "delete from review_complaint",
        "delete from role",
        "delete from t_user",
        "delete from t_user_roles"
}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class BaseTest {

    @Autowired
    private BaseTestRepository baseTestRepository;

    private RandomObjectGenerator generator = new RandomObjectGenerator();

    protected <T extends AbstractEntity> T generateEntityWithoutId(Class<T> entityClass) {
        T entity = generator.generateRandomObject(entityClass);
        entity.setId(null);
        return entity;
    }

    protected <T extends AbstractEntity> T generateFlatEntityAndSave(Class<T> entityClass) {
        T entity = flatGenerator.generateRandomObject(entityClass);
        entity.setId(null);
        return baseTestRepository.save(entity);
    }

    protected <T extends AbstractEntity> T generateEntity(Class<T> entityClass) {
        T entity = generator.generateRandomObject(entityClass);
        return  entity;
    }

    protected <T> T generateObject(Class<T> objectClass) {
        return generator.generateRandomObject(objectClass);
    }

    private RandomObjectGenerator flatGenerator;
    {
        Configuration c = new Configuration();
        c.setFlatMode(true);
        flatGenerator = new RandomObjectGenerator(c);
    }

    protected <T extends AbstractEntity> T generateFlatEntityWithoutId(Class<T> entityClass) {
        T entity = flatGenerator.generateRandomObject(entityClass);
        entity.setId(null);
        return entity;
    }
}
