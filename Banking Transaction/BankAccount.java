
public abstract class BankAccount {

    private Transaction[] history;
    private double amount;
    private int historyCounter;

    public BankAccount(double a) {
        amount = a;
        history = new Transaction[100];
        historyCounter = 0;
    }

    public void withdraw(double a) {
        amount -= a;
        history[historyCounter] = new Transaction("withdraw", a);
        historyCounter++;
    }

    public void deposit(double a) {
        amount += a;
        history[historyCounter] = new Transaction("deposit", a);
        historyCounter++;
    }
}