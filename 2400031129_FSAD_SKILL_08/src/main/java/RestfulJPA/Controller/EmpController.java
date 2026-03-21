package RestfulJPA.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RestfulJPA.Model.Employee;
import RestfulJPA.Repository.EmpRepository;
// To connect to Vite-React.5173 is vit-React Port number
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired    //It is used to inject EmpRepository interface.
	EmpRepository empRepository;
	//To Save the data in the database using PostMapping.
	@PostMapping("/save")
	public ResponseEntity<String> addEmployee(@RequestBody Employee e)  //ResponseEntity<String> is used to written the string.
	{
		Employee ob=empRepository.save(e);   // To save the data.
		return ResponseEntity.ok("Record inserted successfully");
		
	}
	// ==================
	       // GET -  GET employee by ID
	// ===================
	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int eid)
	{
		Optional<Employee> e=empRepository.findById(eid);
		if(e.isPresent())
		{
			return ResponseEntity.ok(e.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	//=========
	// GET all employees
	//============
	@GetMapping("/all")
	public List<Employee> getAllEmployees()
	{
		return empRepository.findAll();
	}
	// ===============
	// PUT -Update employee data
	// ===============
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id,@RequestBody Employee e)
	{
		Optional<Employee> existingEmp=empRepository.findById(id);
		if(existingEmp.isPresent())
		{
			//first get the record
			Employee updateEmp=existingEmp.get();
			updateEmp.setEname(e.getEname());
			empRepository.save(updateEmp);
			return ResponseEntity.ok("Record updated successfully");
		}
		else
		{
			return ResponseEntity.ok("Record Not available");
			
		}
		
	}
	//===============
	//Delete -Delete Employee
	//================
	@DeleteMapping("/{eid}")
	public ResponseEntity<String> deleteEmp(@PathVariable int eid)
	{
		if(empRepository.existsById(eid))
		{
			empRepository.deleteById(eid);
			return ResponseEntity.ok("Record deleted successfully");
			
		}
		else
		{
			return ResponseEntity.ok("Record Not Available");
		}
	}

}
