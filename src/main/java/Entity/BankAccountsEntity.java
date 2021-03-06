package Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "bank_accounts", schema = "public", catalog = "Bank")
public class BankAccountsEntity {
    private long id;
    private String currency;
    private double availablemoney;
    private Collection<TransactionsEntity> transactionsById;
    private Collection<TransactionsEntity> transactionsById_0;
    private Collection<UsersEntity> usersById;
    private Collection<UsersEntity> usersById_0;
    private Collection<UsersEntity> usersById_1;

    public BankAccountsEntity() { }

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

    @OneToMany(mappedBy = "bankAccountsBySender")
    public Collection<TransactionsEntity> getTransactionsById() {
        return transactionsById;
    }

    public void setTransactionsById(Collection<TransactionsEntity> transactionsById) {
        this.transactionsById = transactionsById;
    }

    @OneToMany(mappedBy = "bankAccountsByReceiver")
    public Collection<TransactionsEntity> getTransactionsById_0() {
        return transactionsById_0;
    }

    public void setTransactionsById_0(Collection<TransactionsEntity> transactionsById_0) {
        this.transactionsById_0 = transactionsById_0;
    }

    @OneToMany(mappedBy = "bankAccountsByAccountuah")
    public Collection<UsersEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UsersEntity> usersById) {
        this.usersById = usersById;
    }

    @OneToMany(mappedBy = "bankAccountsByAccountusd")
    public Collection<UsersEntity> getUsersById_0() {
        return usersById_0;
    }

    public void setUsersById_0(Collection<UsersEntity> usersById_0) {
        this.usersById_0 = usersById_0;
    }

    @OneToMany(mappedBy = "bankAccountsByAccounteur")
    public Collection<UsersEntity> getUsersById_1() {
        return usersById_1;
    }

    public void setUsersById_1(Collection<UsersEntity> usersById_1) {
        this.usersById_1 = usersById_1;
    }
}
