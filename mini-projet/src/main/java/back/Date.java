package back;
import java.util.Scanner;

public class Date {

	private int Jour;
	private int Mois ;
	private int Annee;
	
	public Date(int jour,int mois,int annee) {
		Jour=jour;
		Mois=mois;
		Annee=annee;
		
	}
	
	public Date(Date date) {
		Jour=date.Jour;
		Mois=date.Mois;
		Annee=date.Annee;
		
	}
	
	public void SaisirDate() {
		Scanner input = new Scanner(System.in);
		System.out.println("entrer le jour");
		Jour=input.nextInt();
		System.out.println("entrer le mois");
		Mois=input.nextInt();
		System.out.println("entrer annee");
		Annee=input.nextInt();
		

	}
	
	public String toString() {
		return Jour+"/"+Mois +"/"+Annee;
		
	}

	public int getMois() {
		return Mois;
	}

	public int getJour() {
		return Jour;
	}

	public int getAnnee() {
		return Annee;
	}
}
