package form.project.mypfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import form.project.mypfe.entity.FileField;

public interface FileRepository extends JpaRepository<FileField, String> {

}
