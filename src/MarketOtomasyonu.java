import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MarketOtomasyonu {
    private Stack<Urun> alisverisSepeti = new Stack<>();
    private HashMap<Integer, Urun> urunler = new HashMap<>();
    private LinkedList<Person> kullanicilar = new LinkedList<>();

    public void urunEkle(String ad, int urunID, String marka, double fiyat, String urunCesidi, int stokMiktari) {
        Urun yeniUrun = new Urun(ad, marka, fiyat, urunCesidi, stokMiktari);
        urunler.put(yeniUrun.getUrunId(), yeniUrun);
        System.out.println("Ürün eklendi: " + yeniUrun.getAd());
    }

    public void urunSil(int urunId) {
        Urun silinecekUrun = urunler.remove(urunId);
        if (silinecekUrun != null) {
            System.out.println("Ürün silindi: " + silinecekUrun.getAd());
        } else {
            System.out.println("Belirtilen ID'ye sahip bir ürün bulunamadı.");
        }
    }

    public void stokSorgula(int urunId) {
        Urun urun = urunler.get(urunId);
        if (urun != null) {
            System.out.println("Stok sorgulama: " + urun.getAd() + " - Stok Miktarı: " + urun.getStokMiktari());
        } else {
            System.out.println("Belirtilen ID'ye sahip bir ürün bulunamadı.");
        }
    }
    public void kullaniciEkle(Person person) {
        kullanicilar.add(person);
        System.out.println("Kullanıcı eklendi: " + person.getFirstName() + " " + person.getLastName());
    }
    public void setAlisverisSepeti(Stack<Urun> alisverisSepeti) {
        this.alisverisSepeti = alisverisSepeti;
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int secim;
        do {
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Ürün Sil");
            System.out.println("3. Stok Sorgula");
            System.out.println("4. Kullanıcı Ekle");
            System.out.println("5. Alışveriş Sepetine Ürün Ekle");
            System.out.println("6. Alışveriş Sepetini Göster");
            System.out.println("7. Çıkış");
            System.out.print("Yapmak istediğiniz işlemi seçin: ");

            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Ürün adı: ");
                    String ad = scanner.next();
                    System.out.println("Ürün Id: ");
                    int urunId = scanner.nextInt();
                    System.out.print("Marka: ");
                    String marka = scanner.next();
                    System.out.print("Fiyat: ");
                    double fiyat = scanner.nextDouble();
                    System.out.print("Ürün Çeşidi: ");
                    String urunCesidi = scanner.next();
                    System.out.print("Stok Miktarı: ");
                    int stokMiktari = scanner.nextInt();

                    urunEkle(ad, urunId, marka, fiyat, urunCesidi, stokMiktari);
                    break;

                case 2:
                    System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
                    int silinecekId = scanner.nextInt();
                    urunSil(silinecekId);
                    break;

                case 3:
                    System.out.print("Stok sorgulamak istediğiniz ürünün ID'sini girin: ");
                    int sorgulananId = scanner.nextInt();
                    stokSorgula(sorgulananId);
                    break;
                case 4:
                    System.out.print("Kullanıcı tipini seçin (1-Müşteri, 2-Çalışan): ");
                    int kullaniciTipi = scanner.nextInt();

                    System.out.print("Ad: ");
                    String firstName = scanner.next();
                    System.out.print("Soyad: ");
                    String lastName = scanner.next();

                    if (kullaniciTipi == 1) {
                        System.out.print("Müşteri ID: ");
                        int musteriId = scanner.nextInt();
                        System.out.print("E-posta: ");
                        String ePosta = scanner.next();

                        Musteri musteri = new Musteri(firstName, lastName, musteriId, ePosta);
                        kullaniciEkle(musteri);
                    } else if (kullaniciTipi == 2) {
                        System.out.print("Çalışan ID: ");
                        int calisanId = scanner.nextInt();
                        System.out.print("Maaş: ");
                        double salary = scanner.nextDouble();

                        Calisan calisan = new Calisan(firstName, lastName, calisanId, salary);
                        kullaniciEkle(calisan);
                    } else {
                        System.out.println("Geçersiz kullanıcı tipi.");
                    }
                    break;
                case 5:
                    System.out.print("Sepete eklemek istediğiniz ürünün ID'sini girin: ");
                    urunId = scanner.nextInt();
                    Urun urun = urunler.get(urunId);
                    if (urun != null) {
                        alisverisSepeti.push(urun);
                        System.out.println("Ürün sepete eklendi.");
                    } else {
                        System.out.println("Belirtilen ID'ye sahip bir ürün bulunamadı.");
                    }
                    break;

                case 6:
                    System.out.println("Alışveriş Sepeti:");
                    Stack<Urun> kopyaSepet = new Stack<>();
                    kopyaSepet.addAll(alisverisSepeti);
                    for (Urun urunSepet : kopyaSepet) {
                        System.out.println("- " + urunSepet.getAd());
                    }
                    break;

            }
        } while (secim != 7);}

    public void setAlisverisSepeti(AlisverisSepeti alisverisSepeti) {
    }
}
