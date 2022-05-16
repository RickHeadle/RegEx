package regex_new.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "T_USER_DATA")
public class User {

    @Id
    @NonNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "USER_NAME", unique = true)
    @Size(min = 2, message = "UserName cannot be less than 2 characters")
    private String userName;

    @NonNull
    @Column(name = "PASSWORD")
    @Size(min = 2, message = "Password cannot be less than 2 characters")
    private String password;

    @Nullable
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    @Transient
    private LocalDateTime loginTime;
}
