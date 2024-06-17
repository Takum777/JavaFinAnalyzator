import org.example.Transaction;
import org.example.TransactionAnalyzer;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionAnalyzerTest {
    @Test
    public void testCalculateSum() {
        Transaction transaction1 = new Transaction("2023-01-01", 200.0, "Revenue");
        Transaction transaction2 = new Transaction("2023-01-02", -100.0, "Tax");
        Transaction transaction3 = new Transaction("2023-01-03", 300.0, "Revenue");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        double result = analyzer.calculateSum();

        assertEquals(400.0, result, "Counting up went wrong!");
    }

    @Test
    public void testCountTransactionsByMonth() {
        Transaction transaction1 = new Transaction("01-12-2023", 50.0, "Revenue");
        Transaction transaction2 = new Transaction("15-01-2024", -20.0, "Tax");
        Transaction transaction3 = new Transaction("28-01-2024", 100.0, "Revenue");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        int countDec = analyzer.countTransactionsByMonth("12-2023");
        int countJan = analyzer.countTransactionsByMonth("01-2024");

        assertEquals(2, countJan, "Кількість транзакцій за лютий неправильна");
        assertEquals(1, countDec, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testFindTopExpenses() {
        Transaction t1 = new Transaction("31-12-2023", -150.0, "Cigars");
        Transaction t2 = new Transaction("01-01-2024", -250.0, "Wine");
        Transaction t3 = new Transaction("03-01-2024", 500.0, "Raspberries");
        Transaction t4 = new Transaction("05-01-2024", -70.0, "Strawberries");
        Transaction t5 = new Transaction("08-01-2024", -140.0, "Spaghetti");

        List<Transaction> transactions = Arrays.asList(t1, t2, t3, t4, t5);

        TransactionAnalyzer transactionAnalyzer = new TransactionAnalyzer(transactions);

        List<Transaction> topExpenses = transactionAnalyzer.findTopExpenses();

        assertEquals(4, topExpenses.size());
        assertEquals("Wine", topExpenses.get(0).getDescription());
        assertEquals("Cigars", topExpenses.get(1).getDescription());
    }

}

