package com.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JDBCTests {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	CallableStatement callablestmt = null;
	String host = "localhost";
	String port = "3306";

	@BeforeMethod
	public void launchJdbcDriver() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/sakila", "root", "root");
		stmt = con.createStatement();
	}

	@Test
	public void getTenCities() throws SQLException {
		int count = 0;

		rs = stmt.executeQuery("SELECT city FROM sakila.city ORDER BY city DESC LIMIT 10");

		while (rs.next()) {

			System.out.println(rs.getString("city"));
			count++;
		}

		Assert.assertEquals(count, 10);

	}

	@Test
	public void getAllFilmsWithTitle() throws SQLException {
		int count = 0;
		rs = stmt.executeQuery("SELECT title FROM sakila.film WHERE title LIKE '%airplane%'");

		while (rs.next()) {

			System.out.println(rs.getString("title"));
			count++;

		}

		Assert.assertEquals(count, 2);

	}

	@Test
	public void getHighestPaymentAmount() throws SQLException {
		double currenthighestPaymentAmount = 0;
		rs = stmt.executeQuery("SELECT MAX(amount) FROM payment");

		while (rs.next()) {

			currenthighestPaymentAmount = rs.getDouble(1);

		}

		Assert.assertEquals(currenthighestPaymentAmount, 11.99);

	}

	@Test
	public void getNumberOfRecords() throws SQLException {
		int currentNumberOfRecords = 0;
		rs = stmt.executeQuery("SELECT COUNT(*) FROM customer AS c WHERE c.store_id = 1");

		while (rs.next()) {

			currentNumberOfRecords = rs.getInt(1);

		}

		Assert.assertEquals(currentNumberOfRecords, 326);

	}

	@Test
	public void getAllPyamentfRecordsWithEmailAddress() throws SQLException {
		int currentNumberOfRecords = 0;
		preparedStatement = con.prepareStatement(
				"SELECT p.* FROM payment AS p JOIN customer AS c ON c.customer_id = p.customer_id WHERE c.email = ?");

		preparedStatement.setString(1, "NANCY.THOMAS@sakilacustomer.org");
		rs = preparedStatement.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getInt("payment_id"));
			currentNumberOfRecords++;

		}

		Assert.assertEquals(currentNumberOfRecords, 28);

	}

	@Test
	public void getFilmInfoUsingView() throws SQLException {
		int currentNumberOfRecords = 0;
		preparedStatement = con.prepareStatement("SELECT * FROM film_list WHERE actors LIKE ? ");

		preparedStatement.setString(1, "%" + "BOB FAWCETT" + "%");
		rs = preparedStatement.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getString("title"));
			currentNumberOfRecords++;

		}

		Assert.assertEquals(currentNumberOfRecords, 25);
	}

	@Test
	public void getFourInventoryIdsUsingStoredProcedure() throws SQLException {
		int noOfCurrentIds = 0;
		String filmId = "SET @filmId = (SELECT f.film_id FROM film AS f WHERE f.title = ?)";
		callablestmt = con.prepareCall(filmId);
		callablestmt.setString(1, "Alien Center");
		callablestmt.execute();

		String callProcedure = "CALL film_in_stock(@filmId, ?, ?)";
		callablestmt = con.prepareCall(callProcedure);
		callablestmt.setInt(1, 2);
		callablestmt.registerOutParameter(2, Types.INTEGER);
		rs = callablestmt.executeQuery();
		noOfCurrentIds = callablestmt.getInt(2);

		Assert.assertEquals(noOfCurrentIds, 4);
	}

	@Test
	public void insertANewStoreUsingTransaction() throws SQLException {
		String sql;
		con.setAutoCommit(false);
		sql = "START TRANSACTION";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username)"
				+ " VALUES (?,?,?,?,?,?,?)";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, "John");
		preparedStatement.setString(2, "Doe");
		preparedStatement.setString(3, "18");
		preparedStatement.setString(4, "rando@gmail.com");
		preparedStatement.setString(5, "2");
		preparedStatement.setString(6, "1");
		preparedStatement.setString(7, "newJohn");
		preparedStatement.execute();

		sql = "SET @staffId = LAST_INSERT_ID()";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "INSERT INTO address (address, district, city_id, phone, location)"
				+ " VALUES (?, ?, ?, ?, ST_GeomFromText(?))";

		long value = 7137778888L;

		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, "110 Main");
		preparedStatement.setString(2, "Dime Box");
		preparedStatement.setInt(3, 300);
		preparedStatement.setLong(4, value);
		preparedStatement.setString(5, "POINT(1 1)");
		preparedStatement.execute();

		sql = "SET @addressId = LAST_INSERT_ID()";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "INSERT INTO store (manager_staff_id, address_id)" + " VALUES (@staffId, @addressId);";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "SET @storeId = LAST_INSERT_ID()";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "UPDATE staff SET store_id = @storeId WHERE staff_id = @staffId";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.executeUpdate();

		sql = "ROLLBACK";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

	}

	@Test
	public void updateTimeStamp() throws SQLException {
		String sql;
		sql = "START TRANSACTION";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "SET SQL_SAFE_UPDATES = 0";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "UPDATE store AS s" + " INNER JOIN address AS a ON a.address_id = s.address_id"
				+ " SET s.last_update = CURDATE()" + " WHERE a.address = '110 Main'";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.executeUpdate();

		sql = "SET SQL_SAFE_UPDATES = 1";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "ROLLBACK";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

	}

	@Test
	public void deleteStore() throws SQLException {
		String sql;
		sql = "START TRANSACTION";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "SET SQL_SAFE_UPDATES = 0";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "DELETE s.* " + " FROM store AS s" + " INNER JOIN address AS a ON a.address_id = s.address_id"
				+ " WHERE a.address = '110 Main'";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.executeUpdate();

		sql = "SET SQL_SAFE_UPDATES = 1";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

		sql = "ROLLBACK";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.execute();

	}

	@AfterMethod
	public void quitJdbcDriver() {
		try {

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {

		}

	}
}
