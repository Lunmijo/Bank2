package utils;

import Entity.BankAccountsEntity;
import Entity.CurrencyratesEntity;
import Entity.TransactionsEntity;
import Entity.UsersEntity;

import javax.persistence.Query;
import java.util.ArrayList;

public class BankAccountsUtil {

    public static boolean saveBankAccount(String currency) {
        BankAccountsEntity bankAccountsEntity = new BankAccountsEntity(currency);

        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(bankAccountsEntity);
        Manager.getEm().getTransaction().commit();

        long accountID = bankAccountsEntity.getId();
        UsersUtil.updateUserBankAccounts(accountID, currency);
        return true;
    }

    public static String transferMoney(String currency, double sum, long toid) {

        UsersEntity userTo = UsersUtil.findUser(toid);
        UsersEntity userFrom = UsersUtil.findUser(UsersUtil.getUserID());

        BankAccountsEntity accountFrom = BankAccountsUtil.findAccountByCurrency(userFrom, currency);
        BankAccountsEntity accountTo = BankAccountsUtil.findAccountByCurrency(userTo, currency);
        try {
            double accountFromBalance = accountFrom.getAvailablemoney();
            double absSum = Math.abs(sum);
            if (accountTo != null) {

                if (accountFromBalance >= absSum && accountFrom.getCurrency().equals(accountTo.getCurrency())) {
                    accountFrom.setAvailablemoney(accountFromBalance - absSum);
                    double accountToBalance = accountTo.getAvailablemoney();
                    accountTo.setAvailablemoney(accountToBalance + absSum);

                    TransactionsEntity bankTransaction = new TransactionsEntity();
                    //is it ok so much transactions
                    bankTransaction.setCurrency(accountFrom.getCurrency());
                    bankTransaction.setSum(sum);
                    bankTransaction.setSender(accountFrom.getId());
                    bankTransaction.setReceiver(accountTo.getId());

                    BankAccountsUtil.saveTransaction(bankTransaction);
                    BankAccountsUtil.saveBankAccount(accountTo);
                    BankAccountsUtil.saveBankAccount(accountFrom);

                    return "Transaction successful!";
                } else if (!accountFrom.getCurrency().equals(accountTo.getCurrency())) {
                    return "Oops! You can only transfer between same currency!";
                } else if (accountFromBalance >= absSum) {
                    return "Oops! You do not have enough money!";
                } else {
                    return "Oops! Something went wrong";
                }
            } else {
                return "Oops! Account does not exist!";
            }
        } catch (NullPointerException e) {
            return "Oops! You have not enough money or account does not exist!";
        }
    }

