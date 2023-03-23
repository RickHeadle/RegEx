package regex_new.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import regex_new.entity.RegExInfo;
import regex_new.entity.RegExInfo_;

/**
 * Сравнение регулярных выражений.
 * Учитывает регистр.
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class RegExInfoRegularExpressionLike implements Specification<RegExInfo> {

  public String regularExpression;

  @Override
  public Predicate toPredicate(
      Root<RegExInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.like(root.get(RegExInfo_.REGULAR_EXPRESSION), regularExpression);
  }
}
