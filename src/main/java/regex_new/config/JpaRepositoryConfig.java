package regex_new.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "regex_new")
@EnableJpaRepositories(basePackages = "regex_new.repository")
public class JpaRepositoryConfig {
}
