package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "bank_transaction")
public class BankTransaction {
    @EmbeddedId
    private TransactionPK transactionPK;

    @Column(name = "account_no", length = 12)
    private String accountNo;

    @Column(precision = 12, scale = 4)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(length = 24)
    private String iban;

    @Column(length = 16)
    private String accountName;

    @Column(length = 8)
    private String status = "PENDING";

    // Constructors, getters, and setters

    public TransactionPK getTransactionPK() {
        return transactionPK;
    }

    public void setTransactionPK(TransactionPK transactionPK) {
        this.transactionPK = transactionPK;
    }

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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
}
