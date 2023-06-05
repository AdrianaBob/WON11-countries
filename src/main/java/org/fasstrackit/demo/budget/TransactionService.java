package org.fasstrackit.demo.budget;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor

public class TransactionService {
    private final List<Transaction> transactionList = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Transaction Service");

    }

    public List<Transaction> getAllTransactions() {
        return transactionList;
    }

    public Transaction getProduct(String product) {
        return getAllTransactions().stream()
                .filter(transaction -> transaction.getProduct() == product).filter(transaction -> transaction.getMinAmount() == transaction.minAmount).filter(transaction -> transaction.getMaxAmount() == transaction.maxAmount)
                .findFirst()
                .orElse(null);
    }


    public Transaction getById(long id) {
        return getAllTransactions().stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Transaction add(Transaction transaction) {
        transactionList.add(transaction);
        return transaction;
    }

    public Transaction delete(long id) {
        Transaction transaction = getById(id);
        transactionList.remove(transaction);
        return transaction;
    }

    public Transaction update(Transaction transaction, long id) {
        Transaction existingTransaction = delete(id);
        return add(Transaction.builder()
                .id(id)
                .product(existingTransaction.getProduct())
                .BUY(transaction.getBUY())
                .SELL(transaction.getSELL())
                .minAmount(transaction.getMinAmount())
                .maxAmount(transaction.getMaxAmount())
                .build());
    }
}
