package sys.springbootproject1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("sys")
@EntityScan("sys.entities")
@EnableJpaRepositories("sys.repositories")

public class Springbootproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootproject1Application.class, args);
	}

}
