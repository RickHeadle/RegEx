package regex_new.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
public class RegExModel extends RepresentationModel<RegExModel> {
    private Long id;
    private String regularExpression;
    private String description;
}
