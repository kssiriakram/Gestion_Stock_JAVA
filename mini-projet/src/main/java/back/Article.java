package back;
import java.util.Scanner;

public class Article {

	private int NumArt;
	private String Libelle;
	
	
	private static int Numseq=1;
	
	public Article (String libelle) {
		Libelle=libelle;
		NumArt=Numseq;
		Numseq++;
	}
	
	public Article(Article article) {
		Libelle=article.Libelle;
		NumArt=article.NumArt;
	}
	
	public void SaisirArticle() {
		Scanner input = new Scanner(System.in);
		System.out.println("entrer le libelle de l'article");
		Libelle= input.nextLine();

	}
	
	public String toString() {
		String output="Article: "+NumArt+"Libelle: "+Libelle;
		return output;
		
	}

	public String getLibelle() {
		return Libelle;
	}

	public int getNumArt() {
		return NumArt;
	}
}
