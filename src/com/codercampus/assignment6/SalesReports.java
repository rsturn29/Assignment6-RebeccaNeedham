package com.codercampus.assignment6;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesReports {
	String filename = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NumberFormatException, ParseException {
		System.out.println();
		System.out.println("MODEL 3 Yearly Report");
		System.out.println("---------------------");
		FileService fileService = new FileService();
		List<SalesModel> model3Info = fileService.getDateAndSaleInfoFromFile("model3.csv");

		totalSalesForYear(model3Info);
		maxSalesData(model3Info);
		minSalesData(model3Info);
		System.out.println();
		System.out.println("MODEL S Yearly Report");
		System.out.println("---------------------");
		FileService fileService2 = new FileService();
		List<SalesModel> modelSInfo = fileService2.getDateAndSaleInfoFromFile("modelS.csv");

		totalSalesForYear(modelSInfo);
		maxSalesData(modelSInfo);
		minSalesData(modelSInfo);

		System.out.println();
		System.out.println("MODEL X Yearly Report");
		System.out.println("---------------------");
		FileService fileService3 = new FileService();
		List<SalesModel> modelXInfo = fileService3.getDateAndSaleInfoFromFile("modelX.csv");

		totalSalesForYear(modelXInfo);
		maxSalesData(modelXInfo);
		minSalesData(modelXInfo);

		
	}

	private static void totalSalesForYear(List<SalesModel> filename) {
		Map<Integer, Integer> salesInfoByYear = filename.stream().collect(
				Collectors.groupingBy(x -> x.getDate().getYear(), Collectors.summingInt(SalesModel::getSales)));

		salesInfoByYear.forEach((year, totals) -> System.out
				.println("Year = " + String.format("%01d", year % 100) + " Sales Total = " + totals));
	}

	private static void maxSalesData(List<SalesModel> filename) {
		Optional<SalesModel> maxSalesData = filename.stream()
				.max(java.util.Comparator.comparingInt(SalesModel::getSales));

		if (maxSalesData.isPresent()) {
			Date date = maxSalesData.get().getDate();
			int year = date.getYear() % 100;
			System.out.println("Best Month was (yy-MM) : " + year + "-" + (date.getMonth()+1));
		} else {
			System.out.println("Nothing found ");
		}
	}

	private static void minSalesData(List<SalesModel> filename) {
		Optional<SalesModel> minSalesData = filename.stream()
				.min(java.util.Comparator.comparingInt(SalesModel::getSales));

		if (minSalesData.isPresent()) {
			Date date = minSalesData.get().getDate();
			int year = date.getYear() % 100;
			System.out.println("Worst Month was (yy-MM) : " + year + "-" + (date.getMonth()+1));
		} else {
			System.out.println("Nothing found ");
		}
	}

}
