package projeto.hrwork.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private WorkRepository repository;
	
	@GetMapping (value= "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable  Long id){
		Worker obj = repository.findById(id).get(); //retorna um optional, por isso o .get
		return ResponseEntity.ok(obj);
	} 
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	} 

}
