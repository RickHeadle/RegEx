package regex_new.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import regex_new.entity.RegEx;

@DataJpaTest
@ActiveProfiles(value = "dev")
@ExtendWith(SpringExtension.class)
class RegExRepositoryIntegrationTest {

    @Autowired
    private RegExRepository regExRepository;

    @Test
    void test_whenSaveAndRetrieveEntity_thenOK() {
        RegEx createdEntity = regExRepository.save(createRegEx());
        RegEx foundEntity = regExRepository.getById(createdEntity.getId());

        Assertions.assertNotNull(foundEntity);
        Assertions.assertEquals(createdEntity, foundEntity);
    }

    private RegEx createRegEx() {
        RegEx entity = new RegEx();
        entity.setId(1L);
        entity.setDescription("Тестовое регулярное выражение");
        entity.setRegularExpression(".*");
        return entity;
    }
}