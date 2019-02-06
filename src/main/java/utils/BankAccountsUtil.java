package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class BankAccountsUtil {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    private EntityManager em = emf.createEntityManager();
    private Scanner scanner = new Scanner(System.in);

    BankAccountsUtil() { }

    public void close() {
        //emf.close();
        //sc.close();
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
