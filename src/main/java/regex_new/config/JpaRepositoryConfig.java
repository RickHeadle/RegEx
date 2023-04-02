package regex_new.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "regex_new")
@EntityScan(basePackages = "regex_new.entity")
@EnableJpaRepositories(basePackages = "regex_new.repository")
public class JpaRepositoryConfig {
}
