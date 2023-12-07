package Gestion_Etudiants;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class DS {
	private String matiere;
    private String salle;
    private Date date;
    private String horaire;
    private static List<DS> listeDS = new ArrayList<>();
    public DS(String matiere, String salle, Date date, String horaire) {
        this.matiere = matiere;
        this.salle = salle;
        this.date = date;
        this.horaire = horaire;
        listeDS.add(this);
    }
    public String getMatiere() {
        return matiere;
    }

   
    public void setMatiere(String matiere) {
        this.matiere = matiere;
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

    public static void ajouterDS(String matiere, String salle, Date date, String horaire) {
        new DS(matiere, salle, date, horaire);
    }
    public void modifierDS(String nouvelleMatiere, String nouvelleSalle, Date nouvelleDate, String nouvelHoraire) {
        this.matiere = nouvelleMatiere;
        this.salle = nouvelleSalle;
        this.date = nouvelleDate;
        this.horaire = nouvelHoraire;
    }
    public static DS chercherDS(String matiere) {
        for (DS ds : listeDS) {
            if (ds.matiere.equals(matiere)) {
                return ds;
            }
        }
        return null; 
    }
    public static void supprimerDS(String matiere) {
        Iterator<DS> iterator = listeDS.iterator();
        while (iterator.hasNext()) {
            DS ds = iterator.next();
            if (ds.matiere.equals(matiere)) {
                iterator.remove();
                break;
            }
        }
    }
    public static List<DS> getListeDS() {
        return listeDS;
    }
    public static void afficherListeDS() {
        List<DS> listeDS = DS.getListeDS();
        System.out.println("Liste des DS :");
        for (DS ds : listeDS) {
            System.out.println("Matière : " + ds.getMatiere() +
                    ", Salle : " + ds.getSalle() +
                    ", Date : " + ds.getDate() +
                    ", Horaire : " + ds.getHoraire());
        }
        System.out.println();
    }

}
