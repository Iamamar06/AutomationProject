package dbConnection;

public class StudentPojo {
	private String name;
	private int id;
	private int marks;
	public StudentPojo(String name, int id, int marks) {
		super();
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "StudentPojo [name=" + name + ", id=" + id + ", marks=" + marks + "]";
	}
	
}
