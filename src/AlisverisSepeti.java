import java.util.Stack;

public class AlisverisSepeti {
    private Stack<Urun> alisverisSepeti = new Stack<>();

    public Stack<Urun> getAlisverisSepeti() {
        return alisverisSepeti;
    }

    public void urunEkle(Urun urun) {
        alisverisSepeti.push(urun);
        System.out.println("Ürün sepete eklendi: " + urun.getAd());
    }

    public void urunSil() {
        if (!alisverisSepeti.isEmpty()) {
            Urun urun = alisverisSepeti.pop();
            System.out.println("Ürün sepetten silindi: " + urun.getAd());
        } else {
            System.out.println("Sepet boş, silinecek ürün bulunmamaktadır.");
        }
    }

    public void sepetiGoster() {
        System.out.println("Alışveriş Sepeti:");
        for (Urun urun : alisverisSepeti) {
            System.out.println("- " + urun.getAd());
        }
    }
}

