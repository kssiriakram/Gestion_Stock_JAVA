package back;
import java.util.Scanner;

public class Fournisseur {
    private String NomFour;
    private String AdresseFour;
    private String ContactFour;


    public Fournisseur(String nomFour,String adresseFour,String contactFour){
        NomFour=nomFour;
        AdresseFour=adresseFour;
        ContactFour=contactFour;
    }

    public void SaisirDetailFour(){
        Scanner input = new Scanner(System.in);
        System.out.println("entrer un nom du fournisseur");
        NomFour=input.nextLine();
        System.out.println("entrer l'adresse du fournisseur");
        AdresseFour=input.nextLine();
        System.out.println("entrer le contact du  fournisseur");
        ContactFour=input.nextLine();

    }

    public void AfficherDetailFour(){
        System.out.println("un nom du fournisseur"+NomFour);
        System.out.println("l'adresse du fournisseur"+AdresseFour);

        System.out.println("le contact du  fournisseur"+ContactFour);

    }

    public String getNomFour() {
        return NomFour;
    }

    public String getContactFour() {
        return ContactFour;
    }

    public String getAdresseFour() {
        return AdresseFour;
    }
}
