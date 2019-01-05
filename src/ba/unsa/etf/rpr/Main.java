package ba.unsa.etf.rpr;
import java.util.Scanner;

public class Main{
    private static GeografijaDAO baza = GeografijaDAO.getInstance();

    
    public static void main(String[] args) {
        System.out.println("1) Ispis gradova");
        System.out.println("2) Ispis glavnog grada");
        System.out.print("Ulaz: ");
        Scanner ulaz = new Scanner(System.in);
        int izbor = ulaz.nextInt();
        switch (izbor) {
            case 1:
                System.out.println("Gradovi su:\n" + ispisiGradove());
                break;
            case 2:
                System.out.print("Unesite naziv drzave: ");
                glavniGrad();
                break;
        }
    }


    private static void glavniGrad() {
        Scanner ulaz = new Scanner(System.in);
        String drzava = ulaz.nextLine();
        var grad = baza.glavniGrad(drzava);
        System.out.println("Glavni grad države " + grad.getDrzava().getNazivDrzave() + " je " + grad.getNazivGrad());
    }

    public static String ispisiGradove() {
        var gradovi = baza.gradovi();
        String result = "";
        for (var grad : gradovi)
            result += grad.gradString() + "\n";
        return result;
    }

}
