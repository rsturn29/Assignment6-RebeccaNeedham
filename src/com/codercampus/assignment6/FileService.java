package com.codercampus.assignment6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class FileService {
	public List<SalesModel> getDateAndSaleInfoFromFile(String filename) throws NumberFormatException, ParseException{
	BufferedReader reader = null;
	File file = new File(filename) ;
	List <SalesModel> salesModels = new ArrayList<>();
	try {
		
		int i = 0;
		String currentLine = null;
		reader = new BufferedReader(new FileReader(file));
		int skipLine = 0;
		while ((currentLine = reader.readLine()) != null) {
			if (skipLine == 0) {
				skipLine++;
				continue;
			} 
			String[] lineData = currentLine.split(",");
			DateFormat df = new SimpleDateFormat("MMM-yy");
			Date dt = df.parse(lineData[0]);

			SalesModel saleModel = new SalesModel( dt, Integer.parseInt(lineData[1]));
			salesModels.add(saleModel);
		}
		return salesModels;

		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return null;
}


}