package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Transaction {
    public enum DebitCredit {DR, CR};
    @Id
    private long id;

    private LocalDate date;

    private String description;

    private double amount;

    private DebitCredit debitCredit;

    @ManyToOne
    private BankAccount bankAccount;

    @ManyToOne
    private Category category;
}
