package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoClass.BankTransactionDto;
import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.TransactionPK;
import com.example.demo.exception.RecordCreateException;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.services.BankTransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class BankTransactionController {
	@Autowired
	private BankTransactionService transactionService;

	@PostMapping("/create")
	public List<BankTransaction> createBankTransaction(@Valid @RequestBody BankTransactionDto bankTransaction)
			throws RecordCreateException {
		transactionService.createBankTransaction(bankTransaction);
		return transactionService.getAllBankTransactions();
	}

	@GetMapping("/get")
	public List<BankTransaction> getAllBankTransactions() {
		return transactionService.getAllBankTransactions();
	}

	@PostMapping("/verify/{transactionReference}/{bankCode}")
	public ResponseEntity<String> verifyBankTransaction(@PathVariable String transactionReference,
			@PathVariable String bankCode) throws RecordNotFoundException {

		return transactionService.verifyBankTransaction(transactionReference, bankCode);

	}

	@GetMapping("/getById/{transactionReference}/{bankCode}")
	public ResponseEntity<BankTransaction> findBankTransactionById(@PathVariable String transactionReference,
			@PathVariable String bankCode) throws RecordNotFoundException {

		return transactionService.getBankDetailsById(transactionReference, bankCode);

	}
	@DeleteMapping("/deleteByid/{transactionReference}/{bankCode}")
	public ResponseEntity<String> deletebyId(@PathVariable String transactionReference,
			@PathVariable String bankCode){
		return transactionService.deletebyId(transactionReference,bankCode);
	}
}
