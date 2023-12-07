package Gestion_Etudiants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Cours {
	 private String nom;
	 private String salle;
	 private Date date;
	 private String horaire;
	 private List<Enseignant> enseignantsAffectes;
	 private static List<Cours> listeCours = new ArrayList<>();

	    public Cours(String nom , String salle, Date date, String horaire) {
	        this.nom = nom;
	        this.salle = salle;
	        this.date = date;
	        this.horaire = horaire;
	        this.enseignantsAffectes = new ArrayList<>();
	        listeCours.add(this);
	    }
	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getSalle() {
	        return salle;
	    }

	    public void setSalle(String salle) {
	        this.salle = salle;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getHoraire() {
	        return horaire;
	    }

	    public void setHoraire(String horaire) {
	        this.horaire = horaire;
	    }
	    public static void ajouterCours(String nom , String salle, Date date, String horaire) {
	        new Cours(nom , salle , date , horaire);
	    }
	    public void modifierCours(String nouveauNom) {
	        this.nom = nouveauNom;
	    }
	    public static Cours chercherCours(String nom) {
	        for (Cours cours : listeCours) {
	            if (cours.nom.equals(nom)) {
	                return cours;
	            }
	        }
	        return null; 
	    }
	    public static void supprimerCours(String nom) {
	        Iterator<Cours> iterator = listeCours.iterator();
	        while (iterator.hasNext()) {
	            Cours cours = iterator.next();
	            if (cours.nom.equals(nom)) {
	                iterator.remove();
	                break;
	            }
	        }
	    }
	    public static List<Cours> getListeCours() {
	        return listeCours;
	    }
	    public void affecterEnseignant(Enseignant enseignant) {
	        enseignantsAffectes.add(enseignant);
	    }
	    public List<Enseignant> getEnseignantsAffectes() {
	        return enseignantsAffectes;
	    }

}
