import localux.Reservation;
import localux.Client;
import localux.Responsable;
import localux.vehicule.Vehicule;
import localux.vehicule.VehiculeFactory;
import localux.vehicule.VehiculeType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Main {

    public static void afficherVehicules(List<Vehicule> tousLesVehicules, List<Reservation> reservationsValide) {
        for (int i = 0; i < tousLesVehicules.size(); i++) {
            Vehicule vehicule = tousLesVehicules.get(i);
            if (vehicule.estDisponible()) {
                System.out.println((i + 1) + " - " + vehicule.getNom() + " [DISPONIBLE]");
            } else {
                for (Reservation reservation : reservationsValide) {
                    if (reservation.getVehicule().equals(vehicule)) {
                        System.out.println((i + 1) + " - " + vehicule.getNom() + " [Non disponible], réservé le " + reservation.getDate() + " par le client " + reservation.getClient().getNom() + " (Responsable : " + reservation.getResponsable().getNom() + ")");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // configurez ici votre école :
        // - Instantiation de vos voitures, clients, responsables...
        // - Le programme est déjà pré écrit, il ne reste qu'à compléter les TODO

        // instancie moi des voitures
        Vehicule voiture1 = VehiculeFactory.create("voiture1", VehiculeType.LUXE);
        Vehicule voiture2 = VehiculeFactory.create("voiture2", VehiculeType.STANDARD);
        Vehicule voiture3 = VehiculeFactory.create("voiture3", VehiculeType.DAUBE);

        List<Vehicule> tousLesVehicules = List.of(voiture1, voiture2, voiture3);

        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            NameGenerator.Names names = NameGenerator.generateNames();
            clients.add(new Client(names.getFirstName(), names.getLastName()));
        }

        List<Responsable> responsables = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            NameGenerator.Names names = NameGenerator.generateNames();
            responsables.add(new Responsable(names.getFirstName(), names.getLastName()));
        }

        List<Reservation> reservationsValide = new ArrayList<>();


        System.out.println("/_\\ Bienvenue sur LocaLux car manager!");

        // la Console permet de faciliter la récupération d'une saisie de l'utilisateur dans la console
        Console console = new Console();
        int functionToRun = -1;
        do {
            System.out.println("Qu'est-ce que tu veux faire?");
            System.out.println("1 - Lister les voitures disponibles");
            System.out.println("2 - Effectuer une réservation");
            System.out.println("3 - J'ai fini");

            functionToRun = console.captureInt(1, 4);
            // contrôle de la saisie
            switch (functionToRun) {
                case 1:
                    System.out.println("Voici la liste des voitures disponibles");

                    afficherVehicules(tousLesVehicules, reservationsValide);

                    break;
                case 2:

                    System.out.println("Quand voulez-vous réserver votre voiture?");
                    String dateSaisie = console.captureString();

                    System.out.println("Quelle voiture voulez-vous réserver?");

                    afficherVehicules(tousLesVehicules, reservationsValide);
                    int voitureSaisie = console.captureInt(1, 3);


                    System.out.println("Quel responsable ?");
                    for (int i = 0; i < responsables.size(); i++) {
                        Responsable responsable = responsables.get(i);
                        System.out.println((i + 1) + " - " + responsable.getNom() + " " + responsable.getPrenom());
                    }

                    int responsableSaisie = console.captureInt(1, 3);

                    System.out.println("Quel client ?");
                    for (int i = 0; i < clients.size(); i++) {
                        Client client = clients.get(i);
                        System.out.println((i + 1) + " - " + client.getNom() + " " + client.getPrenom());
                    }

                    int clientSaisie = console.captureInt(1, 4);

                    for (Reservation reservation : reservationsValide) {
                        if (reservation.getDate().equals(dateSaisie) && reservation.getVehicule().equals(tousLesVehicules.get(voitureSaisie - 1))) {
                            System.out.println("La voiture est déjà réservée ce jour");
                            return;
                        }


                    }
                    Reservation newReservation = new Reservation(dateSaisie, tousLesVehicules.get(voitureSaisie - 1), responsables.get(responsableSaisie - 1), clients.get(clientSaisie - 1));
                    reservationsValide.add(newReservation);
                    newReservation.getVehicule().setDisponible(false);

                    System.out.println("Votre réservation a bien été prise en compte");
                    System.out.println(newReservation);


                    break;
                case 3:
                    System.out.println("A la prochaine!");
                default:
                    System.err.println("Saisie invalide... tu dois choisir entre 1 et 3");
            }
            System.out.println("###################################################");

        } while (functionToRun != 3);

    }


}
