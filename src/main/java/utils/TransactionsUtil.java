package utils;

import Entity.TransactionsEntity;

import javax.persistence.Query;
import java.util.ArrayList;

public class TransactionsUtil {

    public static ArrayList<TransactionsEntity> findTransactions(long accountID) {
        Query query = Manager.getEm().createQuery("SELECT transactions FROM TransactionsEntity transactions  WHERE sender = ?1", TransactionsEntity.class);
        query.setParameter(1, accountID);

        ArrayList<TransactionsEntity> transactions = (ArrayList<TransactionsEntity>) query.getResultList();
        return transactions;
    }
}
