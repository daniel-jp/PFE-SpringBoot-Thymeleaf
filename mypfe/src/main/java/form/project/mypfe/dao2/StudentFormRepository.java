package form.project.mypfe.dao2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity2.StudentForm;

public interface StudentFormRepository extends JpaRepository<StudentForm, Long> {

	Page<StudentForm> findByfirstNameContains(String mc, Pageable of);

}
