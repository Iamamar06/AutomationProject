package dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	private StudentPojo student;
	private Connection connect;
	private Statement statement;
	private ResultSet result;

	public StudentDAO() {
		connect = DBConnectivity.connectToDBServer();
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public StudentPojo getStudentDatabyId(int id) {
		try {
			//System.out.println("SELECT * FROM SR_DEV.student where id = "+id+";");
			result = statement.executeQuery("SELECT * FROM SR_DEV.student where id = "+id+";");
			while (result.next()) {
				student = new StudentPojo(result.getString(1), result.getInt(2), result.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;

	}

	public boolean createStudentData(StudentPojo student) {
		boolean status = false;
		try {
			status = statement.execute("INSERT INTO SR_DEV.student (name, id, marks) VALUES('" + student.getName()
					+ "', " + student.getId() + ", " + student.getMarks() + ");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean updateStudentDataById(StudentPojo student, int id) {
		boolean status = false;
		try {
			status = statement.execute("UPDATE SR_DEV.student SET name='" + student.getName() + "', id="
					+ student.getId() + ", marks=" + student.getMarks() + " where id =" + id + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public boolean deleteStudentDataOfID(int id) {
		boolean status = false;
		try {
			status = statement.execute("DELETE FROM SR_DEV.student WHERE id=" + id + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}
}
