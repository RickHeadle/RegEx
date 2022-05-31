package regex_new.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "T_USER_ROLE")
public class UserRole implements GrantedAuthority {

    @Id
    @NonNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "ROLE_CODE")
    @Enumerated(EnumType.STRING)
    private RoleCode roleCode;

    @NonNull
    @Column(name = "ROLE_NAME")
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    public enum RoleCode {

        /**
         * Администратор.
         */
        ROLE_ADMIN("admin"),

        /**
         * Пользователь.
         */
        ROLE_USER("user");

        @Getter
        private final String roleCode;

        RoleCode(String roleCode) {
            this.roleCode = roleCode;
        }
    }
}
