
public class Main {
    public static void main(String[] args) {
        MarketOtomasyonu market = new MarketOtomasyonu();
        AlisverisSepeti alisverisSepeti = new AlisverisSepeti();
       market.setAlisverisSepeti(alisverisSepeti);



        market.menu();



    }
}