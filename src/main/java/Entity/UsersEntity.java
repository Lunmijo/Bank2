package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Users", schema = "public", catalog = "Bank")
public class UsersEntity {
    private int id;
    private String firstName;
    private String lastName;
    private BankAccountsEntity bankAccountsByBankUahAccountId;
    private BankAccountsEntity bankAccountsByBankEurAccountId;
    private BankAccountsEntity bankAccountsByBankUsdAccountId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FirstName", nullable = false, length = -1)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName", nullable = false, length = -1)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BankUAHAccountID", referencedColumnName = "ID")
    public Entity.BankAccountsEntity getBankAccountsByBankUahAccountId() {
        return bankAccountsByBankUahAccountId;
    }

    public void setBankAccountsByBankUahAccountId(Entity.BankAccountsEntity bankAccountsByBankUahAccountId) {
        this.bankAccountsByBankUahAccountId = bankAccountsByBankUahAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "BankEURAccountID", referencedColumnName = "ID")
    public Entity.BankAccountsEntity getBankAccountsByBankEurAccountId() {
        return bankAccountsByBankEurAccountId;
    }

    public void setBankAccountsByBankEurAccountId(Entity.BankAccountsEntity bankAccountsByBankEurAccountId) {
        this.bankAccountsByBankEurAccountId = bankAccountsByBankEurAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "BankUSDAccountID", referencedColumnName = "ID")
    public Entity.BankAccountsEntity getBankAccountsByBankUsdAccountId() {
        return bankAccountsByBankUsdAccountId;
    }

    public void setBankAccountsByBankUsdAccountId(Entity.BankAccountsEntity bankAccountsByBankUsdAccountId) {
        this.bankAccountsByBankUsdAccountId = bankAccountsByBankUsdAccountId;
    }
}
