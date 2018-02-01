import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String id;
        int pin;
        Scanner scan = new Scanner(System.in);
        User[] userList = {new User("Josh", 5432, true, false), new User("Vikram", 4256, false, true), new User("Farrell", 3574, true, true)};
        Bank bank = new Bank(userList);

        System.out.println("Welcome to the Bank!  Today's date is " + (new Date()));

        System.out.print("Please enter your User ID: ");
        id = scan.next();
        System.out.print("Please enter your PIN: ");
        pin = scan.nextInt();

        User user = bank.logIn(id, pin);

        while(true) {
            System.out.println("P. Summary Statement\n" +
                    (user.hasChecking() ? "C. Checking Account\n" : "No Checking Account Found\n") +
                    (user.hasSavings() ? "S. Savings Account\n" : "No Savings Account Found\n") +
                    "Q. Quit\n");

            String choice = scan.next();

            if (choice.equals("P")) {
                System.out.println("Checking Account: ");
                if (user.hasChecking()) user.getChecking().printHistory();
                System.out.println("Savings Account: ");
                if (user.hasSavings()) user.getSavings().printHistory();
            }
            else if(choice.equals("C") && user.hasChecking()) {
                System.out.println("W. Withdraw\nD. Deposit");
                String letter = scan.next();
                System.out.println("How much?");
                double amount = scan.nextDouble();

                if(letter.equals("W")) {
                    try {
                        user.getChecking().withdraw(amount);
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("You can't do that: " + e.getMessage());
                    }
                }
                else if(letter.equals("D")) {
                    user.getChecking().deposit(amount);
                }
            }
            else if(choice.equals("S") && user.hasSavings()) {
                System.out.println("W. Withdraw\nD. Deposit");
                String letter = scan.next();
                System.out.println("How much?");
                double amount = scan.nextDouble();

                if(letter.equals("W")) {
                    try {
                        user.getSavings().withdraw(amount);
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("You can't do that " + e.getMessage());
                    }
                }
                else if(letter.equals("D")) {
                    user.getSavings().deposit(amount);
                }
            }
            else if(choice.equals("Q")) System.exit(0);

            System.out.println("\n\n");
        }
    }
}