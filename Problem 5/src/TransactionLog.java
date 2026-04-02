public class TransactionLog {
    String accountId;
    String details;

    public TransactionLog(String accountId, String details) {
        this.accountId = accountId;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Acc: " + accountId + " [" + details + "]";
    }
}