package regex_new.specification;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import regex_new.entity.RegEx;

@Component
@NoArgsConstructor
public class RegExSpecification implements Specification<RegEx> {

  private String regularExpression;
  private String description;

  public static Specification<RegEx> regularExpressionLike(String regularExpression) {
    return (root, query, criteriaBuilder) -> {
      //TODO: сгенерировать метамодели, чтобы строка ниже сработала
//      return criteriaBuilder.like(root.get(RegEx_.REGULAR_EXPRESSION), regularExpression);
      return null;
    };
  }

  @Override
  public javax.persistence.criteria.Predicate toPredicate(
      javax.persistence.criteria.Root<RegEx> root,
      javax.persistence.criteria.CriteriaQuery<?> query,
      javax.persistence.criteria.CriteriaBuilder criteriaBuilder) {
    return null;
  }
}
