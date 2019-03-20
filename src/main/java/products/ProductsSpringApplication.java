package products;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsSpringApplication {

	@PostConstruct
	public void init() {
		System.err.println("Prucucts App Started at: " + new Date());
	}

	@PreDestroy
	public void destroy() {
		System.err.println("Priducts App Ended at: " + new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductsSpringApplication.class, args);
	}

}
