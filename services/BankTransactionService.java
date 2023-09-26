package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dtoClass.BankTransactionDto;
import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.TransactionPK;
import com.example.demo.exception.RecordCreateException;
import com.example.demo.exception.RecordNotFoundException;

public interface BankTransactionService {

	void createBankTransaction(BankTransactionDto bankTransaction) throws RecordCreateException;

	List<BankTransaction> getAllBankTransactions();

	ResponseEntity<String> verifyBankTransaction(String transactionReference, String bankCode) throws RecordNotFoundException;

	ResponseEntity<BankTransaction> getBankDetailsById(String transactionReference, String bankCode)
			throws RecordNotFoundException;

	ResponseEntity<String> deletebyId(String transactionReference,String bankCode);
}
