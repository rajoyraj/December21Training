package com.JDBC;

import java.sql.*;

public class JdbcConncections {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet queryResult = null;
	private CallableStatement callStatement = null;
	final String host = "localhost";
	final String port = "3306";

	public JdbcConncections() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/sakila", "root", "root");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getTenCities() {
		int cities = 0;
		try {
			queryResult = statement.executeQuery("SELECT city FROM sakila.city ORDER BY city DESC LIMIT 10;");
			while (queryResult.next()) {
				cities++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}

	public String getAllFilmsWithAirplaneTitle() {
		String title = "";
		try {
			queryResult = statement.executeQuery("SELECT * FROM sakila.film WHERE title LIKE '%airplane%';");
			while (queryResult.next()) {
				title = queryResult.getString("title");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return title;
	}

	public double getHighestPaymentAmount() {
		double highestAmount = 0;
		try {
			queryResult = statement.executeQuery("SELECT MAX(amount) FROM sakila.payment;");
			while (queryResult.next()) {
				highestAmount = queryResult.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return highestAmount;
	}

	public int getNumberOfRecordsForStoreOne() {
		int numberOfRecords = 0;
		try {
			queryResult = statement.executeQuery("SELECT count(*) FROM sakila.customer WHERE store_id=1;");
			while (queryResult.next()) {
				numberOfRecords = queryResult.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRecords;
	}

	public String getAllPaymentRecordsWithEmail() {
		String customerEmail = "";
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM sakila.payment INNER JOIN sakila.customer ON customer.customer_id = payment.customer_id WHERE sakila.customer.email = ?;");
			preparedStatement.setString(1, "NANCY.THOMAS@sakilacustomer.org");
			queryResult = preparedStatement.executeQuery();

			while (queryResult.next()) {
				customerEmail = queryResult.getString("email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerEmail;
	}

	public String getFilmInfoForActor() {
		String film_info = "";
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT film_info FROM sakila.actor_info WHERE first_name = ? AND last_name = ?;");
			preparedStatement.setString(1, "Bob");
			preparedStatement.setString(2, "Fawcett");
			queryResult = preparedStatement.executeQuery();
			while (queryResult.next()) {
				film_info = queryResult.getString("film_info");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film_info;
	}

	public int[] getFourInventoryIDsForFilmAtStoreTwo() {
		int count = 0;
		int[] filmCount = new int[4];
		try {
			callStatement = connection.prepareCall("CALL film_in_stock((SELECT film_id FROM film WHERE title=?),"
					+ " (SELECT store_id FROM store WHERE store_id=?), ?);");
			callStatement.setString(1, "Alien Center");
			callStatement.setInt(2, 2);
			callStatement.registerOutParameter(3, Types.INTEGER);
			queryResult = callStatement.executeQuery();

			while (queryResult.next()) {
				filmCount[count] = queryResult.getInt(1);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmCount;
	}

	public PreparedStatement insertNewStore() {
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection
					.prepareStatement("INSERT INTO sakila.staff(first_name, last_name, address_id, store_id, username)"
							+ "VALUES(?, ?, ?, ?, ?);");
			preparedStatement.setString(1, "Saul");
			preparedStatement.setString(2, "Dominguez");
			preparedStatement.setInt(3, 5);
			preparedStatement.setInt(4, 2);
			preparedStatement.setString(5, "salguez");
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement("INSERT INTO sakila.store(manager_staff_id, address_id) "
					+ "VALUES((SELECT staff_id FROM sakila.staff WHERE username=?),?);");
			preparedStatement.setString(1, "salguez");
			preparedStatement.setInt(2, 5);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement("UPDATE sakila.staff SET store_id=? WHERE staff_id=?;");
			preparedStatement.setInt(1, 5);
			preparedStatement.setInt(2, 7);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return preparedStatement;
	}

	public PreparedStatement updateTimestampOfStore() {
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection
					.prepareStatement("UPDATE sakila.store SET last_update=NOW() WHERE store_id=?;");
			preparedStatement.setInt(1, 5);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return preparedStatement;
	}

	public PreparedStatement deleteNewStore() {
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("UPDATE sakila.staff SET store_id=? WHERE store_id=?;");
			preparedStatement.setInt(1, 2);
			preparedStatement.setInt(2, 5);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement("DELETE FROM sakila.store WHERE store_id=?;");
			preparedStatement.setInt(1, 5);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return preparedStatement;
	}

	public void closeJDBC() {
		try {
			if (queryResult != null) {
				queryResult.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {

		}
	}
}