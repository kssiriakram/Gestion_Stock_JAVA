package back;
public class FactureAchat extends Facture{

    private Fournisseur Fournisseur;

    public FactureAchat(Date date,Fournisseur fournisseur){
        super(date);
        Fournisseur=fournisseur;
    }
   public FactureAchat(){
        super();
   }
    @Override
    public void SaisirFacture(){
        System.out.println("Facture d'achat");
        super.SaisirFacture();
    }

    @Override
    public void AfficherFacture(){
        System.out.println("Facture d'achat");
        super.AfficherFacture();
        System.out.println("Inforamtion du fournisseur");
        Fournisseur.AfficherDetailFour();
    }

    public Fournisseur getFournisseur() {
        return Fournisseur;
    }


}
