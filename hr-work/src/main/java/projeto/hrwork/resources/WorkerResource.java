package projeto.hrwork.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.hrwork.entities.Worker;
import projeto.hrwork.repository.WorkRepository;

@RestController
@RequestMapping(value="/workers")
public class WorkerResource {
	
	
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
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	} 

}
