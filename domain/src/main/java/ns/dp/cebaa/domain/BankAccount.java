package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Currency;

@Entity
public class BankAccount {
    @Id
    private long id;

    private String sortCode;

    private String accountNumber;

    @ManyToOne
    private Bank bank;

    private String accountType;

    private String accountHolder;

    private String currency;

    private LocalDate openingDate;

    private LocalDate closingDate;
}
