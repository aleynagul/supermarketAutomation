import java.util.LinkedList;
import java.util.List;

public class Musteri extends Person {
    private List<Urun> alisverisGecmisi;
    private int musteriId;
    private String ePosta;



    public Musteri(String firstName, String lastName, int musteriId, String ePosta) {
        super(firstName, lastName);
        this.musteriId = musteriId;
        this.ePosta = ePosta;
        this.alisverisGecmisi = new LinkedList<>();
    }

    public void alisverisGecmisiniYazdir() {
        System.out.println("Alışveriş Geçmişi:");
        for (Urun urun : alisverisGecmisi) {
            System.out.println("Ürün Adı: " + urun.getAd() + ", Fiyat: " + urun.getFiyat());
        }
    }

    public int getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }




}
