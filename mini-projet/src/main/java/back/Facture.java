package back;
import java.util.Scanner;
import java.util.Vector;

abstract public class Facture implements OperationFacture {
   
	private int NumFact;
	private Date Date;
	private Vector<LigneFacture> LigneFact= new Vector<LigneFacture>();
	private static int Numseq=0;
	
	/*on va ajouter un constructeur pour instancier les attributs
	 de la classe mere qu'ils seront utilises dans les  classes 
	 filles  	 */
	
	public Facture(Date date) {
		NumFact=Numseq;
		LigneFact=new Vector<LigneFacture>();
		Date=new Date(date);
	}
	public Facture(){}
	@Override
	public void AfficherFacture() {
		System.out.println("Facture: "+NumFact);
		System.out.println("Date: "+Date);
		for(int i=0;i<LigneFact.size();i++) {
			LigneFact.get(i).AfficherLigneFacture();
		}
	}
	@Override
	public void SaisirFacture() {
		Scanner input = new Scanner(System.in);
		System.out.println("entrer la date de la facture ");
		int choix=0;
		while(choix!=2){
			System.out.println("entrer une nouvelle article");
			System.out.println("Quittez");
			choix=input.nextInt();
			switch (choix){
			case 1 : {
				System.out.println("ajouter une article");
				System.out.println("ajouter le libelle de l'article");
				String libelle = input.nextLine();
				System.out.println("ajouter le prix de l'article");
				int prix = input.nextInt();
				System.out.println("ajouter la quantite commandee  de l'article");
				int qte = input.nextInt();
				LigneFact.add(new LigneFacture(new Article(libelle), prix, qte));
			}
			default : break;
			}
		}

	}

	@Override
	public float TotalFacture() {
		float res=0;
		for (int i=0;i<LigneFact.size();i++){
			res+=LigneFact.get(i).getPrix()*LigneFact.get(i).getQte();
		}
		return res;
	}

	public Vector<LigneFacture> getLigneFact() {
		return LigneFact;
	}

	public int getNumFact() {
		return NumFact;
	}

	public Date getDate() {
		return Date;
	}
}

