package back;
import java.util.Scanner;

public class FactureVente extends Facture {
	
    private Client Client;
    
    public FactureVente(Client client,Date date) {
    	super(date);
    	Client=new Client(client);
    }
    public FactureVente(){
		super();
	}
	@Override 
	public void AfficherFacture() {
		System.out.println("Facture d'achat");
		super.AfficherFacture();
		System.out.println("information du client");
		Client.AfficherDetailClient();
	}


	@Override
	public void SaisirFacture() {
		System.out.println("Facture d'achat");
		super.SaisirFacture();
			}

	public Client getClient() {
		return Client;
	}
}

