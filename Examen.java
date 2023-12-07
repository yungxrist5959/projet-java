package Gestion_Etudiants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Examen {
    private String matiere;
    private String salle;
    private Date date;
    private String horaire;
    private static List<Examen> listeExamens = new ArrayList<>();
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

    public Examen(String matiere, String salle, Date date, String horaire) {
        this.matiere = matiere;
        this.salle = salle;
        this.date = date;
        this.horaire = horaire;
        listeExamens.add(this);
    }

    
    public static void ajouterExamen(String matiere, String salle, Date date, String horaire) {
        new Examen(matiere, salle, date, horaire);
    }

    
    public void modifierExamen(String nouvelleMatiere, String nouvelleSalle, Date nouvelleDate, String nouvelHoraire) {
        this.matiere = nouvelleMatiere;
        this.salle = nouvelleSalle;
        this.date = nouvelleDate;
        this.horaire = nouvelHoraire;
    }

   
    public static Examen chercherExamen(String matiere) {
        for (Examen examen : listeExamens) {
            if (examen.matiere.equals(matiere)) {
                return examen;
            }
        }
        return null; 
    }


    public static void supprimerExamen(String matiere) {
        Iterator<Examen> iterator = listeExamens.iterator();
        while (iterator.hasNext()) {
            Examen examen = iterator.next();
            if (examen.matiere.equals(matiere)) {
                iterator.remove();
                break;
            }
        }
    }

    
    public static List<Examen> getListeExamens() {
        return listeExamens;
    }
    public static void afficherListeExamens() {
        List<Examen> listeExamens = Examen.getListeExamens();
        System.out.println("Liste des examens :");
        for (Examen examen : listeExamens) {
            System.out.println("Matière : " + examen.getMatiere() +
                    ", Salle : " + examen.getSalle() +
                    ", Date : " + examen.getDate() +
                    ", Horaire : " + examen.getHoraire());
        }
        System.out.println();
    }

    
}

