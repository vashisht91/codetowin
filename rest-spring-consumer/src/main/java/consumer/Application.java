package consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting?name=piyush", Greeting.class);
		logger.info(greeting.toString());
	}

}
