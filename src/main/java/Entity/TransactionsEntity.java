package Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Transactions", schema = "public", catalog = "Bank")
public class TransactionsEntity {
    private int id;
    private Object currency;
    private double sum;
    private Date currencyRateDay;
    private BankAccountsEntity bankAccountsByFromAccountId;
    private BankAccountsEntity bankAccountsByToAccountId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Currency", nullable = false)
    public Object getCurrency() {
        return currency;
    }

    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "Sum", nullable = false, precision = 0)
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "CurrencyRateDay", nullable = false)
    public Date getCurrencyRateDay() {
        return currencyRateDay;
    }

    public void setCurrencyRateDay(Date currencyRateDay) {
        this.currencyRateDay = currencyRateDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionsEntity that = (TransactionsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.sum, sum) != 0) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (currencyRateDay != null ? !currencyRateDay.equals(that.currencyRateDay) : that.currencyRateDay != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currencyRateDay != null ? currencyRateDay.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FromAccountID", referencedColumnName = "ID", nullable = false)
    public Entity.BankAccountsEntity getBankAccountsByFromAccountId() {
        return bankAccountsByFromAccountId;
    }

    public void setBankAccountsByFromAccountId(Entity.BankAccountsEntity bankAccountsByFromAccountId) {
        this.bankAccountsByFromAccountId = bankAccountsByFromAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "ToAccountID", referencedColumnName = "ID", nullable = false)
    public Entity.BankAccountsEntity getBankAccountsByToAccountId() {
        return bankAccountsByToAccountId;
    }

    public void setBankAccountsByToAccountId(Entity.BankAccountsEntity bankAccountsByToAccountId) {
        this.bankAccountsByToAccountId = bankAccountsByToAccountId;
    }
}
