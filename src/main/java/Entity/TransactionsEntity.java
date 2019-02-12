package Entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions", schema = "public", catalog = "Bank")
public class TransactionsEntity {
    private long id;
    private long sender;
    private Long receiver;
    private double sum;
    private String currency;
    private BankAccountsEntity bankAccountsBySender;
    private BankAccountsEntity bankAccountsByReceiver;

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
    @Column(name = "sender", nullable = false)
    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "receiver", nullable = true)
    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
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
        if (sender != that.sender) return false;
        if (Double.compare(that.sum, sum) != 0) return false;
        if (receiver != null ? !receiver.equals(that.receiver) : that.receiver != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (sender ^ (sender >>> 32));
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public BankAccountsEntity getBankAccountsBySender() {
        return bankAccountsBySender;
    }

    public void setBankAccountsBySender(BankAccountsEntity bankAccountsBySender) {
        this.bankAccountsBySender = bankAccountsBySender;
    }

    @ManyToOne
    @JoinColumn(name = "receiver", referencedColumnName = "id", insertable = false, updatable = false)
    public BankAccountsEntity getBankAccountsByReceiver() {
        return bankAccountsByReceiver;
    }

    public void setBankAccountsByReceiver(BankAccountsEntity bankAccountsByReceiver) {
        this.bankAccountsByReceiver = bankAccountsByReceiver;
    }
}
