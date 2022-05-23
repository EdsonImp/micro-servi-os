package projeto.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import projeto.hrpayroll.entities.Payment;
import projeto.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {
	
	@Autowired //instanacia esse serviço de pagamento
	private PaymentService service;
	
	//a requisicao ficara assim http://localhost:8101/payments/1/days/10
	@HystrixCommand(fallbackMethod ="getPaymentAlternativo" ) //do hystrix para criar alternativa a falha de timeout ou outras
	@GetMapping(value="/{workerID}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerID, @PathVariable Integer days){
		//agora instancia o pagamento pegando o metodo do service e os dados acima
		Payment payment = service.getPayment(workerID, days);
		return ResponseEntity.ok(payment);
	}
	
	//Método alternativo para falhas no metodo que chama o hr-work
	public ResponseEntity<Payment> getPaymentAlternativo(Long workerID, Integer days){
		Payment payment = new Payment("Edson",200.00, days);
		return ResponseEntity.ok(payment);
	}

}
