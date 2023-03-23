package regex_new.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import regex_new.entity.RegExInfo;

public interface RegExInfoService {

  String findFirst(RegExInfo regularExpression, String text);

  List<String> findAll(RegExInfo regularExpression, @NonNull String text);

  String replaceFirst(RegExInfo searchByRegEx, RegExInfo replaceByRegEx, String text);

  String replaceAll(RegExInfo searchByRegEx, RegExInfo replaceByRegEx, String text);

  Page<RegExInfo> findAll(@Nullable Specification<RegExInfo> specification, @NonNull Pageable pageable);

  Optional<RegExInfo> findById(@NonNull Long id);

  RegExInfo save(@NonNull RegExInfo regExInfo);

  Long deleteById(@NonNull Long id);

  Long deleteByEntity(@NonNull RegExInfo regExInfo);
}