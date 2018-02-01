
public abstract class BankAccount {

    private Transaction[] history;
    private double amount;
    private int historyCounter;

    public BankAccount(double a) {
        history = new Transaction[100];
        historyCounter = 0;
        deposit(a);
    }

    public void withdraw(double a) {
        amount -= a;
        history[historyCounter] = new Transaction("Withdraw", a);
        historyCounter++;
    }

    public void deposit(double a) {
        amount += a;
        history[historyCounter] = new Transaction("Deposit", a);
        historyCounter++;
    }

    public double getBalance() {
        return amount;
    }

    public Transaction[] getHistory() {
        return history;
    }

    public void printHistory() {
        for(Transaction t : history) {
            if(t != null) System.out.println(t.toString());
            else break;
        }
    }
}