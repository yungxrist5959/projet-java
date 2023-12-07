package Gestion_Etudiants;
import java.util.ArrayList;
import java.util.List;

class Note {
    private Etudiant etudiant;
    private String matiere;
    private double valeur;

    private static List<Note> listeNotes = new ArrayList<>();
    public Note(Etudiant etudiant, String matiere, double valeur) {
        this.etudiant = etudiant;
        this.matiere = matiere;
        this.valeur = valeur;
        listeNotes.add(this);
    }
    public static void attribuerNote(Etudiant etudiant, String matiere, double valeur) {
        
        if (etudiant.getTauxAbsences() > 0.3) {
            valeur = 0; 
        }
        new Note(etudiant, matiere, valeur);
    }
    public static double calculerMoyenne(Etudiant etudiant, String matiere) {
        double sommeNotes = 0;
        int nombreNotes = 0;

        for (Note note : listeNotes) {
            if (note.etudiant.equals(etudiant) && note.matiere.equals(matiere)) {
                sommeNotes += note.valeur;
                nombreNotes++;
            }
        }

        if (nombreNotes == 0) {
            return 0; 
        }

        return sommeNotes / nombreNotes;
    }
	public double getValeur() {
		return valeur;
	}
	public Object getMatiere() {
		return matiere;
	}
	public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public static List<Note> getListeNotes() {
        return listeNotes;
    }

    
    public static void setListeNotes(List<Note> listeNotes) {
        Note.listeNotes = listeNotes;
    }

    
    
    
    
    
    
}