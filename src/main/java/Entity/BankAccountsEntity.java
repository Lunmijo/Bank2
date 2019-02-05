package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Bank_Accounts", schema = "public", catalog = "Bank")
public class BankAccountsEntity {
    private int id;
    private Object currency;
    private double avaliableMoney;

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
    @Column(name = "AvaliableMoney", nullable = false, precision = 0)
    public double getAvaliableMoney() {
        return avaliableMoney;
    }

    public void setAvaliableMoney(double avaliableMoney) {
        this.avaliableMoney = avaliableMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountsEntity that = (BankAccountsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.avaliableMoney, avaliableMoney) != 0) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        temp = Double.doubleToLongBits(avaliableMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
