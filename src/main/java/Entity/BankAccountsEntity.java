package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Bank_Accounts", schema = "public", catalog = "Bank")
public class BankAccountsEntity {
    private Integer id;
    private Object currency;
    private Double avaliableMoney;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Double getAvaliableMoney() {
        return avaliableMoney;
    }

    public void setAvaliableMoney(Double avaliableMoney) {
        this.avaliableMoney = avaliableMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountsEntity that = (BankAccountsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (avaliableMoney != null ? !avaliableMoney.equals(that.avaliableMoney) : that.avaliableMoney != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (avaliableMoney != null ? avaliableMoney.hashCode() : 0);
        return result;
    }
}
