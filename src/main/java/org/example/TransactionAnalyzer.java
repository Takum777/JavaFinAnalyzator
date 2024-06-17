package org.example;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


public class TransactionAnalyzer {
    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    private List<Transaction> transactions;
    private DateTimeFormatter dateFormatter;


    public double calculateSum() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public int countTransactionsByMonth(String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public Map<String, Transaction> findHighestAndLowestExpensesByMonth(String monthYear) {

        Map<String, Transaction> expensesMap = new HashMap<>();

        List<Transaction> transactionsForMonth = transactions.stream()
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), dateFormatter);
                    return date.format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(monthYear);
                })
                .collect(Collectors.toList());

        Transaction highestExpense = transactionsForMonth.stream()
                .filter(t -> t.getAmount() < 0) // Consider only expenses
                .min(Comparator.comparing(Transaction::getAmount))
                .orElse(null);

        Transaction lowestExpense = transactionsForMonth.stream()
                .filter(t -> t.getAmount() < 0) // Consider only expenses
                .max(Comparator.comparing(Transaction::getAmount))
                .orElse(null);

        expensesMap.put("HighestExpense", highestExpense);
        expensesMap.put("LowestExpense", lowestExpense);

        return expensesMap;
    }

}
