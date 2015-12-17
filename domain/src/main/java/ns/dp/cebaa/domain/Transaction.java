package ns.dp.cebaa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;

    /**
     * in credit card this date will be later than transaction date.
     * i.e. date on which card company realized transaction.
     */
    private LocalDate postingDate;

    private LocalDate transactionDate;

    private String description;

    private double amount;

    private String referenceNumber;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToOne
    private BankAccount bankAccount;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany
    private Set<SubCategory> subCategories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
