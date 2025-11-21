import java.util.ArrayList;
import java.util.List;

public class Restaurant {


        private String nom;
        private List<Plate> menu;
        private List<Commande> commandeList;


        public Restaurant(String nom) {
            this.nom = nom;
            this.menu = new ArrayList<>();
        }

        public void ajouterPlatMenu(Plate plat) {
            menu.add(plat);
        }

        public void afficherMenu() {
            System.out.println("Menu du restaurant" + nom + ":");
            for (Plate p : menu) {
                System.out.println("-" + p);

            }
        }

        public List<Commande> getCommande(){
            return commandeList;
        }

        public List<Plate> getMenu() {
            return menu;
        }

    }

