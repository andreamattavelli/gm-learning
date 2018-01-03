package smell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

	public void saveOrder(Order order) throws SQLException {
		Connection conn = createConnection();

		PreparedStatement orderStatement = createQuery(conn);

		populateQuery(orderStatement, order);

		orderStatement.executeUpdate();
	}

	private PreparedStatement createQuery(Connection conn) throws SQLException {
		PreparedStatement orderStatement = null;
		String sql = null;
		sql = new StringBuffer()
				.append("INSERT INTO T_ORDER ")
				.append("(AUTHORIZATION_CODE, ")
				.append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) ")
				.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
				.toString();

		orderStatement = conn.prepareStatement(sql);
		return orderStatement;
	}

	private void populateQuery(PreparedStatement orderStatement, Order order) {

	}

	private Connection createConnection() {
		return null;
	}
	
}
