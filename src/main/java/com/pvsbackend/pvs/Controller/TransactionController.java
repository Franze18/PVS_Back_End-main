package com.pvsbackend.pvs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.Model.Transaction;
import com.pvsbackend.pvs.NotFoundException.TransactionNotFoundException;
import com.pvsbackend.pvs.Repository.TransactionRepository;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    
    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    // GET ALL TRANSACTIONS
    // http://127.0.0.1:8080/api/v1/transaction/all
    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }

    // GET ONE TRANSACTION
    // http://127.0.0.1:8080/api/v1/transaction/{id}
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    // CREATE TRANSACTION
    // http://127.0.0.1:8080/api/v1/transaction/new
    @PostMapping("/new")
    public String addTransaction(@RequestBody Transaction newTransaction) {
        repo.save(newTransaction);
        return "A new transaction is added!";
    }

    // DELETE TRANSACTION
    // http://127.0.0.1:8080/api/v1/transaction/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        repo.deleteById(id);
        return "Transaction is deleted!";
    }

    // GET TRANSACTIONS BY USER ID
    // http://127.0.0.1:8080/api/v1/transaction/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUserId(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }
}
