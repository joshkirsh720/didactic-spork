
public class SavingsAccount extends BankAccount {


    public SavingsAccount(double a) {
        super(a);
    }

    @Override
    public void withdraw(double a) throws IllegalArgumentException {
        if(getBalance() - a < 0) throw new IllegalArgumentException("New balance would be negative");

        super.withdraw(a);
    }
}