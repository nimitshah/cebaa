package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    private long id;

    private String name;
}
