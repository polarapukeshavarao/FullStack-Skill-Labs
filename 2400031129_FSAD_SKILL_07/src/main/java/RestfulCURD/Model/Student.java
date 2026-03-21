package RestfulCURD.Model;

public class Student {
	private int id;
	private String name;
	private double cgpa;
	private boolean dropout;
	public Student()
	{
		//this is default constructor
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public boolean isDropout() {
		return dropout;
	}
	public void setDropout(boolean dropout) {
		this.dropout = dropout;
	}
	
	

}
