import java.util.Objects;

class Urun {
    private static int urunIdCounter = 1;

    private int urunId;
    private String ad;
    private String marka;
    private double fiyat;

    private String urunCesidi;
    private int stokMiktari;

    public Urun(String ad, String marka, double fiyat, String urunCesidi, int stokMiktari) {
        this.urunId = urunIdCounter++;
        this.ad = ad;
        this.marka = marka;
        this.fiyat = fiyat;
        this.urunCesidi = urunCesidi;
        this.stokMiktari = stokMiktari;
    }

    public int getUrunId() {
        return urunId;
    }
    public double getFiyat(){
        return fiyat;
    }
    public String getAd() {
        return ad;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

public String getUrunCesidi(){
        return urunCesidi;
    }
    public String getMarka(){
        return marka;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun urun = (Urun) o;
        return Objects.equals(ad, urun.ad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ad);
    }



}