import java.util.Stack;
public class MusteriListesi {
    private Stack<Musteri> musteriListesi = new Stack<>();
    public Stack<Musteri> getMusteriListesi() {
        return musteriListesi;
    }

    public void musteriListesiniGoster() {
        System.out.println("Müşteri Listesi:");
        for (Musteri musteri : musteriListesi) {
            System.out.println("- " + musteri.toString());
        }
    }

}
