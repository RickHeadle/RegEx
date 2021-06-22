package regex.launcher;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RegExApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .main(RegExApplication.class)
                .sources(RegExApplication.class)
                .run(args);
    }

}
