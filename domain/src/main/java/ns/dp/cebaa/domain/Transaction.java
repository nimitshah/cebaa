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
}
