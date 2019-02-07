package Entity;

import javax.persistence.*;

@Entity
@Table(name = "currencyrates", schema = "public", catalog = "Bank")
public class CurrencyratesEntity {
    private String date;
    private double uahtousd;
    private double uahtoeur;
    private double usdtouah;
    private double eurtouah;
    private double eurtousd;
    private double usdtoeur;

    @Id
    @Column(name = "date", nullable = false, length = -1)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "uahtousd", nullable = false, precision = 0)
    public double getUahtousd() {
        return uahtousd;
    }

    public void setUahtousd(double uahtousd) {
        this.uahtousd = uahtousd;
    }

    @Basic
    @Column(name = "uahtoeur", nullable = false, precision = 0)
    public double getUahtoeur() {
        return uahtoeur;
    }

    public void setUahtoeur(double uahtoeur) {
        this.uahtoeur = uahtoeur;
    }

    @Basic
    @Column(name = "usdtouah", nullable = false, precision = 0)
    public double getUsdtouah() {
        return usdtouah;
    }

    public void setUsdtouah(double usdtouah) {
        this.usdtouah = usdtouah;
    }

    @Basic
    @Column(name = "eurtouah", nullable = false, precision = 0)
    public double getEurtouah() {
        return eurtouah;
    }

    public void setEurtouah(double eurtouah) {
        this.eurtouah = eurtouah;
    }

    @Basic
    @Column(name = "eurtousd", nullable = false, precision = 0)
    public double getEurtousd() {
        return eurtousd;
    }

    public void setEurtousd(double eurtousd) {
        this.eurtousd = eurtousd;
    }

    @Basic
    @Column(name = "usdtoeur", nullable = false, precision = 0)
    public double getUsdtoeur() {
        return usdtoeur;
    }

    public void setUsdtoeur(double usdtoeur) {
        this.usdtoeur = usdtoeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyratesEntity that = (CurrencyratesEntity) o;

        if (Double.compare(that.uahtousd, uahtousd) != 0) return false;
        if (Double.compare(that.uahtoeur, uahtoeur) != 0) return false;
        if (Double.compare(that.usdtouah, usdtouah) != 0) return false;
        if (Double.compare(that.eurtouah, eurtouah) != 0) return false;
        if (Double.compare(that.eurtousd, eurtousd) != 0) return false;
        if (Double.compare(that.usdtoeur, usdtoeur) != 0) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        temp = Double.doubleToLongBits(uahtousd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(uahtoeur);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(usdtouah);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(eurtouah);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(eurtousd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(usdtoeur);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
