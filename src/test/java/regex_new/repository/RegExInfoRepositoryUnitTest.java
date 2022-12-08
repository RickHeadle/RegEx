package regex_new.repository;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import regex_new.entity.RegExInfo;

@DataJpaTest
@ActiveProfiles(value = "dev")
@ExtendWith(SpringExtension.class)
class RegExInfoRepositoryUnitTest {

  @Autowired
  private RegExInfoRepository regExInfoRepository;

  @Test
  void test_whenSaveAndRetrieveEntity_thenOK() {
    RegExInfo createdEntity = regExInfoRepository.save(createRegEx());
    RegExInfo foundEntity = regExInfoRepository.getReferenceById(createdEntity.getId());

    Assertions.assertNotNull(foundEntity);
    Assertions.assertEquals(createdEntity, foundEntity);
  }

  @Test
  void test_whenNoEntityFoundById_thenEmpty() {
    Optional<RegExInfo> missingRegEx = regExInfoRepository.findById(ArgumentMatchers.anyLong());

    Assertions.assertEquals(Optional.empty(), missingRegEx);
  }

  private RegExInfo createRegEx() {
    RegExInfo entity = new RegExInfo();
    entity.setId(ArgumentMatchers.anyLong());
    entity.setDescription("Тестовое регулярное выражение");
    entity.setRegularExpression(".*");
    return entity;
  }
}