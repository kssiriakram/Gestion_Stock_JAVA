package back;

import java.sql.*;

public class daoLigneFacture {
    Connection MyCon ;

     public daoLigneFacture(){
        MyCon = MySqlConnexion.getConnection();
    }
    public void Create_LigneFacture(int id_article,float prix,int qte)
    {

            try{
                String req ;
                req = "insert into lignefacture values ('"+prix+"','"+qte+"','"+id_article+"')";
                Statement St = MyCon.createStatement();
                St.executeUpdate(req);
                System.out.println(" Ajout effectue");
            }
            catch (SQLException ex)
            {
                System.out.println("Pb dans la requete d'ajout!!!");
            }
        }




    public int Add_LigneFacture(int id_article,float prix,int qte)
    {
        PreparedStatement Pst =null;
        int lig=0 ;

            try {
                String req;
                req = "insert into lignefacture(id_article,prix,qte) values (?,?,?);";
                Pst = MyCon.prepareStatement(req);
                Pst.setInt(1, id_article);
                Pst.setFloat(2, prix);
                Pst.setInt(3, qte);

                lig = Pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Pb dans la requete d'ajout!!!");
            }


        return lig ;
    }




    public void Lister()
    {
        String req ;
        req= "select * from lignefacture ;";
        Statement St;
        try {
            St = MyCon.createStatement();
            ResultSet Rs= St.executeQuery(req);
            while(Rs.next()){

                System.out.println(Rs.getInt("id_article") + "---->" + Rs.getFloat("prix") +"--------->"+ Rs.getInt("qte"));
            }




        }
        catch (SQLException ex)
        {
            System.out.println("Pb dans la requete select!!!");
        }

    }


    public void UpdatePrixEtQte(int id_article,float prix,int qte) {
        PreparedStatement Pst;

            try {
                Pst = MyCon.prepareStatement("update  lignefacture set prix=? and qte=? where id_article=?");
                Pst.setFloat(1, prix);
                Pst.setInt(2, qte);
                Pst.setInt(3, id_article);
                if (Pst.executeUpdate() != 0)
                    System.out.println(" Mise à jour effectué ...");
                else
                    System.err.println(" This ligne facture n'existe pas ");

            } catch (SQLException ex) {
                System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
            }

    }




    public  int  FindLigneArticle(int id_article)
    {

            String req;
            ResultSet Rs = null;
            req = "select * from lignefacture where id_article=?;";
            PreparedStatement Pst;
            try {
                Pst = MyCon.prepareStatement(req);
                Pst.setInt(1, id_article);
                Rs = Pst.executeQuery();

                if (Rs.first()) {
                    return Rs.getInt("idligneFacture");
                } else
                    System.err.println(" Pas de LigneFacture ....");
            } catch (SQLException ex) {
                System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
            }
            return -1;
        }


    }


