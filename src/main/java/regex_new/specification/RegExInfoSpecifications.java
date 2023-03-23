package regex_new.specification;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import regex_new.entity.RegExInfo;

@NoArgsConstructor
public class RegExInfoSpecifications {

  public static Specification<RegExInfo> regularExpressionLike(String regularExpression) {
    return new RegExInfoRegularExpressionLike(regularExpression);
  }
}
