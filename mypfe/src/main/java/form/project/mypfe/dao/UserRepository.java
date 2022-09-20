package form.project.mypfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	 User findByUsername(String username);

}
 