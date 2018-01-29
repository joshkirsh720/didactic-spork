import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String id;
        int pin;
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to the Bank!  Today's date is " + (new Date()));

        System.out.print("Please enter your User ID: ");
        id = scan.next();
        System.out.print("Please enter your PIN: ");
        pin = scan.nextInt();


    }
}