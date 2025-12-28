import entities.Account;
import model.WhitdrawnException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        Account account = new Account();
        boolean inputError;

            System.out.println("Enter account data");
                do {
                    inputError = false;
                    try {
                        System.out.print("Number: ");
                        account.setNumber(scanner.nextInt());
                        scanner.nextLine();

                        System.out.print("Holder: ");
                        account.setHolder(scanner.nextLine());

                        System.out.print("Balance: ");
                        account.setBalance(scanner.nextDouble());

                        System.out.print("Withdraw limit: ");
                        account.setWithdrawLimit(scanner.nextDouble());
                        scanner.nextLine();
                    }
            catch(InputMismatchException e){
                    System.out.println("Inset a valid value");
                    scanner.nextLine();
                    inputError = true;
                }
                } while (inputError);


            do {
                inputError = false;
                try {
                    System.out.print("Enter amount for whithdrawn: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    account.withdraw(amount);
                    System.out.println("New balance: " + account.getBalance());
                } catch (WhitdrawnException e) {
                    System.out.println("Erro" + e.getMessage());
                    inputError = true;
                } catch (InputMismatchException e) {
                    System.out.println("Inset a valid value");
                    inputError = true;
                    scanner.nextLine();
                }
            } while (inputError);

        scanner.close();
    }
}
