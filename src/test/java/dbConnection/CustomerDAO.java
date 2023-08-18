package dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.pojo.TR_Customer_POJO;

public class CustomerDAO {
	private Connection connect;
	private Statement statement;
	private ResultSet result;
	private TR_Customer_POJO tr_customer_pojo;

	public CustomerDAO() {
		connect = DBConnectivity.connectToDBServer();
	}

	public TR_Customer_POJO getCustomerDataFromDB(int customerId) {
		try {
			statement = connect.createStatement();
			result = statement.executeQuery("SELECT * FROM SR_DEV.tr_customer WHERE id=" + customerId + ";");
			while (result.next()) {
				tr_customer_pojo = new TR_Customer_POJO(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getInt(8), result.getInt(9), result.getString(10), result.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tr_customer_pojo;
	}
}
