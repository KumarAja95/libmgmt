package in.ecgc.smile.erp.hrd.reimbbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "in")
@EnableDiscoveryClient
public class HrdReimbBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrdReimbBeApplication.class, args);
	}

}
