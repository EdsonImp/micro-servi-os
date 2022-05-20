package projeto.hrwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.hrwork.entities.Worker;

public interface WorkRepository extends JpaRepository<Worker, Long>{

}
