package dbConnection;


public class Runner {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		StudentDAO studentDAO = new StudentDAO();
		StudentPojo st1 = new StudentPojo("Shantanu", 12, 40);
		boolean createStudent = studentDAO.createStudentData(st1);
		System.out.println(studentDAO.getStudentDatabyId(12));
		st1 = new StudentPojo("ShantanuUpdated", 12, 99);
		boolean updateStudentData = studentDAO.updateStudentDataById(st1, 12);
		System.out.println(studentDAO.getStudentDatabyId(12));
		boolean deleteData = studentDAO.deleteStudentDataOfID(12);
//		Thread.sleep(30000);
		StudentDAO studentDAO2 = new StudentDAO();
		System.out.println(studentDAO2.getStudentDatabyId(12));
	}
}
