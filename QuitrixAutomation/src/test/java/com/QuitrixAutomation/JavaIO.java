package com.QuitrixAutomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import Framework.Bass;

public class JavaIO {

	private CSVReader csvReaderBuilder() throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\basses.csv");
		FileReader filereader = new FileReader(file);
		return new CSVReaderBuilder(filereader).withSkipLines(1).build();

	}

	@Test
	public void readCsvIntoHashmap() {
		try {
			CSVReader reader = csvReaderBuilder();
			String[] nextline;
			HashMap<String, String> makeandmodels = new HashMap<String, String>();

			try {
				while ((nextline = reader.readNext()) != null) {

					String make = nextline[0];
					String model = nextline[1];

					makeandmodels.put(make, model);

					/*
					 * for (String cell : nextline) { System.out.print(cell + "\t"); }
					 * System.out.println();
					 */

				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void canHydrateFromCsv() throws FileNotFoundException {
		// List<Bass> basses = new ArrayList<Bass>();
		try {
			CSVReader reader = csvReaderBuilder();
			String[] records;

			try {
				while ((records = reader.readNext()) != null) {

					String make = records[0];
					String model = records[1];
					int stringCount = Integer.parseInt(records[2]);
					Bass bass = new Bass();
					bass.setMake(make);
					bass.setModel(model);
					bass.setStringCount(stringCount);
					System.out.println(bass.getMake() + "\t" + bass.getModel() + "\t" + bass.getStringCount());
					// basses.add(bass);
					// System.out.println(basses.get(0).getModel());

				}
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			} finally {

			}
		} finally {

		}
	}
}
