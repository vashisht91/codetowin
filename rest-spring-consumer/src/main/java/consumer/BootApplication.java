package consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootApplication {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder template) {
		return template.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting?name=piyush", Greeting.class);
			logger.info(greeting.toString());
		};
	}

}
