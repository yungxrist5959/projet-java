package Gestion_Etudiants;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;


public class Main {
	public static void main(String[] args) {

        Etudiant etudiant1 = new Etudiant("Nom1", "Prenom1", "mdw");
        Etudiant etudiant2 = new Etudiant("Nom2", "Prenom2", "dsi");

        
        List<String> matieresEnseignant1 = new ArrayList<>();
        matieresEnseignant1.add("mdw");
        Enseignant enseignant1 = new Enseignant("NomEnseignant1", "PrenomEnseignant1", matieresEnseignant1);

        List<String> matieresEnseignant2 = new ArrayList<>();
        matieresEnseignant2.add("dsi");
        Enseignant enseignant2 = new Enseignant("NomEnseignant2", "PrenomEnseignant2", matieresEnseignant2);

        
        Cours cours1 = new Cours("CoursMDW", "SalleA", new Date(), "10:00");
        Cours cours2 = new Cours("CoursDSI", "SalleB", new Date(), "14:00");

       
        enseignant1.affecterCours(cours1);
        enseignant2.affecterCours(cours2);
        
        etudiant1.afficherInformations(etudiant1);
        etudiant2.afficherInformations(etudiant2);
        enseignant1.afficherInformations(enseignant1);
        enseignant1.afficherInformations(enseignant2);
        
        Date date1 = parseDateDS("2023-01-01");
        DS.ajouterDS("Mathématiques", "Salle A", date1, "08:00");
        DS.afficherListeDS();
        
        Date date2 = parseDateExamen("2023-01-01");
        Examen.ajouterExamen("Developpement Web", "Salle C", date1, "10:00");
        Examen.afficherListeExamens();

        
        Note.attribuerNote(etudiant1, "Mathématiques", 15.5);
        Note.attribuerNote(etudiant2, "Developpement Web", 18.0);

       
        double moyenneEtudiant1MDW = Note.calculerMoyenne(etudiant1, "Mathématiques");
        double moyenneEtudiant2DSI = Note.calculerMoyenne(etudiant2, "Developpement Web");
        

        
        
        System.out.println("Moyenne de l'étudiant 1 en MDW : " + moyenneEtudiant1MDW);
        System.out.println("Moyenne de l'étudiant 2 en DSI : " + moyenneEtudiant2DSI);
    }
	public static Date parseDateDS(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	private static Date parseDateExamen(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	


    
    
}


