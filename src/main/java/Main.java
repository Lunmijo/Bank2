import utils.BankAccountsUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAccountsUtil bankAccountsUtil = new BankAccountsUtil();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank!");
        while(true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Enter command or help to see available commands");
            if (scanner.nextLine().equals("help")) {
                System.out.println("add - add a bank account");
                System.out.println("view account - view your account information");
                System.out.println("transfer money - transfer your money to some bank account");
                System.out.println("deposit - add money to your account");
                System.out.println("withdraw - withdraw money from your account");
                System.out.println("check history - get bank account history");
                System.out.println("check rates - check current currency rates");
            }
            else if (scanner.nextLine().equals("add")) {
                bankAccountsUtil.add();
            }
            else if(scanner.nextLine().equals("view account")) {
                bankAccountsUtil.viewAccount();
            }
            else if(scanner.nextLine().equals("transfer money")) {
                bankAccountsUtil.transferMoney();
            }
            else if(scanner.nextLine().equals("deposit")) {
                bankAccountsUtil.depositFunds();
            }
            else if(scanner.nextLine().equals("withdraw")) {
                bankAccountsUtil.withdrawFunds();
            }
            else if(scanner.nextLine().equals("check history")) {
                bankAccountsUtil.checkTransactionsHistory();
            }
            else if(scanner.nextLine().equals("check rates")) {
                bankAccountsUtil.checkRates();
            }
            else if(scanner.nextLine().equals("exit")) {
                break;
            }
            else {
                System.out.println("Oops, recheck your commands spelling and enter it again. Use help to check available commands");
            }
        }
    }
}
