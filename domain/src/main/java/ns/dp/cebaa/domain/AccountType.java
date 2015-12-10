package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountType {
    @Id
    private long id;

    private String accountType;
}
