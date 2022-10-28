package com.shivani.lab_5.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.shivani.lab_5.entity.Student;
import com.shivani.lab_5.services.StudentService;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//add mapping for "/list"
	
	@RequestMapping("/list")
  public String listBooks(Model theModel) {
		
		System.out.println("request recieved");
		
		List<Student> theStudent = studentService.findAll();
		
		
		theModel.addAttribute("Student", theStudent);
		
		return "list-student";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student theStudent =new Student();
		
		theModel.addAttribute("Student",theStudent);
		
		return "Student-form";
	}
	
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		
		Student theStudent =studentService.findbyId(theId);
		
		theModel.addAttribute ("Student", theStudent);
		
		return "Student-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id")int id,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("course") String course,@RequestParam("country") String country)
	
	{	System.out.println(id);
	Student theStudent;
	if(id!=0)
	{
		theStudent = studentService.findbyId(id);
		theStudent.setFirstName(firstName);
		theStudent.setLastName(lastName);
		theStudent.setCourse(course);
		theStudent.setCountry(country);
	}else
		theStudent = new Student(id, firstName,lastName,course,country);
	
	studentService.save(theStudent);
		
	return "redirect:/student/list";
}

	@RequestMapping("/delete")
	public String delete(@RequestParam("StudentId")int theId) {
		
		studentService.deleteById(theId);
		
		return "redirect:/student/list";
	}
}