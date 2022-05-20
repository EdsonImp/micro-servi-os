package projeto.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import projeto.hrpayroll.entities.Worker;



@Component //sera injetado em outras classes
@FeignClient(name="hr-payroll", url="localhost:8001", path= "/workers")
public interface WorkerFeignClient {

	@GetMapping (value= "/{id}")
	ResponseEntity<Worker> findById(@PathVariable  Long id);
}
