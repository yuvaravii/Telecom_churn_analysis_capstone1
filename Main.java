package caseStudy_2;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        List<String[]> csvData = csvReader.readCsvData("C:/Users/ravishankar.j/OneDrive - Merkle Inc/Trainings/JavaTraining/Majrul Content/company-sales.csv");
        SalesAnalyzer salesAnalyzer = new SalesAnalyzer(csvData);

        // Display total profit made from the sales for the whole year
        int totalProfit = salesAnalyzer.calculateTotalProfit();
        System.out.println("Total profit made from the sales for the whole year: " + totalProfit);

        // Display the month in which there was lowest profit made from the sales
        int monthWithLowestProfit = salesAnalyzer.getMonthWithLowestProfit();
        System.out.println("Month with lowest profit made from the sales: " + monthWithLowestProfit);

        // Display which product was bought the most in a particular month (for ex: June)
        String productBoughtTheMost = salesAnalyzer.getProductBoughtTheMost(6);
        System.out.println("Product bought the most in June: " + productBoughtTheMost);

        // Display how many units of a product has been sold last year (for ex: shampoo)
        int totalUnitsSold = salesAnalyzer.getTotalUnitsSold("shampoo");
        System.out.println("Total units of shampoo sold last year: " + totalUnitsSold);
    }

}
