package back;

public class LigneFacture {

	private Article Article;
	private float Prix;
	private int Qte;
	
	public LigneFacture(Article article,float prix,int qte) {
		Article = new Article(article);
		Prix=prix;
		Qte=qte;
	}
	
	
		public void AfficherLigneFacture() {
			System.out.println("Facture: ");
			System.out.println("Article: "+Article);
			System.out.println("Prix: "+Prix);
			System.out.println("Qte: "+Qte);
			
		}
	
	public Article getArticle() {
		return Article;
	}
	
	public float getPrix() {
		return Prix;
	}
	
	public int getQte() {
		return Qte;
	}
	
	public void getArticle(Article article) {
		Article=new Article(article);
	}
	public void getPrix(float prix) {
		Prix=prix;
	}
	public void getQte(int  qte) {
		Qte=qte;
	}
}
