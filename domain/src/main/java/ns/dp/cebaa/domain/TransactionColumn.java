package ns.dp.cebaa.domain;

import javax.persistence.*;

@Entity
public class TransactionColumn {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private TransactionFileFormat transactionFileFormat;

    private int index;

    @Enumerated(EnumType.STRING)
    private TransactionColumnName transactionColumnName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionFileFormat getTransactionFileFormat() {
        return transactionFileFormat;
    }

    public void setTransactionFileFormat(TransactionFileFormat transactionFileFormat) {
        this.transactionFileFormat = transactionFileFormat;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TransactionColumnName getTransactionColumnName() {
        return transactionColumnName;
    }

    public void setTransactionColumnName(TransactionColumnName transactionColumnName) {
        this.transactionColumnName = transactionColumnName;
    }
}
