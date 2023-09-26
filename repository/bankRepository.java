package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.TransactionPK;

public interface bankRepository extends JpaRepository<BankTransaction, TransactionPK>{

}
