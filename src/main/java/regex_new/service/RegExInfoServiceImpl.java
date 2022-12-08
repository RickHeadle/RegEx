package regex_new.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import regex_new.entity.RegExInfo;
import regex_new.repository.RegExInfoRepository;

@Service
public class RegExInfoServiceImpl implements RegExInfoService {

  @Autowired
  private RegExInfoRepository regExInfoRepository;

  @Override
  public String findFirst(RegExInfo regularExpression, @NonNull String text) {
    Pattern pattern = Pattern.compile(regularExpression.getRegularExpression());
    Matcher matcher = pattern.matcher(text);

    if (matcher.find()) {
      return matcher.group();
    }
    throw new IllegalStateException("No match found");
  }

  @Override
  public List<String> findAll(RegExInfo regularExpression, @NonNull String text) {
    Pattern pattern = Pattern.compile(regularExpression.getRegularExpression());
    Matcher matcher = pattern.matcher(text);

    return matcher.results()
        .map(MatchResult::group)
        .toList();
  }

  @Override
  public String replaceFirst(RegExInfo searchByRegEx, RegExInfo replaceByRegEx, String text) {
    return text.replaceFirst(searchByRegEx.getRegularExpression(),
        replaceByRegEx.getRegularExpression());
  }

  @Override
  public String replaceAll(RegExInfo searchByRegEx, RegExInfo replaceByRegEx, String text) {
    return text.replaceAll(searchByRegEx.getRegularExpression(),
        replaceByRegEx.getRegularExpression());
  }

  @Override
  public Page<RegExInfo> findAll(@Nullable Specification<RegExInfo> specification,
      @NonNull Pageable pageable) {
    return regExInfoRepository.findAll(specification, pageable);
  }

  @Override
  public Optional<RegExInfo> findById(@NonNull Long id) {
    return regExInfoRepository.findById(id);
  }

  @Override
  public RegExInfo save(@NonNull RegExInfo regExInfo) {
    return regExInfoRepository.save(regExInfo);
  }

  @Override
  public Long deleteById(@NonNull Long id) {
    regExInfoRepository.deleteById(id);
    return id;
  }

  @Override
  public Long deleteByEntity(@NonNull RegExInfo regExInfo) {
    regExInfoRepository.delete(regExInfo);
    return regExInfo.getId();
  }
}
