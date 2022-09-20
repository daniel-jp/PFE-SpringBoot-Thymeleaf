package form.project.mypfe.dao2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity2.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

	

	Page<Category> findByNameContains( String mc,  Pageable pageable);

  
}