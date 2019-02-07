package utils;

import Entity.BankAccountsEntity;
import Entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountsUtil {

    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner scanner;
    private int userID;

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
        this.entrance();
        System.out.println("Enter currency of account you want - available: uah, eur, usd");
        Scanner scanner = new Scanner(System.in);
        String accountCurrency = scanner.nextLine();

        this.addBankAccount(accountCurrency);
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

    private boolean entrance() {
        System.out.println("Enter \"sign up\" to register or \"sign in\"");
        String choose = scanner.nextLine();

        if (choose.equals("sign up")) {
            this.signUp();
        }

        else if (choose.equals("sign in")) {
            this.signIn();
            return true;
        }

        else {
            System.out.println("No user found, try again!");
            return false;
        }

        return false;
    }

    private boolean signUp() {
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();

        em.getTransaction().begin();
        return this.saveUser(firstName, lastName);
    }

    private boolean signIn() {
        System.out.println("Enter your ID");
        userID = scanner.nextInt();
        ArrayList<UsersEntity> userList;
        userList = this.findUser(userID);
        if (userList.get(0) != null) {
            System.out.println(userList.get(0).getFirstname() + " " + userList.get(0).getLastname());
            System.out.println(userList.get(0).getAccountuah() != null ? userList.get(0).getAccountuah() : "No UAH bank accounts");
            System.out.println(userList.get(0).getAccountusd() != null ? userList.get(0).getAccountusd() : "No USD bank accounts");
            System.out.println(userList.get(0).getAccounteur() != null ? userList.get(0).getAccounteur() : "No EUR bank accounts");
            return true;
        }
        return false;
    }

    private boolean addBankAccount(String currency) {
        if (currency.equals("uah") || currency.equals("usd") || currency.equals("eur")) {
            return this.saveBankAccount(currency);
        }
        return false;
    }


    private boolean saveUser(String firstName, String lastName) {
        try {
            UsersEntity user = new UsersEntity(firstName, lastName);
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("Add user successful!");
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Cannot add user!");
            return false;
        }
    }

    private boolean saveBankAccount(String currency) {
        try {
            BankAccountsEntity bankAccountsEntity = new BankAccountsEntity(currency);

            em.getTransaction().begin();
            em.persist(bankAccountsEntity);
            em.getTransaction().commit();

            long accountID = bankAccountsEntity.getId();
            this.updateUserBankAccounts(accountID, currency);

            System.out.println("Add bank account in " + currency + " successful!");
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Cannot add bank account in " + currency);
            return false;
        }
    }

    private boolean updateUserBankAccounts(long accountID, String currency) {
        ArrayList<UsersEntity> users = this.findUser(this.userID);
        if (users != null) {
            if (currency.equals("uah")) {
                users.get(0).setAccountuah(accountID);
            }
            else if (currency.equals("usd")) {
                users.get(0).setAccountusd(accountID);
            }
            else if (currency.equals("eur")) {
                users.get(0).setAccounteur(accountID);
            }
            em.getTransaction().begin();
            em.persist(users.get(0));
            em.getTransaction().commit();
            System.out.println("Added bank account to your account successful!");
            return true;
        }
        System.out.println("Something went wrong");
        return false;
    }

    private ArrayList<UsersEntity> findUser(long ID) {
        Query query = em.createQuery("SELECT user FROM UsersEntity user WHERE id = ?1", UsersEntity.class);
        query.setParameter(1, ID);
        return (ArrayList<UsersEntity>) query.getResultList();
    }
}
