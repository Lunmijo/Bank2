package utils;

import Entity.UsersEntity;

import javax.persistence.Query;
import java.util.ArrayList;

public class UsersUtil {

    private static long userID;

    public static long getUserID() {
        return userID;
    }

    public static void setUserID(long userID) {
        UsersUtil.userID = userID;
    }

    public static boolean updateUserBankAccounts(long accountID, String currency) {
        UsersEntity user = UsersUtil.findUser(UsersUtil.getUserID());
        if (user != null) {
            if (currency.equals("uah")) {
                user.setAccountuah(accountID);
            }
            else if (currency.equals("usd")) {
                user.setAccountusd(accountID);
            }
            else if (currency.equals("eur")) {
                user.setAccounteur(accountID);
            }
            Manager.getEm().getTransaction().begin();
            Manager.getEm().persist(user);
            Manager.getEm().getTransaction().commit();
            System.out.println("Added bank account to your account successful!");
            return true;
        }
        System.out.println("Something went wrong");
        return false;
    }

    public static boolean saveUser(String firstName, String lastName) {
        try {
            UsersEntity user = new UsersEntity(firstName, lastName);
            UsersUtil.setUserID(user.getId());
            Manager.getEm().persist(user);
            Manager.getEm().getTransaction().commit();
            System.out.println("Add user successful!");
            return true;
        } catch (Exception ex) {
            Manager.getEm().getTransaction().rollback();
            System.out.println("Cannot addBankAccount user!");
            return false;
        }
    }

    public static UsersEntity findUser(long ID) {
        Query query = Manager.getEm().createQuery("SELECT user FROM UsersEntity user WHERE id = ?1", UsersEntity.class);
        query.setParameter(1, ID);

        ArrayList<UsersEntity> users = (ArrayList<UsersEntity>) query.getResultList();
        return users.get(0);
    }

    public static String returnUserInfo(UsersEntity user) {
        String info = user.getFirstname() + " " + user.getLastname();
        if(user.getAccountuah() != null) {
            info += "\nUAH bank account ID: " + user.getAccountuah();
        } else {
            info += "\nNo UAH bank accounts";
        }
        if (user.getAccountusd() != null) {
            info += "\nUSD bank account ID: " + user.getAccountusd();
        } else {
            info += "\nNo USD bank accounts";
        }
        if (user.getAccounteur() != null) {
            info += "\nEUR bank account ID: " + user.getAccounteur();
        } else {
            info += "\nNo EUR bank accounts";
        }
        return info;
    }

    public static boolean isBankAccountExists(String currency) {
        UsersEntity user = UsersUtil.findUser(UsersUtil.getUserID());
        if (currency.equals("uah")) {
            return user.getAccountuah()!= null;
        }
        if (currency.equals("eur")) {
            return user.getAccounteur()!= null;
        }
        if (currency.equals("usd")) {
            return user.getAccountusd()!= null;
        }
        return false;
    }

    public static void viewInfo() {
        long id = UsersUtil.getUserID();
        UsersEntity user = UsersUtil.findUser(id);
        UsersUtil.returnUserInfo(user);
    }
}
