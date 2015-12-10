package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nimit on 10/12/2015.
 */
@Entity
public class Bank {
    @Id
    private long id;

    private String name;
}
