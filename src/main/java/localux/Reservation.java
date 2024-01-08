package localux;

import localux.vehicule.Vehicule;


public class Reservation {

    private String date;
    private Vehicule vehicule;
    private Responsable responsable;
    private Client client;

    public Reservation(String date, Vehicule vehicule, Responsable responsable, Client client) {
        this.date = date;
        this.vehicule = vehicule;
        this.responsable = responsable;
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }


    public Client getClient() {
        return this.client;
    }

    @Override
    public String toString() {
        return "Réservation effectuée le " + this.date +
                " pour le véhicule " + this.vehicule.getNom() +
                ". Le responsable est " + this.responsable.getNom() + " " + this.responsable.getPrenom() +
                " et le client est " + this.client.getNom() + " " + this.client.getPrenom() + ".";
    }

}