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

    public static String getStringRate(String date) {
        CurrencyratesEntity rate = CurrencyRates.findRate(date);
        String rates = "";
        rates += "UAH to USD rate: " + rate.getUahtousd();
        rates += "\nUAH to EUR rate: " + rate.getUahtoeur();
        rates += "\nUSD to UAH rate: " + rate.getUsdtouah();
        rates += "\nEUR to UAH rate: " + rate.getEurtouah();
        rates += "\nEUR to USD rate: " + rate.getEurtousd();
        rates += "\nUSD to EUR rate: " + rate.getUsdtoeur();
        return rates;
    }

}
