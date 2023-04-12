package springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"pokedex", "trainers", "shared"})
@EnableRabbit
public class MdasSpringbootAplication {

	public static void main(String[] args) {
		SpringApplication.run(MdasSpringbootAplication.class, args);
	}

}
