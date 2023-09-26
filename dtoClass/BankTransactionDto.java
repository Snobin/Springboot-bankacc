package com.example.demo.dtoClass;

import java.math.BigDecimal;
//import java.sql.Date;

import com.example.demo.customValidation.CustomibanSize;

import jakarta.persistence.Column;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BankTransactionDto {

	@NotNull
	@Size(min = 8, max = 12)
	@Column(name = "account_no", length = 12)
	private String accountNo;

	@NotNull
	@Digits(integer = 12, fraction = 4)
	@Column(name = "amount", precision = 16, scale = 4)
	private BigDecimal amount;

	@NotNull
	@Size(min = 12, max = 12)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	@Column(name = "transaction_reference", length = 12, unique = true)
	private String transactionReference;

//    @NotNull
//    @Column(name = "created_on")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdOn;

	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "bank_code", length = 11, unique = true)
	private String bankCode;

	@NotNull
	@CustomibanSize(key = "bankTransactionDto.iban.Key", message = "{bankTransactionDto.CustomibanSize.msg}")
	@Column(name = "iban", length = 24)
	private String iban;

	@NotNull
	@Size(max = 16)
	@Pattern(regexp = "^[a-zA-Z ]+$")
	@Column(name = "account_name", length = 16)
	private String accountName;

	@NotNull
	@Column(name = "status", length = 8)
	private String status = "PENDING";

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}
//
//	public Date getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(Date createdOn) {
//		this.createdOn = createdOn;
//	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	
//	 @Override
//		public String toString() {
//			return "dtoClass [accountNo=" + accountNo + ", amount=" + amount + ", transactionReference="
//					+ transactionReference + ", createdOn=" + createdOn + ", bankCode=" + bankCode + ", iban=" + iban
//					+ ", accountName=" + accountName + ", status=" + status + "]";
//		}
}
