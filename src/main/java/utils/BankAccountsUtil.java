package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class BankAccountsUtil {

    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner scanner;

    public BankAccountsUtil() {
        this.emf = Persistence.createEntityManagerFactory("JPA");
        this.em = emf.createEntityManager();
        this.scanner = new Scanner(System.in);
    }

    public void close() {
        emf.close();
        scanner.close();
    }

    public void add() {

    }

    public void viewAccount() {

    }

    public void transferMoney() {

    }

    public void depositFunds() {

    }

    public void withdrawFunds() {

    }

    public void checkTransactionsHistory() {

    }

    public void checkRates() {

    }
}
