package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class TransactionReport {
    public void printBalanceReport(double totalSum) {
        System.out.println("Total sum: " + totalSum);
    }

    public void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Transactions for " + monthYear + ": " + count);
    }

    public void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 highest expenses:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public void printHighestExpenseByMonth(Map<String, Transaction> highestAndLowestExpenses) {
        Transaction highestExpense = highestAndLowestExpenses.get("HighestExpense");
        System.out.println("Highest expense:" + highestExpense.getAmount());
    }

    public void printLowestExpenseByMonth(Map<String, Transaction> highestAndLowestExpenses) {
        Transaction lowestExpense = highestAndLowestExpenses.get("LowestExpense");
        System.out.println("Lowest expense:" + lowestExpense.getAmount());
    }

}
