package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dtoClass.BankTransactionDto;
import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.TransactionPK;
import com.example.demo.exception.RecordCreateException;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.bankRepository;

@Service
public class serviceImplementation implements BankTransactionService {

	@Autowired
	private bankRepository transactionService;

	@Override
	public void createBankTransaction(BankTransactionDto bankTransaction) throws RecordCreateException {
		TransactionPK obj = new TransactionPK();
		obj.setBankCode(bankTransaction.getBankCode());
		obj.setTransactionReference(bankTransaction.getTransactionReference());

		if (transactionService.existsById(obj)) {
			throw new RecordCreateException();
		} else {
			BankTransaction bankTransaction1 = new BankTransaction();
			Date currentdate = new Date();
			bankTransaction1.setTransactionPK(obj);
			bankTransaction1.setAccountNo(bankTransaction.getAccountNo());
			bankTransaction1.setAmount(bankTransaction.getAmount());
			bankTransaction1.setCreatedOn(currentdate);
			bankTransaction1.setIban(bankTransaction.getIban());
			bankTransaction1.setAccountName(bankTransaction.getAccountName());
			bankTransaction1.setStatus("PENDING");

			if (transactionService.save(bankTransaction1) == null) {
				throw new RecordCreateException("Failed to create bank transaction");
			}
		}
	}

	@Override
	public List<BankTransaction> getAllBankTransactions() {
		// TODO Auto-generated method stub
//		int a = 10 / 0;
//		System.out.println(a);
		if(transactionService.findAll().isEmpty()) {
			throw new RecordNotFoundException("NO Records in DB,Insert First");
		}else
		return transactionService.findAll();

	}

	@Override
	public ResponseEntity<String> verifyBankTransaction(String transactionReference, String bankCode)
			throws RecordNotFoundException {

		TransactionPK transactionPK = new TransactionPK();
		transactionPK.setBankCode(bankCode);
		transactionPK.setTransactionReference(transactionReference);
		Optional<BankTransaction> optionalTransaction = transactionService.findById(transactionPK);

		if (optionalTransaction.isPresent()) {
			BankTransaction transaction = optionalTransaction.get();

			transaction.setStatus("VERIFIED");

			transactionService.save(transaction);

			return new ResponseEntity<>("Transaction verified successfully", HttpStatus.OK);
		} else
			throw new RecordNotFoundException("Can't Verify,No records found with this primary key");

	}

	@Override
	public ResponseEntity<BankTransaction> getBankDetailsById(String transactionReference, String bankCode)
			throws RecordNotFoundException {
		TransactionPK pk = new TransactionPK();
		pk.setTransactionReference(transactionReference);
		pk.setBankCode(bankCode);
		Optional<BankTransaction> optionalTransaction = transactionService.findById(pk);

		if (optionalTransaction.isEmpty()) {
			throw new RecordNotFoundException("No records found!");
		} else {
			return new ResponseEntity<>(optionalTransaction.get(), HttpStatus.OK);

		}
	}

	@Override
	public ResponseEntity<String> deletebyId(String transactionReference, String bankCode) {

		TransactionPK transactionpk = new TransactionPK();
		transactionpk.setBankCode(bankCode);
		transactionpk.setTransactionReference(transactionReference);

		Optional<BankTransaction> optionalTransaction = transactionService.findById(transactionpk);
		if (optionalTransaction.isEmpty()) {
			throw new RecordNotFoundException("No Such Record Found For Delete With this PK!");
		} else {
			transactionService.deleteById(transactionpk);
			return new ResponseEntity<>("Record Delete Successfully", HttpStatus.OK);
		}
	}

}
