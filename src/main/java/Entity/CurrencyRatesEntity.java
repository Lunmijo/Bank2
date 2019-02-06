package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Currency_Rates", schema = "public", catalog = "Bank")
public class CurrencyRatesEntity {
    private String date;
    private Long id;
    private Double uaHtoUsd;
    private Double uaHtoEur;
    private Double usDtoUah;
    private Double euRtoUah;
    private Double euRtoUsd;
    private Double usDtoEur;

    @Basic
    @Column(name = "Date", nullable = false, length = -1)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UAHtoUSD", nullable = false, precision = 0)
    public Double getUaHtoUsd() {
        return uaHtoUsd;
    }

    public void setUaHtoUsd(Double uaHtoUsd) {
        this.uaHtoUsd = uaHtoUsd;
    }

    @Basic
    @Column(name = "UAHtoEUR", nullable = false, precision = 0)
    public Double getUaHtoEur() {
        return uaHtoEur;
    }

    public void setUaHtoEur(Double uaHtoEur) {
        this.uaHtoEur = uaHtoEur;
    }

    @Basic
    @Column(name = "USDtoUAH", nullable = false, precision = 0)
    public Double getUsDtoUah() {
        return usDtoUah;
    }

    public void setUsDtoUah(Double usDtoUah) {
        this.usDtoUah = usDtoUah;
    }

    @Basic
    @Column(name = "EURtoUAH", nullable = false, precision = 0)
    public Double getEuRtoUah() {
        return euRtoUah;
    }

    public void setEuRtoUah(Double euRtoUah) {
        this.euRtoUah = euRtoUah;
    }

    @Basic
    @Column(name = "EURtoUSD", nullable = false, precision = 0)
    public Double getEuRtoUsd() {
        return euRtoUsd;
    }

    public void setEuRtoUsd(Double euRtoUsd) {
        this.euRtoUsd = euRtoUsd;
    }

    @Basic
    @Column(name = "USDtoEUR", nullable = false, precision = 0)
    public Double getUsDtoEur() {
        return usDtoEur;
    }

    public void setUsDtoEur(Double usDtoEur) {
        this.usDtoEur = usDtoEur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyRatesEntity that = (CurrencyRatesEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
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
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (uaHtoUsd != null ? uaHtoUsd.hashCode() : 0);
        result = 31 * result + (uaHtoEur != null ? uaHtoEur.hashCode() : 0);
        result = 31 * result + (usDtoUah != null ? usDtoUah.hashCode() : 0);
        result = 31 * result + (euRtoUah != null ? euRtoUah.hashCode() : 0);
        result = 31 * result + (euRtoUsd != null ? euRtoUsd.hashCode() : 0);
        result = 31 * result + (usDtoEur != null ? usDtoEur.hashCode() : 0);
        return result;
    }
}
