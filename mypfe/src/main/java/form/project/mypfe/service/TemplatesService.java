package form.project.mypfe.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import form.project.mypfe.dao2.CategoryRepository;
import form.project.mypfe.dao2.ProgramRepository;
import form.project.mypfe.entity2.Category;
import form.project.mypfe.entity2.Program;
import form.project.mypfe.enums2.City;

@Service
@Transactional
public class TemplatesService implements ITemplatesService {
	
	@Autowired
	private  CategoryRepository pCategoryRepository;
	@Autowired
	private  ProgramRepository cProgramRepository;

	
	
	@Override
	public void initCategory() {
	
		pCategoryRepository.save(new Category(null,"Programmes scientifiques",null));
		pCategoryRepository.findAll().forEach(cp->{
			
			System.out.println("\n");
			System.out.println("CNRST Category P : "+cp.getName());
			System.out.println("\n");
		});
		
	}

	@Override
	public Category saveCategory(Category pCategory) {
		
		
		
		return pCategoryRepository.save(pCategory);
	}
	@Override
	public Category updateCategory(Long id) {
		return pCategoryRepository.findById(id).get(); 
	}
	@Override
	public void deleteCategoryr(Long id) { 
	this.pCategoryRepository.deleteById(id);		 
	}
	@Override
	public List<Category> getAllCategory() {
		return pCategoryRepository.findAll();
	}
	
	
	@Override
	public void initProgram() {
		Category pCategory = pCategoryRepository.findById(1L).get();
	
		cProgramRepository.save(new Program(null, "abreviation","adress",City.Agadir,"Discription", new Date(),"logo","name", new Date(),pCategory));
		cProgramRepository.findAll().forEach(cnrstp->{
			
			  System.out.println("\n");
			  System.out.println("Abbreviation : "+cnrstp.getAbbreviation());
			  System.out.println("Adress : "+cnrstp.getAdress());
			  System.out.println("Description : "+cnrstp.getDescription());
			  System.out.println("Date : "+cnrstp.getEnddate());
			  System.out.println("City : "+cnrstp.getCity());
			  System.out.println("\n");
			 
		}); 
	}

	@Override
	public Program saveProgram(Program cProgram) {
		// TODO Auto-generated method stub
		return cProgramRepository.save(cProgram);
	}

	@Override
	public Program updateProgramr(Long id) {
		
		return cProgramRepository.findById(id).get();
	}

	@Override
	public void deleteProgram(Long id) {
	this.cProgramRepository.deleteById(id);
		
	}
 
	@Override
	public List<Program> getAllProgram() {
		
		return cProgramRepository.findAll();
	}

	@Override
	public Page<Program> findByNameContains(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
	return cProgramRepository.findByNameContains(mc, pageable);
	}

}
