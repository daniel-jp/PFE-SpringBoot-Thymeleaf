package form.project.mypfe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import form.project.mypfe.entity2.Category;
import form.project.mypfe.entity2.Program;

public interface ITemplatesService {
	
	
	public void initCategory();
	public Category saveCategory(Category pCategory);
	public Category updateCategory(Long id); 
	public void deleteCategoryr(Long id); 
	public List<Category> getAllCategory();  
	
	
	public void initProgram();
	public Program saveProgram(Program cProgram);
	public Program updateProgramr(Long id); 
	public void deleteProgram(Long id); 
	public List<Program> getAllProgram();
	public Page<Program> findByNameContains(String mc, Pageable pageable);
	

}
