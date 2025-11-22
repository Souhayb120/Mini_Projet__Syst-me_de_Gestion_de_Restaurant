import java.util.ArrayList;
import java.util.List;
public class Plate {
    private static int count = 1;
    private int id;
    private String nom;
    private double prix;
    private boolean special = false;
    private List<Commande> commandes;
    
    public Plate(String nom, double prix, boolean special) {
        this.id = count++;
        this.nom = nom;
        this.prix = prix;
        this.special = special ;
        this.commandes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

     public double getId() {
        return id;
    }

    public boolean getSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }


    @Override
    public String toString() {
        return "Plate{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", special=" + special +
                '}';
    }
}