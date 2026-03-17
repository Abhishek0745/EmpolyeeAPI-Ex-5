package in.scalive.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.exceptions.EmpAlreadyExistsException;
import in.scalive.exceptions.NoSuchEmpExistsException;
import in.scalive.model.Emp;
import in.scalive.repository.EmpRepository;

@Service
public class EmpService {
	private EmpRepository empRepo;
	
	@Autowired
     public EmpService(EmpRepository empRepo) {
		this.empRepo=empRepo;
	}
	public String addEmp(Emp e) {
		//1.check name that exist
		Emp existingEmp=empRepo.findByEname(e.getEname()).orElse(null);
		//2.if extist tehn throw exception (EmpAlreadyEtixstexception)
		if(existingEmp!=null) {
			throw new EmpAlreadyExistsException("Emp with the name: "+e.getEname()+" already exists");
		}
		//3.save the emp in DB
		empRepo.save(e);
		//4..return "emp added succesfully"
		return "Emp saved successfully";
	}
	public Emp getEmp(Integer empId) {
		Emp e=empRepo.findById(empId).orElse(null);
		if(e==null) {
			throw new NoSuchEmpExistsException(" No Emp with the id: "+empId);		
		}
		return e;
	}
   public String updateEmp(Emp updatedEmp,Integer empId) {
	   Emp existingEmp=empRepo.findById(empId).orElse(null);
		if(existingEmp==null) {
			throw new NoSuchEmpExistsException(" No Emp with the id: "+empId+" exists");		
   }
		String newName=updatedEmp.getEname();
		if(newName!=null && !newName.equals(existingEmp.getEname())) {
			Optional<Emp>optEmp=empRepo.findByEname(newName);
			if(optEmp.isPresent()) {
				throw new EmpAlreadyExistsException("Emp with the name: "+ updatedEmp.getEname( ) +" already exists");		
			}
			existingEmp.setEname(newName);
		}
		
		if(updatedEmp.getSal()!=null) {
			existingEmp.setSal(updatedEmp.getSal());
		}
		empRepo.save(existingEmp);
		return "Emp Saved successfully";
     }
   }
