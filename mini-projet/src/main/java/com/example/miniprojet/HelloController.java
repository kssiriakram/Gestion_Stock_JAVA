package com.example.miniprojet;

import back.*;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;

public class HelloController  {

     private static Vector<Integer> ligne_facture_vector = new Vector<Integer>();


    @FXML
    private TextField facture_achat_input;

    @FXML
    private TextField facture_vente_input;

    @FXML
    private ToggleGroup Toogle_acteur;

    @FXML
    private Tab Facture_achat_tab;

    @FXML
    private Tab Facture_vente_tab;

    @FXML
    private Tab Ligne_facture_tab;

    @FXML
    private TextField adresse_acteur_input;

    @FXML
    private Tab article_tab;

    @FXML
    private RadioButton client_ratio;

    @FXML
    private TextField contact_acteur_input;

    @FXML
    private DatePicker date_input;

    @FXML
    private DatePicker date_input1;

    @FXML
    private Button facture_achat_submit_cancel;

    @FXML
    private Button facture_achat_submit_ok;

    @FXML
    private Tab facture_achat_tab;

    @FXML
    private RadioButton fournisseur_ratio;

    @FXML
    private TextField id_client_input;

    @FXML
    private TextField id_fournisseur_input;

    @FXML
    private TextField id_ligne_facture_input;

    @FXML
    private TextField libelle_input;

    @FXML
    private TextField ligne_facture1;

    @FXML
    private Button ligne_facture_submit1;

    @FXML
    private TextField nom_acteur_input;

    @FXML
    private Tab nom_acteur_tab;

    @FXML
    private TextField num_article_input;

    @FXML
    private TextField prix_input;

    @FXML
    private TextField qte_input;

    @FXML
    private Button submit_Ligne_facture_ok;

    @FXML
    private Button submit_acteur_cancel;

    @FXML
    private Button submit_acteur_ok;

    @FXML
    private Button submit_article_cancel;

    @FXML
    private Button submit_article_ok;

    @FXML
    private Button submit_facture_vente_cancel;

    @FXML
    private Button submit_facture_vente_ok;

    @FXML
    private Button submit_ligne_facture_cancel;

    @FXML
    private Button submit_lignes_facture;

    @FXML
    void onChanged_Facture_achat_tab(Event event) {


    }

    @FXML
    void onChanged_Facture_vente_tab(Event event) {

    }

    @FXML
    void onChanged_Ligne_facture_tab(Event event) {

    }

    @FXML
    void onChanged_acteur_tab(Event event) {

    }

    @FXML
    void onChanged_adresse_acteur(Event event) {

    }

    @FXML
    void onChanged_article_libelle(Event event) {

    }

    @FXML
    void onChanged_article_tab(Event event) {

    }

    @FXML
    void onChanged_contact_acteur(Event event) {

    }

    @FXML
    void onChanged_date_input(Event event) {

    }

    @FXML
    void onChanged_id_client_input(Event event) {

    }

    @FXML
    void onChanged_id_fournisseur(Event event) {

    }

    @FXML
    void onChanged_ligne_facture(Event event) {

    }

    @FXML
    void onChanged_ligne_facture1(Event event) {

    }

    @FXML
    void onChanged_nom_acteur(Event event) {

    }

    @FXML
    void onChanged_num_article(Event event) {

    }

    @FXML
    void onChanged_prix(Event event) {

    }

    @FXML
    void onChanged_qte(Event event) {

    }

    @FXML
    void onSubmit_Ligne_facture_cancel(Event event) {

    }

