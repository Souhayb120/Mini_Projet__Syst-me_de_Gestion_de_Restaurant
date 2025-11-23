import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String nom;
    private List<Plate> menu;
    private List<Commande> commandeList;

    public Restaurant(String nom) {
        this.nom = nom;
        this.menu = new ArrayList<>();
        this.commandeList = new ArrayList<>();
    }

    public void ajouterPlatMenu(Plate plat) {
        menu.add(plat);
    }
     public void deletePlatMenu(Plate plat) {
        menu.remove(plat);
        System.out.println(plat.getNom() + " removed successfully !!");
    }

    public void afficherMenu() {
        System.out.println("Menu du restaurant " + nom + ":");
        for (Plate p : menu) {
            System.out.println("- " + p.getId() + " "  + p.getNom() + " prix :" + p.getPrix() + ", Plate Statut : " +  (p.getSpecial() ? "this is a special plate " : "normal plate"));
        }
    }

    public List<Commande> getCommande() {
        return commandeList;
    }

    public List<Plate> getMenu() {
        return menu;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    public void ajouterCommande(Commande c) {
        this.commandeList.add(c);
    }
}
