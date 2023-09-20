package ActOfWork.ActOfWork;

import ActOfWork.ActOfWork.Service.Storage.StorageProperties;
import ActOfWork.ActOfWork.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ActOfWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActOfWorkApplication.class, args);
	}


	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
