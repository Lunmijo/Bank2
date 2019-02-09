package utils;

import Entity.CurrencyratesEntity;

import javax.persistence.Query;
import java.util.ArrayList;

public class CurrencyRates {

    public static CurrencyratesEntity findRate(String date) {
        Query query = Manager.getEm().createQuery("SELECT currencyRate FROM CurrencyratesEntity currencyRate WHERE date = ?1", CurrencyratesEntity.class);
        query.setParameter(1, date);

        ArrayList<CurrencyratesEntity> currencyRate = (ArrayList<CurrencyratesEntity>) query.getResultList();
        return currencyRate.get(0);
    }

}
