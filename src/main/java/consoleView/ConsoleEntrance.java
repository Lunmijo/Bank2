package consoleView;

import Entity.UsersEntity;
import utils.Manager;
import utils.UsersUtil;

import java.util.Scanner;

public class ConsoleEntrance {

    public static Scanner scanner = new Scanner(System.in);

    public static boolean entrance() {
        System.out.println("Enter \"sign up\" to register or \"sign in\"");
        String choose = scanner.nextLine();

        if (choose.equals("sign up")) {
            ConsoleEntrance.signUp();
        }

        else if (choose.equals("sign in")) {
            ConsoleEntrance.signIn();
            return true;
        }

        else {
            System.out.println("No user found, try again!");
            return false;
        }

        return false;
    }

    private static boolean signUp() {
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        Manager.getEm().getTransaction().begin();
        return UsersUtil.saveUser(firstName, lastName);
    }

    private static boolean signIn() {
        System.out.println("Enter your ID");
         long userID = scanner.nextInt();
         UsersUtil.setUserID(userID);
        UsersEntity user = UsersUtil.findUser(UsersUtil.getUserID());
        if (user != null) {
            System.out.println(UsersUtil.returnUserInfo(user));
            return true;
        }
        return false;
    }

}
