import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
 static Scanner scanner = new Scanner(System.in);
static Restaurant restaurant = new Restaurant("restaurant");
 static int choixAdmin;
 static int choix;

 // admin functions
       static public void adminAddProduct(){
            try {
                 System.out.println("Add New Product");
                    System.out.print("Nom du product : ");
                    String nomProduct = scanner.nextLine();
                 
                  

                    System.out.print("Prix du product : ");
                    double prixProduct = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Statut du product : ");
                    boolean statutProduct = scanner.nextBoolean();
                    scanner.nextLine();

                    Plate plate = new Plate(nomProduct,prixProduct,statutProduct);
                    restaurant.ajouterPlatMenu(plate);
                    System.out.println("plate Added Successfully !!!");
            } catch (Exception e){
                System.out.println("Errore Admin ADD Product : " +  e);
            }
                   
        }

        static public void modeAdmin(){
try {
          System.out.print("Enter password : ");
                    int ps = scanner.nextInt();
                    scanner.nextLine();
                    if(ps == 123){
do{
 System.out.println("----------- welcome back Admin ! -----------");
                        System.out.println("==== MENU ADMIN ====");
                        System.out.println("1. Afficher le menu du restaurant");
                        System.out.println("2. Ajouter un plat");
                        System.out.println("3. delete un plate");
                        System.out.println("0. Quitter");
                        System.out.print("Votre choix : ");
                        choixAdmin = scanner.nextInt();
                        scanner.nextLine();

                        switch (choixAdmin) {
                            case 1:
                                restaurant.afficherMenu();
                                break;
                        case 2 :
                            adminAddProduct();
                            break;
                            case 3 :
                                adminDeleteProduct();
                                break;
                            default:
                                break;
                        }
}while(choixAdmin != 0);
                      
                    }else{
                        System.out.println("password incorrect !!");
                    }
} catch (Exception e) {
  System.out.println("Errore Mode Admin " + e);
}
      
        }

        static public void adminDeleteProduct(){
 
                 try {
                           restaurant.afficherMenu();
                        System.out.println("select plat to Delete ");
                        int idx = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (idx >= 0 && idx < restaurant.getMenu().size()) {
                            Plate p = restaurant.getMenu().get(idx);
                            restaurant.deletePlatMenu(p);;
                        } else {
                            System.out.println("Numéro invalide !");
                        }
                 } catch (Exception e) {
                    System.out.println("Errore Deleting Item " + e);
                 }
                    }

// menu Pricipale
static public void menuPrincipal(){
  try {
       System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1. Afficher le menu du restaurant");
            System.out.println("2. Passer une commande");
            System.out.println("3. Afficher toutes les commandes");
            System.out.println("4. admin mode");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
  } catch (Exception e) {
    System.out.println("Errore Menu Principal");
  }
}
 
static public void addClientCommand(){
       try {
            System.out.print("Nom du client : ");
                    String nomClient = scanner.nextLine();
                    Client client = new Client(nomClient);

                    System.out.print("Nom du serveur : ");
                    String nomServeur = scanner.nextLine();
                    Serveur serveur = new Serveur(nomServeur);

                    restaurant.afficherMenu();
                    System.out.print("Choisir premier plat  : ");
                    int index1 = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (index1 < 0 || index1 >= restaurant.getMenu().size()) {
                        System.out.println("Numéro invalide !");
                   
                    }

                    Plate firstPlate = restaurant.getMenu().get(index1);

                    Commande commande = new Commande(firstPlate, serveur, client);
                    commande.ajouterPlate(firstPlate);

                    System.out.print("Combien de plats  ? ");
                    int nbPlats = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 1; i < nbPlats; i++) {
                        restaurant.afficherMenu();
                        System.out.print("Choisir plat : ");
                        int idx = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (idx >= 0 && idx < restaurant.getMenu().size()) {
                            Plate p = restaurant.getMenu().get(idx);
                            commande.ajouterPlate(p);
                        } else {
                            System.out.println("Numéro invalide !");
                            i--;
                        }
                    }

                    restaurant.getCommande().add(commande);
                    serveur.takeCommande(commande);
                    System.out.println("Commande enregistrée !");
       } catch (Exception e) {
        System.out.println("Errore Serveur to Add Client Command: " + e);
       }
}

static public void historyCommandes(){
try {
          System.out.println("=== LISTE DES COMMANDES ===");
                    for (Commande c : restaurant.getCommande()) {
                        c.afficheDetails();
                       System.out.println("Total : " + c.calculatTotal() + " MAD");
                        System.out.println("-------------------------");
                    }
} catch (Exception e) {
   System.out.println("Errore displaying History Commandes: " + e);
}
}

        public static void main(String[] args) {
        restaurant.setCommandeList(new ArrayList<>());
        restaurant.ajouterPlatMenu(new Plate("Pizza", 8, true));
        restaurant.ajouterPlatMenu(new Plate("Pâtes", 12, false));
        restaurant.ajouterPlatMenu(new Plate("Salade", 9, true));



       // handling errors by Try Catch
  try {
        do {
           menuPrincipal();
            switch (choix) {
                case 1:
                restaurant.afficherMenu();
                break;
                case 2:
                addClientCommand();
                 break;
                case 3:
                  historyCommandes();
                break;
                case 4:
                 modeAdmin();
                 break;
                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
            } while (choix != 0);
 } catch (Exception e) {
                System.out.println("errore " + e);
            } 
        scanner.close();
    }
}