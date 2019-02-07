import javax.persistence.*;

@Entity
@Table(name = "transactions", schema = "public", catalog = "Bank")
public class TransactionsEntity {
    private long id;
    private double sum;
    private String currency;
    private BankAccountsEntity bankAccountsByFromid;
    private BankAccountsEntity bankAccountsByToid;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sum", nullable = false, precision = 0)
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "currency", nullable = false, length = -1)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionsEntity that = (TransactionsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.sum, sum) != 0) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fromid", referencedColumnName = "id", nullable = false)
    public BankAccountsEntity getBankAccountsByFromid() {
        return bankAccountsByFromid;
    }

    public void setBankAccountsByFromid(BankAccountsEntity bankAccountsByFromid) {
        this.bankAccountsByFromid = bankAccountsByFromid;
    }

    @ManyToOne
    @JoinColumn(name = "toid", referencedColumnName = "id")
    public BankAccountsEntity getBankAccountsByToid() {
        return bankAccountsByToid;
    }

    public void setBankAccountsByToid(BankAccountsEntity bankAccountsByToid) {
        this.bankAccountsByToid = bankAccountsByToid;
    }
}
