package ns.dp.cebaa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private long id;

    private String name;

    private String description;
}
