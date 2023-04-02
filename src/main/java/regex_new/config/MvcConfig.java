package regex_new.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableSpringDataWebSupport
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/sayHi").setViewName("sayHi");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

}
