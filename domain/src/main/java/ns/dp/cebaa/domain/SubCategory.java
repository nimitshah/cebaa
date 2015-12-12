package ns.dp.cebaa.domain;

import javax.persistence.*;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String name;
}
