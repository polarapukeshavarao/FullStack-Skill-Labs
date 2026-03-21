package DemoOnSpring.DemoOnSpringS7;

import java.util.List;

public class Employee1 {
	int empId;
	String empName;
	double empsalary;
	boolean empActive;
	List<String> empSkills;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}
	public boolean isEmpActive() {
		return empActive;
	}
	public void setEmpActive(boolean empActive) {
		this.empActive = empActive;
	}
	public List<String> getEmpSkills() {
		return empSkills;
	}
	public void setEmpSkills(List<String> empSkills) {
		this.empSkills = empSkills;
	}
	//create tostring() method to display the output
	@Override
	public String toString() {
		return "Employee Id=" + empId +"\n"+"Employee Name="+empName+"\n"+"Employee Salary="+empsalary+"\n"+"Employee Active="+empActive+"\n"+"Employee Skills="+empSkills+"\n";
	}
	

}
