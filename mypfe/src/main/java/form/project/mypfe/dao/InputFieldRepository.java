package form.project.mypfe.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import form.project.mypfe.entity.InputField;
import form.project.mypfe.enums.Status;

public interface InputFieldRepository  extends JpaRepository<InputField, String>{
	
	  Long countFormByStatus(Status todo);
	  
 
	    @Transactional
	    @Modifying
	    @Query("UPDATE InputField SET position = position + 1 WHERE position >= :position AND status = :status AND id <> :id")
	    void incrementBelow(@Param("position") Long position, @Param("status") Status status, @Param("id") String id);

	    @Transactional
	    @Modifying
	    @Query("UPDATE InputField SET position = position - 1 WHERE position >= :position AND status = :status AND id <> :id")
	    void decrementBelow(@Param("position") Long position, @Param("status") Status status, @Param("id") String id);

	    @Transactional
	    @Modifying
	    @Query("UPDATE InputField SET position = position + 1 WHERE position >= :newPosition AND position < :oldPosition AND status = :status AND id <> :id")
	    void incrementBelowToPosition(@Param("newPosition") Long newPosition, @Param("oldPosition") Long oldPosition, @Param("status") Status status,
	            @Param("id") String id);

	    @Transactional
	    @Modifying
	    @Query("UPDATE InputField SET position = position - 1 WHERE position <= :newPosition AND position > :oldPosition AND status = :status AND id <> :id")
	    void decrementAboveToPosition(@Param("newPosition") Long newPosition, @Param("oldPosition") Long oldPosition, @Param("status") Status status,
	            @Param("id") String id); 
	  
				 

}