    @FXML
    void onSubmit_Ligne_facture_ok(Event event) {
        if (!num_article_input.getText().isEmpty() && !prix_input.getText().isEmpty() && !qte_input.getText().isEmpty()) {
            int num_article = Integer.parseInt(num_article_input.getText());
            int prix = Integer.parseInt(prix_input.getText());
            int qte = Integer.parseInt(qte_input.getText());

            daoLigneFacture ligneFacture = new daoLigneFacture();
            int lign = ligneFacture.Add_LigneFacture(num_article, prix, qte);
            if (lign != 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success");

                // alert.setHeaderText("Results:");
                alert.setContentText(" ligne de commande ajoutee avec succes");

                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("erreur");

                // alert.setHeaderText("Results:");
                alert.setContentText("erreur d'ajout de ligne de commande");

                alert.showAndWait();
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur");

            // alert.setHeaderText("Results:");
            alert.setContentText("veuillez remplir tous les champs");

            alert.showAndWait();
        }
    }

    @FXML
    void onSubmit_acteur_cancel(Event event) {

    }

    @FXML
    void onSubmit_acteur_ok(Event event) {
        String  nom_acteur=nom_acteur_input.getText();
        String  adresse_acteur=adresse_acteur_input.getText();
        String  contact_acteur=contact_acteur_input.getText();

        daoActeur Acteur=new daoActeur();
        String type=null;
        Client client=null;
        Fournisseur fournisseur=null;
        int lign=0;
        if(client_ratio.isSelected() && !nom_acteur.isEmpty() && !adresse_acteur.isEmpty() && !contact_acteur.isEmpty()){
            type="Client";
            client = new Client(nom_acteur,adresse_acteur,contact_acteur);
            lign= Acteur.Add_Acteur(type,client,fournisseur);
        }
        else if(fournisseur_ratio.isSelected() && !nom_acteur.isEmpty() && !adresse_acteur.isEmpty() && !contact_acteur.isEmpty()){
            type="Fournisseur";
            fournisseur = new Fournisseur(nom_acteur,adresse_acteur,contact_acteur);
            lign= Acteur.Add_Acteur(type,client,fournisseur);
        }







        if(lign!=0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("success");

            // alert.setHeaderText("Results:");
            alert.setContentText(" acteur ajoutee avec succes");

            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur");

            // alert.setHeaderText("Results:");
            alert.setContentText("erreur d'ajout d'acteur");

            alert.showAndWait();

        }
    }



    @FXML
    void onSubmit_article_cancel(Event event) {

    }

    @FXML
    void onSubmit_article_ok(Event event) {

        String libelle=libelle_input.getText();
        Article article=null;
        if(!libelle.isEmpty()){
             article = new Article(libelle);
        }

        daoArticle  dao  =new daoArticle();
        int lign= dao.Add_Article(article);

            if(lign!=0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success");

                // alert.setHeaderText("Results:");
                alert.setContentText(" Article ajoutee avec succes");

                alert.showAndWait();

            }
            else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur");

            // alert.setHeaderText("Results:");
            alert.setContentText("erreur d'ajout d'article");

            alert.showAndWait();
        }

    }

    @FXML
    void onSubmit_facture_achat_cancel(Event event) {

    }

    @FXML
    void onSubmit_facture_achat_ok(Event event) {

        int id_fournisseur=Integer.parseInt(id_fournisseur_input.getText());
        int id_facture=Integer.parseInt(facture_achat_input.getText());
        LocalDate date=date_input1.getValue();
        if(!ligne_facture_vector.isEmpty() && !id_fournisseur_input.getText().isEmpty()) {


            daoFacture dao = new daoFacture();
            int i = 0;
            int lign = 0;
            for (i = 0; i < ligne_facture_vector.size(); i++) {
                lign = dao.Add_facture("Facture d'achat",id_facture, id_fournisseur, ligne_facture_vector.get(i),date);


                if (lign != 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("success");

                    // alert.setHeaderText("Results:");
                    alert.setContentText(" Facture ajoutee avec succes");

                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("erreur");

                    // alert.setHeaderText("Results:");
                    alert.setContentText("des lignes de facture ne sont pas ajoutee correctement");

                    alert.showAndWait();
                }
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur");

            // alert.setHeaderText("Results:");
            alert.setContentText("les lignes de facture ou le fournisseur n'existe pas");

            alert.showAndWait();
        }


        ligne_facture_vector.clear();
    }

    @FXML
    void onSubmit_facture_vente_cancel(Event event) {

    }

    @FXML
    void onSubmit_facture_vente_ok(Event event) {
        int id_client=Integer.parseInt(id_client_input.getText());
        int id_facture=Integer.parseInt(facture_vente_input.getText());
        LocalDate date = date_input.getValue();
        if(!ligne_facture_vector.isEmpty() && !id_client_input.getText().isEmpty()) {


            daoFacture dao = new daoFacture();
            int i=0;
            int lign=0;
            for ( i = 0; i < ligne_facture_vector.size(); i++) {
                lign = dao.Add_facture("Facture de vente",id_facture, id_client, ligne_facture_vector.get(i),date);


                if (lign != 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("success");

                    // alert.setHeaderText("Results:");
                    alert.setContentText(" Facture ajoutee avec succes");

                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("erreur");

                    // alert.setHeaderText("Results:");
                    alert.setContentText("des lignes de facture ne sont pas ajoutee correctement");

                    alert.showAndWait();
                }
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur");

            // alert.setHeaderText("Results:");
            alert.setContentText("les lignes de facture ou le fournisseur n'existe pas");

            alert.showAndWait();
        }


        ligne_facture_vector.clear();

    }

    @FXML
    void onSubmit_ligne_facture1(Event event) {

        ligne_facture_vector.add(Integer.parseInt(ligne_facture1.getText()));


    }

    @FXML
    void onSubmit_ligne_facture(Event event) {

        ligne_facture_vector.add(Integer.parseInt(id_ligne_facture_input.getText()));


    }


    @FXML
    public void onChanged_ratio(Event event) {

    }

    @FXML
    void onChanged_Facture_achat_input(Event event) {

    }

    @FXML
    void onChanged_Facture_vente_input(Event event) {

    }



}
