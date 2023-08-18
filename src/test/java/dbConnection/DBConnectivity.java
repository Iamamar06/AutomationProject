package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.utils.TestUtility.*;

public final class DBConnectivity {
	private static Connection connect;
	private static DBConnectivity DBconnect;

	private DBConnectivity() {
		try {
			connect = DriverManager.getConnection(getPropertyFrom("qa.properties", "DB_URL"),
					getPropertyFrom("qa.properties", "DB_USERNAME"), getPropertyFrom("qa.properties", "DB_PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection connectToDBServer() {
		if (DBconnect == null) {
			DBconnect = new DBConnectivity();
		}
		return connect;
	}
}
