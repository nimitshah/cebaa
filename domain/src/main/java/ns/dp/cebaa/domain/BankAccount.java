package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount {
    @Id
    private long id;

    private String sortCode;

    private String accountNumber;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private AccountType accountType;
}
