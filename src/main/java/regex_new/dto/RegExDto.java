package regex_new.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
public class RegExDto extends RepresentationModel<RegExDto> {

    /**
     * Уникальный идентификатор регулярного выражения. <br>
     * Не заполняется только в случае <b>создания</b> новой записи.
     */
    @Nullable
    private Long id;

    /**
     * Регулярное выражение. <br>
     * Считывается с UI. Должно быть заполнено. <br>
     * Может содержать ошибки, требуется валидация.
     */
    @NonNull
    private String regularExpression;

    /**
     * Описание регулярного выражения. <br>
     * Может содержать его назначение, принцип работы, и т.д.
     */
    @Nullable
    private String description;
}
