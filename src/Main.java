import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("restaurant");
        Scanner scanner = new Scanner(System.in);
        List<Commande> listCommande =  new ArrayList<>();
        restaurant.ajouterPlatMenu(new Plate("Pizza", 8,true));
        restaurant.ajouterPlatMenu(new Plate("Pâtes", 12,false));
        restaurant.ajouterPlatMenu(new Plate("Salade", 9, true));
        int choix;
        do {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1. Afficher le menu du restaurant");
            System.out.println("2. Passer une commande");
            System.out.println("3. Afficher toutes les commandes");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    restaurant.afficherMenu();
                    break;
                case 2:
                    System.out.print("Nom du client : ");
                    String nomClient = scanner.nextLine();

                    System.out.print("Combien de plats voulez-vous commander  ");
                    int nbPlats = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < nbPlats; i++) {
                        restaurant.afficherMenu();
                        System.out.print("Choisir plat (index) : ");
                        int indexPlat = scanner.nextInt();
                        scanner.nextLine();

                        if (indexPlat >= 0 && indexPlat < restaurant.getMenu().size()) {
                            commande.ajouterPlate(restaurant.getMenu().get(indexPlat));
                        } else {
                            System.out.println("Index invalide ");
                            i--;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n=== LISTE DES COMMANDES ===");
                    for (Commande c : restaurant.getCommande()) {
                        c.afficheDetails();
                        System.out.println("-------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        scanner.close();

    }
}