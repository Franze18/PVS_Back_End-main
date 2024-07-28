package com.pvsbackend.pvs.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pvsbackend.pvs.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
}
