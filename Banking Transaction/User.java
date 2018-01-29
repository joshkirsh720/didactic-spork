
public class User {

    CheckingAccount checking;
    SavingsAccount saving;
    String name;
    int pin;

    public User() {
        name = "SallyJoeBob";
        pin = 1234;
    }
    public User(String n, int p) {
        name = n;
        pin = p;
    }



    public void addSavingsAccount() throws IllegalStateException {
        if(saving != null) throw new IllegalStateException("User already has a savings account");

        saving = new SavingsAccount();
    }
    public void addCheckingAccount() throws IllegalStateException {
        if(checking != null) throw new IllegalStateException("User already has a checkings account");

        checking = new CheckingAccount();
    }

    public String getName() {
        return name;
    }
    public int getPin() {
        return pin;
    }
}