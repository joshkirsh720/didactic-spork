
public class User {

    private CheckingAccount checking;
    private SavingsAccount saving;
    private String name;
    private int pin;

    public User() {
        name = "SallyJoeBob";
        pin = 1234;
    }
    public User(String n, int p, boolean checking, boolean saving) {
        name = n;
        pin = p;
        if(checking) addCheckingAccount(-20);
        if(saving) addSavingsAccount();
    }



    public void addSavingsAccount() throws IllegalStateException {
        if(saving != null) throw new IllegalStateException("User already has a savings account");

        saving = new SavingsAccount(0);
    }
    public void addCheckingAccount(double min) throws IllegalStateException {
        if(checking != null) throw new IllegalStateException("User already has a checkings account");

        checking = new CheckingAccount(0, min);
    }

    public String getName() {
        return name;
    }
    public int getPin() {
        return pin;
    }
    public boolean hasChecking() {
        return checking != null;
    }
    public boolean hasSavings() {
        return saving != null;
    }

    public CheckingAccount getChecking() {
        return checking;
    }

    public SavingsAccount getSavings() {
        return saving;
    }

    public String toString() {
        return name + " " + pin + " " + checking + " " + saving;
    }
}