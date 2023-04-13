package caseStudy_2;

import java.util.List;

public class SalesAnalyzer {

    // create list of csv data
    private final List<String[]> csvData;

    public SalesAnalyzer(List<String[]> csvData) {
        this.csvData = csvData;
    }

    // A method to calculateTotal profit
    public int calculateTotalProfit() {
        int totalProfit = 0;
        for (int i = 1; i < csvData.size(); i++) {
            totalProfit += Integer.parseInt(csvData.get(i)[8]);
        }
        return totalProfit;
    }

    // a method to get monthWithLowest profit
    public int getMonthWithLowestProfit() {
        int lowestProfit = Integer.MAX_VALUE;
        int lowestProfitMonth = 0;
        for (int i = 1; i < csvData.size(); i++) {
            int profit = Integer.parseInt(csvData.get(i)[8]);
            if (profit < lowestProfit) {
                lowestProfit = profit;
                lowestProfitMonth = Integer.parseInt(csvData.get(i)[0]);
            }
        }
        return lowestProfitMonth;
    }
    // a method to get most bought product
    public String getProductBoughtTheMost(int month) {
        int maxUnits = Integer.MIN_VALUE;
        String maxProduct = "";
        for (int i = 1; i < csvData.size(); i++) {
            if (Integer.parseInt(csvData.get(i)[0]) == month) {
                for (int j = 1; j < 6; j++) {
                    int units = Integer.parseInt(csvData.get(i)[j]);
                    if (units > maxUnits) {
                        maxUnits = units;
                        maxProduct = csvData.get(0)[j];
                    }
                }
            }
        }
        return maxProduct;
    }

    // a method to get total units sold
    public int getTotalUnitsSold(String product) {
        int totalUnitsSold = 0;
        int productIndex = 0;
        for (int i = 0; i < csvData.get(0).length; i++) {
            if (csvData.get(0)[i].equals(product)) {
                productIndex = i;
                break;
            }
        }
        for (int i = 1; i < csvData.size(); i++) {
            totalUnitsSold += Integer.parseInt(csvData.get(i)[productIndex]);
        }
        return totalUnitsSold;
    }
}

