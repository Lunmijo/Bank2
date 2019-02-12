package consoleView;

import Entity.BankAccountsEntity;
import Entity.TransactionsEntity;
import utils.BankAccountsUtil;
import utils.CurrencyRates;
import utils.TransactionsUtil;
import utils.UsersUtil;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleOperations {

    private static Scanner scanner = new Scanner(System.in);

    public static boolean addBankAccount() {
        System.out.println("Enter currency of account you want - available: uah, eur, usd");
        Scanner scanner = new Scanner(System.in);
        String currency = scanner.nextLine();

        if (currency.equals("uah") || currency.equals("usd") || currency.equals("eur")) {
            return ConsoleOperations.saveBankAccount(currency);
        }
        return false;
    }

    public static void viewAccount() {
        System.out.println("Enter what bank account you want to see: uah, eur, usd");
        String currency = ConsoleOperations.scanner.nextLine();
        try {
            BankAccountsEntity bankAccount = BankAccountsUtil.findAccountByCurrency(currency);
            if (bankAccount != null) {
                System.out.println("Bank account ID: " + bankAccount.getId());
                System.out.println("Available money: " + bankAccount.getAvailablemoney());
                System.out.println("Bank account currency: " + bankAccount.getCurrency());
            }

        } catch (NullPointerException npe) {
            System.out.println("Oops, you do not have bank account in " + currency.toUpperCase());
        }
    }

    public static boolean saveBankAccount(String currency) {
        try {
            if (UsersUtil.isBankAccountExists(currency)) {
                System.out.println("Oops! You already have " + currency + " bank account!");
                return false;
            }

            BankAccountsUtil.saveBankAccount(currency);

            System.out.println("Add bank account in " + currency + " successful!");
            return true;

        } catch (Exception ex) {
            System.out.println("Cannot addBankAccount bank account in " + currency);
            return false;
        }
    }

    public static void transferMoney() {
        System.out.println("Enter from what account do you want to transfer money: uah, eur, usd");
        String currency = scanner.nextLine();

        System.out.println("Enter sum you want to transfer");
        double sum = scanner.nextInt();
        System.out.println("Enter user id who you want to transfer money");
        long toid = scanner.nextInt();

        System.out.println(BankAccountsUtil.transferMoney(currency, sum, toid));
    }

    public static void depositFunds() {
        System.out.println("Enter which account do you want to deposit: uah, eur, usd");
        String currency = scanner.nextLine();
        System.out.println("Enter sum you want to deposit");
        double sum = scanner.nextInt();
        boolean result = BankAccountsUtil.depositMoney(sum, currency);
        System.out.println(result ? "Deposit successful!" : "Oops, something went wrong!");
    }

    public static void withdrawFunds() {
        System.out.println("Enter which account do you want to withdraw: uah, eur, usd");
        Scanner scanner1 = new Scanner(System.in);
        String currency = scanner1.nextLine();
        System.out.println("Enter sum you want to withdraw");
        double sum = scanner.nextInt();
        double withdrawSum = BankAccountsUtil.withdrawMoney(sum, currency);
        System.out.println(withdrawSum != -1 ? "Withdraw " + withdrawSum + " uah successful!" : "Oops, something went wrong!");
    }

    public static void checkTransactionsHistory() {
        ArrayList<TransactionsEntity> transactions = TransactionsUtil.findTransactions(UsersUtil.findUser(UsersUtil.getUserID()).getAccountuah());
        transactions.addAll(TransactionsUtil.findTransactions(UsersUtil.findUser(UsersUtil.getUserID()).getAccounteur()));
        transactions.addAll(TransactionsUtil.findTransactions(UsersUtil.findUser(UsersUtil.getUserID()).getAccountusd()));

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("ID: " + transactions.get(i).getId());
            System.out.println("Currency: " + transactions.get(i).getCurrency());
            System.out.println("Sum: " + transactions.get(i).getSum());
            System.out.println("Sender: " + transactions.get(i).getSender());
            if (transactions.get(i).getReceiver() == null) {
                System.out.println("ATM Transaction");
            }
            else {
                System.out.println("Receiver: " + transactions.get(i).getReceiver());
            }
            System.out.println(" ");
        }
    }

    public static void checkRates() {
        System.out.println(CurrencyRates.getStringRate("1"));
    }

    public static void convertMoney() {
        System.out.println("Enter currency from account you want to convert money: uah, eur, usd");
        String from = scanner.nextLine();
        System.out.println("Enter currency to account you want to convert money: uah, eur, usd");
        String to = scanner.nextLine();
        System.out.println("Enter sum in currency from account");
        double sum = scanner.nextDouble();
        boolean result = BankAccountsUtil.convertMoney(BankAccountsUtil.findAccountByCurrency(from), BankAccountsUtil.findAccountByCurrency(to), sum);
        if (result) {
            System.out.println("Converted successful!");
        }
        else {
            System.out.println("Oops, something went wrong!");
        }
    }

    public static void viewInfo() {

        System.out.println(UsersUtil.viewInfo());
    }

}
