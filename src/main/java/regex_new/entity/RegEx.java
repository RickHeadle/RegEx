package regex_new.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "T_REGULAR_EXPRESSIONS")
public class RegEx {

    @Id
    @NonNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "REG_EX")
    private String regularExpression;

    @Nullable
    @Column(name = "DESC")
    private String description;
}