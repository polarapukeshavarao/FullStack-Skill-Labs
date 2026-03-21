package RestfulCURD.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RestfulCURD.Model.Student;

@RestController
@RequestMapping("/students") //base url for this class
public class StudentController {
	@GetMapping("/{id}")
	public Student getData(@PathVariable int id)
	{
		Student s=new Student();
		s.setId(id);
		s.setName("Keshava");
		s.setCgpa(9.5);
		s.setDropout(false);
		return s;
	}
	@PostMapping("/insert")
	public String insertStudent(@RequestBody Student s)
	{
		return "Student data added \n"+
	            "Student is = "+s.getId()+"\n"+
				"Student Name = "+s.getName()+"\n"+
	            "Student CGPA = "+s.getCgpa()+"\n"+
				"Student Dropout status = "+s.isDropout();
		
		
	}
	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable int id,@RequestBody Student s)
	{
		return "Student Id updated = "+id+"\n"+
				"Student Name = "+s.getName()+"\n"+
	            "Student CGPA = "+s.getCgpa()+"\n"+
				"Student Dropout status = "+s.isDropout();
		
		
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		return ResponseEntity.ok("Student Data delete"+id);
		
	}
	
	

}
