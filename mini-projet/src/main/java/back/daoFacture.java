package back;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;

public class daoFacture {
        Connection MyCon ;
        public daoFacture()
        {

            MyCon = MySqlConnexion.getConnection();
        }
        public void Create_Facture(String type,int id_acteur,int id_lignefacture)
        {

            if(type.equalsIgnoreCase("Facture de vente")){
                try{
                    String req ;
                    req = "insert into facteur values ('"+type+"','"+id_acteur+"','"+id_lignefacture+"')";
                    Statement St = MyCon.createStatement();
                    St.executeUpdate(req);
                    System.out.println(" Ajout effectue");
                }
                catch (SQLException ex)
                {
                    System.out.println("Pb dans la requete d'ajout!!!");
                }
            }
            else if(type.equalsIgnoreCase("Facture d'achat")){
                try{
                    String req ;
                    req = "insert into facture values ('"+type+"','"+id_acteur+"','"+id_lignefacture+"');";
                    Statement St = MyCon.createStatement();
                    St.executeUpdate(req);
                    System.out.println(" Ajout effectue");
                }
                catch (SQLException ex)
                {
                    System.out.println("Pb dans la requete d'ajout!!!");
                }
            }
            else{
                System.out.println("type inexistant!!!");
            }

        }

        public int Add_facture(String type ,int id_facture, int id_acteur, int id_lignefacture, LocalDate date)
        {
            PreparedStatement Pst =null;
            int lig=0 ;
            if(type.equalsIgnoreCase("Facture de vente")) {
                try {
                    String req;
                    req = "insert into facture(type,id_acteur,id_lignefacture,date,idfacture) values (?,?,?,?,?);";
                    Pst = MyCon.prepareStatement(req);
                    Pst.setString(1, type);
                    Pst.setInt(2, id_acteur);
                    Pst.setInt(3, id_lignefacture);
                    Pst.setDate(4, Date.valueOf(date));
                    Pst.setInt(5, id_facture);
                    lig = Pst.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Pb dans la requete d'ajout!!!");
                }
            }
            else if(type.equalsIgnoreCase("Facture d'achat")){
                try {
                    String req;
                    req = "insert into facture(type,id_acteur,id_lignefacture,date,idfacture) values (?,?,?,?,?);";
                    Pst = MyCon.prepareStatement(req);
                    Pst.setString(1, type);
                    Pst.setInt(2, id_acteur);
                    Pst.setInt(3, id_lignefacture);
                    Pst.setDate(4, Date.valueOf(date));
                    Pst.setInt(5, id_facture);
                    lig = Pst.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Pb dans la requete d'ajout!!!");
                }
            }
            else {
                System.out.println("type inexistant");
            }
            return lig ;
        }




        public void Lister(String type)
        {

            try {
                String req ;
                req= "select * from facture where type= '"+type+"';";
                Statement St;
                St = MyCon.createStatement();
                St.executeUpdate(req);
                ResultSet Rs= St.executeQuery(req);
                while(Rs.next()){

                    System.out.println(Rs.getString("type") + "---->" + Rs.getInt("id_article") + Rs.getInt("id_lignefacture")
                         );


                }



            }
            catch (SQLException ex)
            {
                System.out.println("Pb dans la requete select!!!");
            }

        }


        public void Updateid_articleEtid_lignefature(int id_article,int id_lignefacture,int id_facture) {
            PreparedStatement Pst;

                try {
                    Pst = MyCon.prepareStatement("update  facture set id_article=? and id_lignefacture=? where idfacture=?" );
                    Pst.setInt(1, id_article);
                    Pst.setInt(2, id_lignefacture);
                    Pst.setInt(3, id_facture);
                    if (Pst.executeUpdate() != 0)
                        System.out.println(" Mise à jour effectué ...");
                    else
                        System.err.println(" This client n'existe pas ");

                } catch (SQLException ex) {
                    System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
                }
            }


        public  ResultSet Find_facture_by_nom_acteur(String type,String nomActeur) {
            if (type.equalsIgnoreCase("client")) {
                try {
                    String req;
                    ResultSet Rs = null;
                    req = "select ar.libelle ,l.prix,l.qte, ac.nomclient from acteur ac join facture f" +
                            "join lignefacture l join article ar on ar.idarticle=l.id_article on f.id_lignefacture=l.idligneFacture   on f.id_acteur=ar.idArticle" +
                            "where ac.type=? and ac.nomclient=?";
                    PreparedStatement Pst;
                    Pst = MyCon.prepareStatement(req);
                    Pst.setString(1, type);
                    Pst.setString(2, nomActeur);
                    Rs = Pst.executeQuery();

                    return Rs;

                } catch (SQLException ex) {
                    System.out.println(" ProblÃ¨me dans lA MISE Ã  JOUR !!!!" + ex.getMessage());
                }
                return null;
            }
            else{
                try {
                    String req;
                    ResultSet Rs = null;
                    req = "select ar.libelle ,l.prix,l.qte, ac.nomFour from acteur ac join facture f" +
                            "join lignefacture l join article ar on ar.idarticle=l.id_article on f.id_lignefacture=l.idligneFacture   on f.id_acteur=ar.idArticle" +
                            "where ac.type=? and ac.nomFour=?";;
                    PreparedStatement Pst;
                    Pst = MyCon.prepareStatement(req);
                    Pst.setString(1,type );
                    Pst.setString(2,nomActeur );
                    Rs = Pst.executeQuery();

                    return Rs;
                } catch (SQLException ex) {
                    System.out.println(" ProblÃ¨me dans lA MISE Ã  JOUR !!!!" + ex.getMessage());
                }
                return null;
            }

        }


    }

