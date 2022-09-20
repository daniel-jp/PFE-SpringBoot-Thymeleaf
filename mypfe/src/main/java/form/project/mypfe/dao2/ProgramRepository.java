package form.project.mypfe.dao2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity2.Program;

public interface ProgramRepository  extends JpaRepository<Program, Long>{

	Page<Program> findByNameContains(String mc, Pageable pageable);





}
