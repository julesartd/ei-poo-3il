package localux.vehicule;

public class Vehicule {
    private boolean estDisponible;
    private String nom;


    public Vehicule(String nom) {
        this.nom = nom;
        this.estDisponible = true;
    }

    public boolean estDisponible() {
        return estDisponible;
    }

    public void setDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return "vehicule.Vehicule : " + this.nom + "\n" + "Disponible : " + this.estDisponible;
    }


}