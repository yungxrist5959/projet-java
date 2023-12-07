package Gestion_Etudiants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Enseignant extends Personne {
	private List<String> matieres;
	private List<Cours> coursAffectes;
    private static List<Enseignant> listeEnseignants = new ArrayList<>();

    public Enseignant(String nom, String prenom, List<String> matieres) {
        super(nom, prenom);
        this.matieres = matieres;
        this.coursAffectes = new ArrayList<>();
        listeEnseignants.add(this);
    }
    public static void ajouterEnseignant(String nom, String prenom, List<String> matieres) {
        new Enseignant(nom, prenom, matieres);
    }
    public void modifierEnseignant(String nouveauNom, String nouveauPrenom, List<String> nouvellesMatieres) {
        this.nom = nouveauNom;
        this.prenom = nouveauPrenom;
        this.matieres = nouvellesMatieres;
    }
    
    public static Enseignant chercherEnseignant(String nom, String prenom) {
        for (Enseignant enseignant : listeEnseignants) {
            if (enseignant.nom.equals(nom) && enseignant.prenom.equals(prenom)) {
                return enseignant;
            }
        }
        return null; 
    }
     public static void supprimerEnseignant(String nom, String prenom) {
        Iterator<Enseignant> iterator = listeEnseignants.iterator();
            while (iterator.hasNext()) {
                Enseignant enseignant = iterator.next();
                if (enseignant.nom.equals(nom) && enseignant.prenom.equals(prenom)) {
                    iterator.remove();
                    break;
                }
            }
      }
     public static List<Enseignant> getListeEnseignants() {
         return listeEnseignants;
     }
     public void affecterCours(Cours cours) {
         coursAffectes.add(cours);
     }
     public List<Cours> getCoursAffectes() {
         return coursAffectes;
     }
     public List<String> getMatieres() {
         return matieres;
     }
     public void setMatieres(List<String> matieres) {
         this.matieres = matieres;
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
