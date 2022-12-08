package regex_new.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import regex_new.entity.RegExInfo;

@Component
@NoArgsConstructor
public class RegExInfoSpecification implements Specification<RegExInfo> {

  private String regularExpression;
  private String description;

  public static Specification<RegExInfo> regularExpressionLike(String regularExpression) {
    return (root, query, criteriaBuilder) -> {
      //TODO: сгенерировать метамодели, чтобы строка ниже сработала
//      return criteriaBuilder.like(root.get(RegEx_.REGULAR_EXPRESSION), regularExpression);
      return null;
    };
  }

  @Override
  public Predicate toPredicate(Root<RegExInfo> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {
    return null;
  }
}
