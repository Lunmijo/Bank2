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
            String command = scanner.nextLine();
            if (command.equals("help")) {
                System.out.println("add - add a bank account");
                System.out.println("view account - view your account information");
                System.out.println("transfer money - transfer your money to some bank account");
                System.out.println("deposit - add money to your account");
                System.out.println("withdraw - withdraw money from your account");
                System.out.println("check history - get bank account history");
                System.out.println("check rates - check current currency rates");
            }
            else if (command.equals("add")) {
                bankAccountsUtil.add();
            }
            else if(command.equals("view account")) {
                bankAccountsUtil.viewAccount();
            }
            else if(command.equals("transfer money")) {
                bankAccountsUtil.transferMoney();
            }
            else if(command.equals("deposit")) {
                bankAccountsUtil.depositFunds();
            }
            else if(command.equals("withdraw")) {
                bankAccountsUtil.withdrawFunds();
            }
            else if(command.equals("check history")) {
                bankAccountsUtil.checkTransactionsHistory();
            }
            else if(command.equals("check rates")) {
                bankAccountsUtil.checkRates();
            }
            else if(command.equals("exit")) {
                break;
            }
            else {
                System.out.println("Oops, recheck your commands spelling and enter it again. Use help to check available commands");
            }
        }
    }
}
