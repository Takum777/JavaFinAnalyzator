import org.example.Transaction;
import org.example.TransactionCSVReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TransactionCSVReaderTest {
    @Test
    public void testReadTransactions() {

        TransactionCSVReader csvReader = new TransactionCSVReader();

        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<Transaction> transactions = csvReader.readTransactions(filePath);

        assertNotNull(transactions);

        assertFalse(transactions.isEmpty());

        assertEquals(26, transactions.size());

        Transaction firstTransaction = transactions.get(0);
        assertEquals("Сільпо", firstTransaction.getDescription());
        assertEquals(-7850.0, firstTransaction.getAmount(), 0.001);
    }
}
