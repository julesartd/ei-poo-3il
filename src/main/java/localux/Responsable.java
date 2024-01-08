package localux;

public class Responsable {
    private String nom;
    private String prenom;

    public Responsable(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString() {
        return "Responsable : " + this.nom + " " + this.prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }


}
