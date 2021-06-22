package regex.launcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import regex.test.RegExTest;

@SpringBootApplication
public class RegExApplication implements CommandLineRunner {

    public static void main(String[] args) {
        /*SpringApplication.run(RegExApplication.class, args);*/
        new SpringApplicationBuilder()
                .main(RegExApplication.class)
                .sources(RegExApplication.class)
                .run(args);
    }

    @Override
    public void run(String... args) {
        RegExTest.checkFromConsole();
    }

}
