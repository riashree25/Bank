import java.sql.Timestamp;

/**
 * @author Raj Srivastava
 */
public class TxnData {

    private int       txnId;
    private double    amount;
    private String    txnType;
    private Timestamp time;

    public TxnData(int txnId, double amount, boolean isDebit, Timestamp time) {
        this.txnId = txnId;
        this.amount = amount;
        this.txnType = isDebit ? "Debit" : "Credit";
        this.time = time;
    }

    public int getTxnId() {
        return txnId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTxnType() {
        return txnType;
    }

    public Timestamp getTime() {
        return time;
    }
}
