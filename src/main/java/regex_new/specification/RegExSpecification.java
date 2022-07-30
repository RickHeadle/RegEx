package regex_new.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import regex_new.entity.RegEx;

@Component
public class RegExSpecification implements Specification<RegEx> {

    private String regularExpression;
    private String description;


    private RegExSpecification() {

    }

    /*public static Specification<RegEx> regularExpressionLike(String regularExpression) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(RegEx_.regularExpression), regularExpression);
        };
    }*/

    @Override
    public Predicate toPredicate(Root<RegEx> root, CriteriaQuery<?> query,
        CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
