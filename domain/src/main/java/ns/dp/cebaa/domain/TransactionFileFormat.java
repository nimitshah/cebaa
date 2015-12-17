package ns.dp.cebaa.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TransactionFileFormat {
    public enum SeparationType { COMMA, SPACE };
    @Id
    private long id;

    @OneToOne
    private BankAccount bankAccount;

    @Enumerated(EnumType.STRING)
    private SeparationType separation;

    @OneToMany
    private Set<TransactionColumn> fields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public SeparationType getSeparation() {
        return separation;
    }

    public void setSeparation(SeparationType separation) {
        this.separation = separation;
    }

    public Set<TransactionColumn> getFields() {
        return fields;
    }

    public void setFields(Set<TransactionColumn> fields) {
        this.fields = fields;
    }
}
