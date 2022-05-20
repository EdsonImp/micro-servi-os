package projeto.hrpayroll;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name ="hr-work") //agora será cliente ribon, para balanceamento de requisiçoes
@EnableFeignClients //precisa ser add dependencia no pom.xml e depois essa anotation
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
