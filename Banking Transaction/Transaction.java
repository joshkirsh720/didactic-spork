public class Transaction {
    public final String type;
    public final double amount;

    public Transaction(String t, double a) {
        type = t;
        amount = a;
    }

    @Override
    public String toString() {
        return type + " " + amount;
    }
}