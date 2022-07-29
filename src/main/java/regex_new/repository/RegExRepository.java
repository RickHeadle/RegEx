package regex_new.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import regex_new.entity.RegEx;

@Repository
public interface RegExRepository extends JpaRepository<RegEx, Long>, JpaSpecificationExecutor<RegEx> {

}
