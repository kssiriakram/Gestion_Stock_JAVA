/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elhaddadmohamed
 */
public class daoActeur {
    Connection MyCon ;
    public daoActeur()
    {
    
        MyCon = MySqlConnexion.getConnection();
    }
 public void Create_Acteur(String type ,Client client, Fournisseur fournisseur)
 {

            if(type.equalsIgnoreCase("Client")){
                try{

                    String req ;
                    req = "insert into acteur(type,nomClient,adresseClient,contactClient) values('"+type+"','"+client.getNomClient()+"','"+client.getAdresseClient()+"','"+client.getContactClient()+"')";
                    Statement St = MyCon.createStatement();
                    St.executeUpdate(req);
                    System.out.println(" Ajout effectue");
                }
                catch (SQLException ex)
                {
                    System.out.println("Pb dans la requete d'ajout!!!");
                }
            }
            else if(type.equalsIgnoreCase("Fournisseur")){
                try{

                    String req ;
                    req = "insert into acteur(type,nomFour,adresseFour,contactFour) values ('"+type+"','"+fournisseur.getNomFour()+"','"+fournisseur.getAdresseFour()+"','"+fournisseur.getContactFour()+"')";
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
 
 public int Add_Acteur(String type ,Client client, Fournisseur fournisseur)
 {
     PreparedStatement Pst =null;
     int lig=0 ;
     if(type.equalsIgnoreCase("Client")) {
         try {
             String req;
             req = "insert into acteur(type,nomClient,adresseClient,contactClient) values (?,?,?,?);";
             Pst = MyCon.prepareStatement(req);
             Pst.setString(1, type);
             Pst.setString(2, client.getNomClient());
             Pst.setString(3, client.getAdresseClient());
             Pst.setString(4, client.getContactClient());
             lig = Pst.executeUpdate();
         } catch (SQLException ex) {
             System.out.println("Pb dans la requete d'ajout!!!");
         }
     }
     else if(type.equalsIgnoreCase("Fournisseur")){
         try {
             String req;
             req = "insert into acteur(type,nomFour,adresseFour,contactFour) values (?,?,?,?);";
             Pst = MyCon.prepareStatement(req);
             Pst.setString(1, type);
             Pst.setString(2, fournisseur.getNomFour());
             Pst.setString(3, fournisseur.getAdresseFour());
             Pst.setString(4, fournisseur.getContactFour());
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
 
 
 
 
  public void Lister()
   {
       String req ;
       req= "select * from acteur ;";
         Statement St;
        try {
            St = MyCon.createStatement();
            ResultSet Rs= St.executeQuery(req);
          while(Rs.next())
          {   if(Rs.getString("type").equalsIgnoreCase("client")) {
              System.out.println(Rs.getString("type") + "---->" + Rs.getString("nomClient") + Rs.getString("adresseClient") + "---->"
                      + Rs.getString("contactClient"));
          }
          else{
              System.out.println(Rs.getString("type") + "---->" + Rs.getString("nomFour") +"--------->"+ Rs.getString("adresseFour") + "---->"
                      + Rs.getString("contactFour"));
          }
          }
            
            
            
        } 
        catch (SQLException ex)
        {
            System.out.println("Pb dans la requete select!!!");
         }
         
   }
  

   public void UpdateAdresse(String type ,Client client, Fournisseur fournisseur) {
       PreparedStatement Pst;
       if (type.equalsIgnoreCase("client")) {
           try {
               Pst = MyCon.prepareStatement("update  acteur set adresseClient=? where nomClient=? and contactClient=?");
               Pst.setString(1, client.getAdresseClient());
               Pst.setString(2, client.getNomClient());
               Pst.setString(3, client.getContactClient());
               if (Pst.executeUpdate() != 0)
                   System.out.println(" Mise à jour effectué ...");
               else
                   System.err.println(" ce client n'existe pas ");

           } catch (SQLException ex) {
               System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
           }
       }
       else if(type.equalsIgnoreCase("Fournisseur")){

           try {
               Pst = MyCon.prepareStatement("update  acteur set adresseFour=? where nomFour=? and contactFour=?");
               Pst.setString(1, fournisseur.getAdresseFour());
               Pst.setString(2, fournisseur.getNomFour());
               Pst.setString(3, fournisseur.getContactFour());
               if (Pst.executeUpdate() != 0)
                   System.out.println(" Mise à jour effectué ...");
               else
                   System.err.println(" ce fournisseur n'existe pas ");

           } catch (SQLException ex) {
               System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
           }
       }
       else{
           System.out.println("type inexistant!!");
       }
   }



    public void UpdateContact(String type ,Client client, Fournisseur fournisseur) {
        PreparedStatement Pst;
        if (type.equalsIgnoreCase("client")) {
            try {
                Pst = MyCon.prepareStatement("update  acteur set contactClient=? where nomClient=? and adresseClient=?");
                Pst.setString(1, client.getContactClient());
                Pst.setString(2, client.getNomClient());
                Pst.setString(3, client.getAdresseClient());

                if (Pst.executeUpdate() != 0)
                    System.out.println(" Mise à jour effectué ...");
                else
                    System.err.println(" ce client n'existe pas ");

            } catch (SQLException ex) {
                System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
            }
        }
        else if(type.equalsIgnoreCase("fournisseur")){

            try {
                Pst = MyCon.prepareStatement("update  acteur set adresseFour=? where nomFour=? and contactFour=?");
                Pst.setString(1, fournisseur.getAdresseFour());
                Pst.setString(2, fournisseur.getNomFour());
                Pst.setString(3, fournisseur.getContactFour());
                if (Pst.executeUpdate() != 0)
                    System.out.println(" Mise à jour effectué ...");
                else
                    System.err.println(" ce fournisseur n'existe pas ");

            } catch (SQLException ex) {
                System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
            }
        }
        else{
            System.out.println("type inexistant!!");
        }
    }
   
   public  void FindActeur(String type,String nomClient,String nomFour)
   {
       if(type.equalsIgnoreCase("client")) {
           String req;
           ResultSet Rs = null;
           req = "select * from acteur where nomClient=?;";
           PreparedStatement Pst;
           try {
               Pst = MyCon.prepareStatement(req);
               Pst.setString(1, nomClient);
               Rs = Pst.executeQuery();

               if (Rs.first()) {
                   System.out.println(Rs.getString("nomClient") + "  " + Rs.getString("adresseClient")+"  "+Rs.getString("contactClient"));
               } else
                   System.err.println(" Pas de client ....");
           } catch (SQLException ex) {
               System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
           }
       }
       else if(type.equalsIgnoreCase("fournisseur")){
           String req;
           ResultSet Rs = null;
           req = "select * from acteur where nomFour=?;";
           PreparedStatement Pst;
           try {
               Pst = MyCon.prepareStatement(req);
               Pst.setString(1, nomFour);
               Rs = Pst.executeQuery();

               if (Rs.first()) {
                   System.out.println(Rs.getString("nomFour") + "  " + Rs.getString("adresseFour")+"  "+Rs.getString("contactFour"));
               } else
                   System.err.println(" Pas de fournisseur ....");
           } catch (SQLException ex) {
               System.out.println(" Problème dans lA MISE à JOUR !!!!" + ex.getMessage());
           }
       }
       else{
           System.out.println("type inexistant!!");
       }
         
   }

    public  String FindActeurType(int id_acteur)
    {
        String req ;
        ResultSet Rs=null ;
        req= "select * from acteur where id_acteur=?;";
        PreparedStatement Pst;
        try {
            Pst= MyCon.prepareStatement(req);
            Pst.setInt(1, id_acteur);
            Rs=Pst.executeQuery();

            if(Rs.first())
            {
                return Rs.getString("type");
            }
            else

            return null;
        }
        catch (SQLException ex)
        {
            System.out.println(" ProblÃ¨me dans lA MISE Ã  JOUR !!!!"+ex.getMessage());
        }
        return null;
    }

}

