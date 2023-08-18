package com.readCSV;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadingCSV {
	public static void main(String[] args) throws IOException, CsvException {
		File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.csv");
		FileReader fileReader = new FileReader(file);
		CSVReader csvReader = new CSVReader(fileReader);
		List<String[]> dataList = csvReader.readAll();

		for (String[] dataArray : dataList) {
			for (String data : dataArray) {
				System.out.print(data + " ");
			}
			System.out.println("");
		}

	}
}
