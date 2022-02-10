package com.JDBC;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.PreparedStatement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class JdbcTests {
	JdbcConncections jdbc;

	@Test
	public void canGetTenCities() {
		int expectedCities = 10;
		int numberOfCities = jdbc.getTenCities();
		Assert.assertEquals(numberOfCities, expectedCities);
	}

	@Test
	public void canGetAllFilmsWithAirplanes() {
		String titleFilm = jdbc.getAllFilmsWithAirplaneTitle();
		String expectedFilmTitle = "AIRPLANE";
		Assert.assertTrue(titleFilm.contains(expectedFilmTitle));
	}

	@Test
	public void canGetHighestPaymentAmount() {
		double actualAmount = jdbc.getHighestPaymentAmount();
		double expectedAmount = 11.99;
		Assert.assertEquals(actualAmount, expectedAmount);
	}

	@Test
	public void canGetNumberOfRecords() {
		int actualRecords = jdbc.getNumberOfRecordsForStoreOne();
		System.out.println(actualRecords);
	}

	@Test
	public void canGetAllPaymentRecordsWithEmail() {
		String expectedEmail = "NANCY.THOMAS@sakilacustomer.org";
		String actualEmail = jdbc.getAllPaymentRecordsWithEmail();
		Assert.assertEquals(actualEmail, expectedEmail);
	}

	@Test
	public void canGetFilmForActor() {
		String expectedInfo = "Action: DARN FORRESTER; Animation: DARES PLUTO,"
				+ " LAWLESS VISION, OSCAR GOLD; Children: CIRCUS YOUTH; "
				+ "Classics: DYNAMITE TARZAN; Comedy: CONTROL ANTHEM, HATE HANDICAP, "
				+ "SADDLE ANTITRUST; Documentary: ADAPTATION HOLES, PELICAN COMFORTS; "
				+ "Drama: JACKET FRISCO, SCORPION APOLLO; Family: HOMICIDE PEACH; Games: "
				+ "DAZED PUNK; Horror: ACE GOLDFINGER; Music: PERSONAL LADYBUGS, RUNNER MADIGAN, "
				+ "TAXI KICK; New: CHINATOWN GLADIATOR, JUMANJI BLADE, RUN PACIFIC; "
				+ "Sci-Fi: RAGING AIRPLANE; Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE";
		String actualInfo = jdbc.getFilmInfoForActor();
		Assert.assertEquals(actualInfo, expectedInfo);
	}

	@Test
	public void canGetFourIDsForStoreTwo() {
		int[] expectedFilmCount = {73, 74, 75, 76};
		int[] actualFilmCount = jdbc.getFourInventoryIDsForFilmAtStoreTwo();
		Assert.assertEquals(actualFilmCount[0], expectedFilmCount[0]);
		Assert.assertEquals(actualFilmCount[1], expectedFilmCount[1]);
		Assert.assertEquals(actualFilmCount[2], expectedFilmCount[2]);
		Assert.assertEquals(actualFilmCount[3], expectedFilmCount[3]);
	}

	@Test
	public void canInsertNewStoreAndUpdateTimestampOfStore() {
		PreparedStatement insertStoreStatement = jdbc.insertNewStore();
		PreparedStatement updateTimestampStatement = jdbc.updateTimestampOfStore();
		Assert.assertNotNull(insertStoreStatement);
		Assert.assertNotNull(updateTimestampStatement);
	}

	@Test
	public void canDeleteStore() {
		PreparedStatement deleteStoreStatement = jdbc.deleteNewStore();
		Assert.assertNotNull(deleteStoreStatement);
	}

	@BeforeMethod
	public void beforeMethod() {
		jdbc = new JdbcConncections();
	}

	@AfterMethod
	public void afterMethod() {
		jdbc.closeJDBC();
	}
}