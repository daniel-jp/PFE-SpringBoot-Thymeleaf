package form.project.mypfe.dao2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity2.JobForm;

public interface JobFormRepository extends JpaRepository<JobForm, Long> {

	Page<JobForm> findByfullNameContains(String mc, Pageable of);

}
