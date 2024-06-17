package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        TransactionCSVReader csvReader = new TransactionCSVReader();
        TransactionReport report = new TransactionReport();
        List<Transaction> transactions = csvReader.readTransactions(filePath);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        double totalSum = analyzer.calculateSum();

        report.printBalanceReport(totalSum);

        String monthYear = "12-2023";
        int transactionsCount = analyzer.countTransactionsByMonth(monthYear);
        report.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction>topExpenses = analyzer.findTopExpenses();
        report.printTopExpensesReport(topExpenses);

        Map<String, Transaction>highestAndLowestExpenses = analyzer.findHighestAndLowestExpensesByMonth(monthYear);
        report.printHighestExpenseByMonth(highestAndLowestExpenses);
        report.printLowestExpenseByMonth(highestAndLowestExpenses);
    }
}