import entities.Account;
import model.WhitdrawnException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        Account account = new Account();

            System.out.println("Enter account data");
            System.out.print("Number: ");
            account.setNumber(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Holder: ");
            account.setHolder(scanner.nextLine());
            System.out.print("Balance: ");
            account.setBalance(scanner.nextDouble());
            System.out.print("Withdraw limit: ");
            account.setWithdrawLimit(scanner.nextDouble());


            System.out.print("Enter amount for whithdrawn: ");
            double amount = scanner.nextDouble();
            try {
                account.withdraw(amount);
                System.out.println("New balance: " + account.getBalance());
            } catch (WhitdrawnException e) {
                System.out.println(e.getMessage());
            }



    }
}
