import java.util.Stack;
public class CalisanListesi {
    private Stack<Calisan> calisanListesi = new Stack<>();
    public Stack<Calisan> getCalisanListesiListesi() {
        return calisanListesi;
    }

    public void CalisanListesiniGoster() {
        System.out.println("Çalışan Listesi:");
        for (Calisan calisan : calisanListesi) {
            System.out.println("- " + calisan.toString());
        }
    }

}
