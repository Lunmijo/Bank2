package Entity;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts", schema = "public", catalog = "Bank")
public class BankAccountsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private String currency;
    private double availablemoney;

    public BankAccountsEntity() {
    }

    public BankAccountsEntity(String currency) {
        this.currency = currency;
        this.availablemoney = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "currency", nullable = false, length = -1)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "availablemoney", nullable = false, precision = 0)
    public double getAvailablemoney() {
        return availablemoney;
    }

    public void setAvailablemoney(double availablemoney) {
        this.availablemoney = availablemoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountsEntity that = (BankAccountsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.availablemoney, availablemoney) != 0) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        temp = Double.doubleToLongBits(availablemoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
