package org.fasstrackit.demo.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("transaction")

public class TransactionController {
    private final TransactionService transactionService;


    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/product")
    public Transaction getProduct(@PathVariable String product) {
        return transactionService.getProduct(product);
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable long id) {
        return transactionService.getById(id);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable long id) {
        return transactionService.update(transaction, id);
    }

    @PostMapping
    public Transaction addNewTransaction(@RequestBody Transaction transaction) {
        return transactionService.add(transaction);
    }

    @DeleteMapping("/{id}")
    public Transaction deleteById(@PathVariable long id) {
        return transactionService.delete(id);
    }
}
