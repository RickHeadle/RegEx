package regex_new.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import regex_new.entity.RegExInfo;

@Repository
public interface RegExInfoRepository extends JpaRepository<RegExInfo, Long>, JpaSpecificationExecutor<RegExInfo> {

}
