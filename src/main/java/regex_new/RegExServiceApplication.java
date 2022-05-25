package regex_new;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Locale;

@SpringBootApplication
public class RegExServiceApplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("RU"));
        new SpringApplicationBuilder()
                .main(RegExServiceApplication.class)
                .sources(RegExServiceApplication.class)
                .run(args);
    }

    @Slf4j
    @RestController
    @AllArgsConstructor
    public static class HelloController {

        @GetMapping("/hello")
        public String whoAmI(Principal principal) {
            return principal.getName();
        }

    }
}