    public static boolean depositMoney(double sum, String currency) {

        UsersEntity user = UsersUtil.findUser(UsersUtil.getUserID());
        BankAccountsEntity userAccount = BankAccountsUtil.findAccountByCurrency(user, currency);

        double currentMoney = userAccount.getAvailablemoney();
        try {
            userAccount.setAvailablemoney(currentMoney + Math.abs(sum));

            BankAccountsUtil.updateBankAccount(userAccount, Math.abs(sum));
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static double withdrawMoney(double sum, String currency) {

        UsersEntity user = UsersUtil.findUser(UsersUtil.getUserID());
        BankAccountsEntity userAccount = BankAccountsUtil.findAccountByCurrency(user, currency);

        double withdrawSum;
        double rate;

        if (currency.equals("uah")) {
            try {
                withdrawSum = sum;
                if (BankAccountsUtil.withdrawUpdateAccount(withdrawSum, userAccount)) {
                    TransactionsEntity transaction = new TransactionsEntity();
                    transaction.setSender(userAccount.getId());
                    transaction.setCurrency(userAccount.getCurrency());
                    transaction.setSum(withdrawSum);
                    BankAccountsUtil.saveTransaction(transaction);
                    return withdrawSum;
                }
            } catch (NullPointerException e) {
                return -1;
            }
        } else if (currency.equals("usd")) {
            try {
            rate = CurrencyRates.findRate("1").getUsdtouah();
            withdrawSum = sum * rate;
            if (BankAccountsUtil.withdrawUpdateAccount(sum, userAccount)) {
                TransactionsEntity transaction = new TransactionsEntity();
                transaction.setSender(userAccount.getId());
                transaction.setCurrency(userAccount.getCurrency());
                transaction.setSum(withdrawSum);
                BankAccountsUtil.saveTransaction(transaction);
                return withdrawSum;
            }
            } catch (NullPointerException e) {
                return -1;
            }
        } else if (currency.equals("eur")) {
            try {
                rate = CurrencyRates.findRate("1").getEurtouah();
                withdrawSum = sum * rate;
                if (BankAccountsUtil.withdrawUpdateAccount(sum, userAccount)) {
                    TransactionsEntity transaction = new TransactionsEntity();
                    transaction.setSender(userAccount.getId());
                    transaction.setCurrency(userAccount.getCurrency());
                    transaction.setSum(withdrawSum);
                    BankAccountsUtil.saveTransaction(transaction);
                    return withdrawSum;
                }
            } catch (NullPointerException e) {
            return -1;
            }
        }
        return -1;
    }

    private static boolean withdrawUpdateAccount(double withdrawSum, BankAccountsEntity userAccount) {
        double funds = userAccount.getAvailablemoney();

        if (funds >= withdrawSum) {
            userAccount.setAvailablemoney(funds - Math.abs(withdrawSum));
            BankAccountsUtil.updateBankAccount(userAccount, withdrawSum);
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean updateBankAccount(BankAccountsEntity userAccount, double sum) {
        try {
                BankAccountsUtil.saveBankAccount(userAccount);

                TransactionsEntity accountTransaction = new TransactionsEntity();
                accountTransaction.setSender(userAccount.getId());
                accountTransaction.setSum(sum);
                accountTransaction.setCurrency(userAccount.getCurrency());
                BankAccountsUtil.saveTransaction(accountTransaction);

                return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private static boolean updateBankAccount(BankAccountsEntity to, BankAccountsEntity from, double sum, double fromSum, double toSum) {
        try {
            to.setAvailablemoney(toSum);
            from.setAvailablemoney(fromSum);
            BankAccountsUtil.saveBankAccount(to);
            BankAccountsUtil.saveBankAccount(from);

            TransactionsEntity accountTransaction = new TransactionsEntity();
            accountTransaction.setSender(from.getId());
            accountTransaction.setReceiver(to.getId());
            accountTransaction.setSum(sum);
            accountTransaction.setCurrency(from.getCurrency());
            BankAccountsUtil.saveTransaction(accountTransaction);

        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    private static BankAccountsEntity findAccountByCurrency(UsersEntity user, String currency) {
        if (currency.equals("uah")) {
            return BankAccountsUtil.findAccount(user.getAccountuah());
        } else if (currency.equals("usd")) {
            return BankAccountsUtil.findAccount(user.getAccountusd());
        } else if (currency.equals("eur")) {
            return BankAccountsUtil.findAccount(user.getAccounteur());
        }
        return null;
    }

    private static boolean saveBankAccount(BankAccountsEntity bankAccount) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(bankAccount);
        Manager.getEm().getTransaction().commit();
        return true;
    }

    private static boolean saveTransaction(TransactionsEntity bankTransaction) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(bankTransaction);
        Manager.getEm().getTransaction().commit();
        return true;
    }

    public static BankAccountsEntity findAccountByCurrency(String currency) {
        long accountID = -1;
        long userID = UsersUtil.getUserID();

        if (currency.equals("uah")) {
            accountID = UsersUtil.findUser(userID).getAccountuah();
        } else if (currency.equals("usd")) {
            accountID = UsersUtil.findUser(userID).getAccountusd();
        } else if (currency.equals("eur")) {
            accountID = UsersUtil.findUser(userID).getAccounteur();
        }

        return BankAccountsUtil.findAccount(accountID);
    }

    public static BankAccountsEntity findAccount(long id) {
        Query query = Manager.getEm().createQuery("SELECT bankAccount FROM BankAccountsEntity bankAccount WHERE id = ?1", BankAccountsEntity.class);
        query.setParameter(1, id);
        ArrayList<BankAccountsEntity> resultList = (ArrayList<BankAccountsEntity>) query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public static boolean convertMoney(BankAccountsEntity from, BankAccountsEntity to, double sum) {
        double resultFrom = from.getAvailablemoney() - sum;
        if (resultFrom >= 0) {
            CurrencyratesEntity rates = CurrencyRates.findRate("1");
            double rate = 0;
            if (from.getCurrency().equals("uah") && to.getCurrency().equals("usd")) {
                rate = rates.getUahtousd();
            } else if (from.getCurrency().equals("usd") && to.getCurrency().equals("uah")) {
                rate = rates.getUsdtouah();

            } else if (from.getCurrency().equals("uah") && to.getCurrency().equals("eur")) {
                rate = rates.getUahtoeur();

            } else if (from.getCurrency().equals("eur") && to.getCurrency().equals("uah")) {
                rate = rates.getEurtouah();

            } else if (from.getCurrency().equals("usd") && to.getCurrency().equals("eur")) {
                rate = rates.getUsdtoeur();

            } else if (from.getCurrency().equals("eur") && to.getCurrency().equals("usd")) {
                rate = rates.getEurtousd();
            }
            double resultSum = sum * rate;
            double resultTo = to.getAvailablemoney() + resultSum;
            BankAccountsUtil.updateBankAccount(to, from, sum, resultFrom, resultTo);
            return true;
        }

        return false;
    }
}
