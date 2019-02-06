package Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Bank_Accounts", schema = "public", catalog = "Bank")
public class BankAccountsEntity {
    private Integer id;
    private String currency;
    private Double avaliableMoney;
    private Collection<TransactionsEntity> transactionsById;
    private Collection<TransactionsEntity> transactionsById_0;
    private Collection<UsersEntity> usersById;
    private Collection<UsersEntity> usersById_0;
    private Collection<UsersEntity> usersById_1;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Currency", nullable = false, length = -1)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
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

    @OneToMany(mappedBy = "bankAccountsByFromAccountId")
    public Collection<TransactionsEntity> getTransactionsById() {
        return transactionsById;
    }

    public void setTransactionsById(Collection<TransactionsEntity> transactionsById) {
        this.transactionsById = transactionsById;
    }

    @OneToMany(mappedBy = "bankAccountsByToAccountId")
    public Collection<TransactionsEntity> getTransactionsById_0() {
        return transactionsById_0;
    }

    public void setTransactionsById_0(Collection<TransactionsEntity> transactionsById_0) {
        this.transactionsById_0 = transactionsById_0;
    }

    @OneToMany(mappedBy = "bankAccountsByBankUahAccountId")
    public Collection<UsersEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UsersEntity> usersById) {
        this.usersById = usersById;
    }

    @OneToMany(mappedBy = "bankAccountsByBankEurAccountId")
    public Collection<UsersEntity> getUsersById_0() {
        return usersById_0;
    }

    public void setUsersById_0(Collection<UsersEntity> usersById_0) {
        this.usersById_0 = usersById_0;
    }

    @OneToMany(mappedBy = "bankAccountsByBankUsdAccountId")
    public Collection<UsersEntity> getUsersById_1() {
        return usersById_1;
    }

    public void setUsersById_1(Collection<UsersEntity> usersById_1) {
        this.usersById_1 = usersById_1;
    }
}
