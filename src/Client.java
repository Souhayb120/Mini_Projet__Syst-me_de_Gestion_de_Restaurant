import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int count = 1;
    private int id;
    private String nom;
    private List<Commande> commandes;

    public Client( String nom) {
        this.id = count++;
        this.nom = nom;
        this.commandes = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }




    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + ''' +
                '}';
    }
}