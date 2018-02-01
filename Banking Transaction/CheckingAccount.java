
public class CheckingAccount extends BankAccount {
    private double min;

    public CheckingAccount(double a) {
        super(a);
    }
    public CheckingAccount(double a, double m) {
        super(a);
        min = m;
    }

    @Override
    public void withdraw(double a) throws IllegalArgumentException {
        if(getBalance() - a < min) throw new IllegalArgumentException("New balance would be below the minimum balance");

        super.withdraw(a);
    }
}