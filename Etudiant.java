package Gestion_Etudiants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Etudiant extends Personne {
	 private String classe;
	 private double tauxAbsences;
	 private static List<Etudiant> listeEtudiants = new ArrayList<>();

	    public Etudiant(String nom, String prenom, String classe) {
	        super(nom, prenom);
	        this.classe = classe;
	        this.tauxAbsences = 0.3;
	        listeEtudiants.add(this);
	    }
	    public String getClasse() {
	        return classe;
	    }

	    
	    public void setClasse(String classe) {
	        this.classe = classe;
	    }
	    
	    public static void ajouterEtudiant(String nom, String prenom, String classe) {
	        new Etudiant(nom, prenom, classe);
	    }
	    public void modifierEtudiant(String nouveauNom, String nouveauPrenom, String nouvelleClasse) {
	        this.nom = nouveauNom;
	        this.prenom = nouveauPrenom;
	        this.classe = nouvelleClasse;
	    }
	    public static Etudiant chercherEtudiant(String nom, String prenom) {
	        for (Etudiant etudiant : listeEtudiants) {
	            if (etudiant.nom.equals(nom) && etudiant.prenom.equals(prenom)) {
	                return etudiant;
	            }
	        }
	        return null;
	    }
	    public static void supprimerEtudiant(String nom, String prenom) {
	        Iterator<Etudiant> iterator = listeEtudiants.iterator();
	        while (iterator.hasNext()) {
	            Etudiant etudiant = iterator.next();
	            if (etudiant.nom.equals(nom) && etudiant.prenom.equals(prenom)) {
	                iterator.remove();
	                break;
	            }
	        }
	    }
	    public static List<Etudiant> getListeEtudiants() {
	        return listeEtudiants;
	    }
	    public void enregistrerAbsence() {
	    	tauxAbsences += 0.1;
	    }
	    public double getTauxAbsences() {
	        return tauxAbsences;
	    }
	    public void setTauxAbsences(double tauxAbsences) {
	        this.tauxAbsences = tauxAbsences;
	    }
	    public double calculerMoyenneParMatiere(String matiere) {
	        double sommeNotes = 0;
	        int nombreNotes = 0;

	        for (Note note : Note.getListeNotes()) {
	            if (note.getEtudiant().equals(this) && note.getMatiere().equals(matiere)) {
	                sommeNotes += note.getValeur();
	                nombreNotes++;
	            }
	        }

	        return (nombreNotes > 0) ? sommeNotes / nombreNotes : 0;
	    }
	    public double calculerMoyenneGenerale() {
	        double sommeMoyennes = 0;
	        int nombreMatieres = 0;

	        List<String> matieres = new ArrayList<>();
	        matieres.add("mdw");
	        matieres.add("dsi");
	        for (String matiere : matieres) {
	            double moyenneMatiere = calculerMoyenneParMatiere(matiere);
	            sommeMoyennes += moyenneMatiere;
	            nombreMatieres++;
	        }

	        return (nombreMatieres > 0) ? sommeMoyennes / nombreMatieres : 0;
	    }
	    public boolean estAdmis(double moyenneMinimale) {
	        
	        double moyenneGenerale = calculerMoyenneGenerale();

	       
	        return moyenneGenerale >= moyenneMinimale;
	    }
	    public static void afficherInformations(Personne personne) {
	        System.out.println("Nom: " + personne.getNom());
	        System.out.println("Prenom: " + personne.getPrenom());

	        if (personne instanceof Etudiant) {
	            System.out.println("Classe: " + ((Etudiant) personne).getClasse());
	            System.out.println("Taux Absences: " + ((Etudiant) personne).getTauxAbsences());
	        } else if (personne instanceof Enseignant) {
	            System.out.println("Matieres: " + String.join(", ", ((Enseignant) personne).getMatieres()));
	            System.out.println("Cours Affectes: " + ((Enseignant) personne).getCoursAffectes().size());
	        }

	        System.out.println("------");
	    }
	    
}
