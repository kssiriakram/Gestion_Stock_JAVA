package back;
import java.util.Scanner;

public class Client {
   
	private String NomClient;
	private String AdresseClient;
	private String ContactClient ;
	
	public Client(String nomClient,String adresseClient,String contactClient) {
		NomClient=nomClient;
		AdresseClient=adresseClient;
		ContactClient=contactClient;
	}
	
	public Client(Client client) {
		NomClient=client.NomClient;
		AdresseClient=client.AdresseClient;
		ContactClient=client.ContactClient;
	}
	
	public void SaisirDetailClient() {
		Scanner input = new Scanner(System.in);
		System.out.println("entrer le nom de client");
		NomClient = input.nextLine();
		String space = input.nextLine();
		System.out.println("entrer l'adresse de client");
		AdresseClient = input.nextLine();
		String space1 = input.nextLine();
		System.out.println("entrer le contact de client");
		ContactClient = input.nextLine();

		
	}
	
	public void AfficherDetailClient() {
		System.out.println("le nom de client: "+NomClient);
		System.out.println("l'adresse de client: "+AdresseClient);
		System.out.println("le Contact de client: "+ContactClient);
		
	}

	public String getNomClient() {
		return NomClient;
	}

	public String getContactClient() {
		return ContactClient;
	}

	public String getAdresseClient() {
		return AdresseClient;
	}
}
