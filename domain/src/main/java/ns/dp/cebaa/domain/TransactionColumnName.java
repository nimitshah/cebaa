package ns.dp.cebaa.domain;

/**
 * Created by nimit on 17/12/2015.
 */
public enum TransactionColumnName {
    POSTING_DATE,
    TRANSACTION_DATE,
    DESCRIPTION,
    AMOUNT,
    REFERENCE_NUMBER,
    PAYMENT_TYPE;

    @Override
    public String toString() {
        return name();
    }
}
