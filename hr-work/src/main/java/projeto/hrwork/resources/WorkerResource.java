package projeto.hrwork.resources;

import java.util.List;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.hrwork.entities.Worker;
import projeto.hrwork.repository.WorkRepository;

@RefreshScope //precisa ser colocado em toda classe que acessa configuração do git pelo config server
@RestController
@RequestMapping(value="/workers")
public class WorkerResource {
	
	@Value("${test.config}") //esse valor vem do git setado no properties do config
	//acima, usado aki só pra testar se estar vindo algo do config
	private String testConfig;
	@Autowired
	private Environment env;
	//apenas par aimprimir coisas no log
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private WorkRepository repository;
	
	@GetMapping (value= "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable  Long id){
		//aki uso as instancias de logger e env para imprimir a porta usada no console
		logger.info("PORT = " +env.getProperty("local.server.port"));
		Worker obj = repository.findById(id).get(); //retorna um optional, por isso o .get
		return ResponseEntity.ok(obj);
	} 
	//abaixo uma requisicao para tesatar se esta pegando valor do config do git
	@GetMapping(value="/configs")
	public ResponseEntity<Void> getConfig(){
		logger.info("Config=" +testConfig);
		return ResponseEntity.noContent().build();//retorna um corpo vazio
	} 
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	} 

}
