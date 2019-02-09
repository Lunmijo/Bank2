import consoleView.ConsoleOperations;
import consoleView.ConsoleEntrance;
import utils.UsersUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank!");
        boolean isLogin = false;
        while(true) {
            if (!isLogin) {
                System.out.println("Please login first");
                isLogin = ConsoleEntrance.entrance();
            }

            System.out.println(" ");
            System.out.println("Enter command or help to see available commands");

            String command = scanner.nextLine();

            if (command.equals("help")) {
                System.out.println("add account - add a bank account");
                System.out.println("view account - view your account information");
                System.out.println("info - get your user account info");
                System.out.println("transfer money - transfer your money to some bank account");
                System.out.println("deposit - addBankAccount money to your account");
                System.out.println("withdraw - withdraw money from your account");
                System.out.println("check history - get bank account history");
                System.out.println("check rates - check current currency rates");
                System.out.println("exit - to close the program");
            }
            else if (command.equals("add account")) {
                ConsoleOperations.addBankAccount(); //added
            }
            else if(command.equals("view account")) {
                ConsoleOperations.viewAccount(); //added
            }
            else if (command.equals("my info")) {
                UsersUtil.viewInfo(); //added
            }
            else if(command.equals("transfer money")) {
                ConsoleOperations.transferMoney(); //added
            }
            else if(command.equals("deposit")) {
                ConsoleOperations.depositFunds(); //added
            }
            else if(command.equals("withdraw")) {
                ConsoleOperations.withdrawFunds(); //added
            }
            else if(command.equals("check history")) {
                ConsoleOperations.checkTransactionsHistory();
            }
            else if(command.equals("check rates")) {
                ConsoleOperations.checkRates();
            }
            else if (command.equals("convert money")) {
                ConsoleOperations.convertMoney();
            }
            else if(command.equals("exit")) {
                break; //added
            }
            else {
                System.out.println("Oops, recheck your commands spelling and enter it again. Use help to check available commands");
            }
        }
    }
}
