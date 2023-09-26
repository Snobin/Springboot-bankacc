package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransactionPK {

	public TransactionPK() {

	}

	public TransactionPK(String transactionReference, String bankCode) {
		super();
		this.transactionReference = transactionReference;
		this.bankCode = bankCode;
	}

	@Column(name = "transaction_reference", length = 12)
	private String transactionReference;

	@Column(name = "bank_code", length = 11)
	private String bankCode;

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

}