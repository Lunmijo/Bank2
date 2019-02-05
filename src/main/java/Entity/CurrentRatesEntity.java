package Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Current_Rates", schema = "public", catalog = "Bank")
public class CurrentRatesEntity {
    private Date date;
    private Object uaHtoUsd;
    private Object uaHtoEur;
    private Object usDtoUah;
    private Object euRtoUah;
    private Object euRtoUsd;
    private Object usDtoEur;

    @Id
    @Column(name = "Date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "UAHtoUSD", nullable = false)
    public Object getUaHtoUsd() {
        return uaHtoUsd;
    }

    public void setUaHtoUsd(Object uaHtoUsd) {
        this.uaHtoUsd = uaHtoUsd;
    }

    @Basic
    @Column(name = "UAHtoEUR", nullable = false)
    public Object getUaHtoEur() {
        return uaHtoEur;
    }

    public void setUaHtoEur(Object uaHtoEur) {
        this.uaHtoEur = uaHtoEur;
    }

    @Basic
    @Column(name = "USDtoUAH", nullable = false)
    public Object getUsDtoUah() {
        return usDtoUah;
    }

    public void setUsDtoUah(Object usDtoUah) {
        this.usDtoUah = usDtoUah;
    }

    @Basic
    @Column(name = "EURtoUAH", nullable = false)
    public Object getEuRtoUah() {
        return euRtoUah;
    }

    public void setEuRtoUah(Object euRtoUah) {
        this.euRtoUah = euRtoUah;
    }

    @Basic
    @Column(name = "EURtoUSD", nullable = false)
    public Object getEuRtoUsd() {
        return euRtoUsd;
    }

    public void setEuRtoUsd(Object euRtoUsd) {
        this.euRtoUsd = euRtoUsd;
    }

    @Basic
    @Column(name = "USDtoEUR", nullable = false)
    public Object getUsDtoEur() {
        return usDtoEur;
    }

    public void setUsDtoEur(Object usDtoEur) {
        this.usDtoEur = usDtoEur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentRatesEntity that = (CurrentRatesEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (uaHtoUsd != null ? !uaHtoUsd.equals(that.uaHtoUsd) : that.uaHtoUsd != null) return false;
        if (uaHtoEur != null ? !uaHtoEur.equals(that.uaHtoEur) : that.uaHtoEur != null) return false;
        if (usDtoUah != null ? !usDtoUah.equals(that.usDtoUah) : that.usDtoUah != null) return false;
        if (euRtoUah != null ? !euRtoUah.equals(that.euRtoUah) : that.euRtoUah != null) return false;
        if (euRtoUsd != null ? !euRtoUsd.equals(that.euRtoUsd) : that.euRtoUsd != null) return false;
        if (usDtoEur != null ? !usDtoEur.equals(that.usDtoEur) : that.usDtoEur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (uaHtoUsd != null ? uaHtoUsd.hashCode() : 0);
        result = 31 * result + (uaHtoEur != null ? uaHtoEur.hashCode() : 0);
        result = 31 * result + (usDtoUah != null ? usDtoUah.hashCode() : 0);
        result = 31 * result + (euRtoUah != null ? euRtoUah.hashCode() : 0);
        result = 31 * result + (euRtoUsd != null ? euRtoUsd.hashCode() : 0);
        result = 31 * result + (usDtoEur != null ? usDtoEur.hashCode() : 0);
        return result;
    }
}
