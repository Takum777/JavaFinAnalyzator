package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Transaction {

    @Getter
    @Setter
    private String date;

    @Getter
    @Setter
    private double amount;

    @Getter
    @Setter
    private String description;

    // Getters
    // Setters
    // toString метод для зручності виводу
    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

}
