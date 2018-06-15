package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see SpringBootApplication
 * @since 2017.03.29
 */
@EnableAutoConfiguration
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
