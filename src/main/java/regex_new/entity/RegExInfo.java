package regex_new.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Таблица регулярных выражений.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_REGULAR_EXPRESSIONS")
public class RegExInfo implements Serializable {

    /**
     * Уникальный идентификатор записи.
     */
    @Id
    @Basic
    @NonNull
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Регулярное выражение. <br>
     * Хранится как строка во избежание парсинга. <br>
     * Парсинг вынесен в бизнес-слой.
     */
    @Basic
    @NonNull
    @Column(name = "REG_EX", nullable = false)
    private String regularExpression;

    /**
     * Текстовое описание регулярного выражения. <br>
     * Служит для упрощения восприятия/понимания регулярного выражения. <br>
     * Может отсутствовать.
     */
    @Basic
    @Nullable
    @Column(name = "DESC")
    private String description;
}
