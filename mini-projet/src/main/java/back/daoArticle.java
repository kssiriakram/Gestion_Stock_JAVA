package back;

import java.sql.*;

public class daoArticle {
        Connection MyCon ;

        public daoArticle(){
            MyCon = MySqlConnexion.getConnection();
        }
        public void Create_Article(Article article)
        {

            try{
                String req ;
                req = "insert into article values ('"+article.getNumArt()+"','"+article.getLibelle()+"')";
                Statement St = MyCon.createStatement();
                St.executeUpdate(req);
                System.out.println(" Ajout effectue");
            }
            catch (SQLException ex)
            {
                System.out.println("Pb dans la requete d'ajout!!!");
            }
        }




        public int Add_Article(Article article)
        {
            PreparedStatement Pst =null;
            int lig=0 ;

            try {
                String req;
                req = "insert into article values (?,?);";
                Pst = MyCon.prepareStatement(req);
                Pst.setInt(1, article.getNumArt());
                Pst.setString(2, article.getLibelle());


                lig = Pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Pb dans la requete d'ajout!!!");
            }


            return lig ;
        }




        public void Lister()
        {
            String req ;
            req= "select * from article ;";
            Statement St;
            try {
                St = MyCon.createStatement();
                ResultSet Rs= St.executeQuery(req);
                while(Rs.next()){

                    System.out.println(Rs.getInt("id_article") + "---->" + Rs.getString("libelle"));
                }




            }
            catch (SQLException ex)
            {
                System.out.println("Pb dans la requete select!!!");
            }

        }


        public void UpdateArticle(Article article) {
            PreparedStatement Pst;

            try {
                Pst = MyCon.prepareStatement("update  article set libelle=? where id_article=?");
                Pst.setString(1, article.getLibelle());
                Pst.setInt(2, article.getNumArt());
                if (Pst.executeUpdate() != 0)
                    System.out.println(" Mise à jour effectué ...");
                else
                    System.err.println(" This article n'existe pas ");

            } catch (SQLException ex) {
                System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
            }

        }




        public  int FindArticle(Article article)
        {

            String req;
            ResultSet Rs = null;
            req = "select * from article where libellle=?;";
            PreparedStatement Pst;
            try {
                Pst = MyCon.prepareStatement(req);
                Pst.setString(1, article.getLibelle());
                Rs = Pst.executeQuery();

                if (Rs.first()) {
                   return Rs.getInt("idarticle");
                } else
                    System.err.println(" Pas d'Article....");
            } catch (SQLException ex) {
                System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
            }
            return -1;
        }


    }


