package projeto.hrpayroll;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Nao precisa mais de ribom, o eukeca ja faz balanceamento de carga
//@RibbonClient(name ="hr-work") //agora será cliente ribon, para balanceamento de requisiçoes
@EnableCircuitBreaker //para o histryx, evitar falhas de timeout
@EnableEurekaClient
@EnableFeignClients //precisa ser add dependencia no pom.xml e depois essa anotation
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
