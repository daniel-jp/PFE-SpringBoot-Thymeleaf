package form.project.mypfe.dao2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity2.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

	Page<Organisation> findByNameContains(String mc, PageRequest of);

}
