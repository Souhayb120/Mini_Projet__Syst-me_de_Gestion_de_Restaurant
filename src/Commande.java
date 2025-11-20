import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private double total;
    private String detailsPlat;
    private Serveur serveur;
    private List<Plat> platList;
    private Client client;

    public Commande(int id, double total, String detailsPlat, Serveur serveur) {
        this.id = id;
        this.total = total;
        this.detailsPlat = detailsPlat;
        this.serveur = serveur;
        this.platList = new ArrayList<>();
    }


}
