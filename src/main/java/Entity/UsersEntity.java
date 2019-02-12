package Entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public", catalog = "Bank")
public class UsersEntity {
    private long id;
    private String firstname;
    private String lastname;
    private Long accountuah;
    private Long accountusd;
    private Long accounteur;
    private BankAccountsEntity bankAccountsByAccountuah;
    private BankAccountsEntity bankAccountsByAccountusd;
    private BankAccountsEntity bankAccountsByAccounteur;

    public UsersEntity() {

    }

    public UsersEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
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
    @Column(name = "firstname", nullable = false, length = -1)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = -1)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "accountuah", nullable = true, insertable = false, updatable = false)
    public Long getAccountuah() {
        return accountuah;
    }

    public void setAccountuah(Long accountuah) {
        this.accountuah = accountuah;
    }

    @Basic
    @Column(name = "accountusd", nullable = true, insertable = false, updatable = false)
    public Long getAccountusd() {
        return accountusd;
    }

    public void setAccountusd(Long accountusd) {
        this.accountusd = accountusd;
    }

    @Basic
    @Column(name = "accounteur", nullable = true, insertable = false, updatable = false)
    public Long getAccounteur() {
        return accounteur;
    }

    public void setAccounteur(Long accounteur) {
        this.accounteur = accounteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (accountuah != null ? !accountuah.equals(that.accountuah) : that.accountuah != null) return false;
        if (accountusd != null ? !accountusd.equals(that.accountusd) : that.accountusd != null) return false;
        if (accounteur != null ? !accounteur.equals(that.accounteur) : that.accounteur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (accountuah != null ? accountuah.hashCode() : 0);
        result = 31 * result + (accountusd != null ? accountusd.hashCode() : 0);
        result = 31 * result + (accounteur != null ? accounteur.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "accountuah", referencedColumnName = "id")
    public BankAccountsEntity getBankAccountsByAccountuah() {
        return bankAccountsByAccountuah;
    }

    public void setBankAccountsByAccountuah(BankAccountsEntity bankAccountsByAccountuah) {
        this.bankAccountsByAccountuah = bankAccountsByAccountuah;
    }

    @ManyToOne
    @JoinColumn(name = "accountusd", referencedColumnName = "id")
    public BankAccountsEntity getBankAccountsByAccountusd() {
        return bankAccountsByAccountusd;
    }

    public void setBankAccountsByAccountusd(BankAccountsEntity bankAccountsByAccountusd) {
        this.bankAccountsByAccountusd = bankAccountsByAccountusd;
    }

    @ManyToOne
    @JoinColumn(name = "accounteur", referencedColumnName = "id")
    public BankAccountsEntity getBankAccountsByAccounteur() {
        return bankAccountsByAccounteur;
    }

    public void setBankAccountsByAccounteur(BankAccountsEntity bankAccountsByAccounteur) {
        this.bankAccountsByAccounteur = bankAccountsByAccounteur;
    }
}
