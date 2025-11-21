import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private static int count = 1;
    private double total;
    private Serveur serveur;
    private List<Plate> platList;
    private Client client;
    private Plate plate;

    public Commande(Plate plate, Serveur serveur, Client client) {
        this.id = count++;
        this.serveur = serveur;
        this.client = client;
        this.plate = plate;
        this.platList = new ArrayList<>();
    }


    public void ajouterPlate(Plate p){
        this.platList.add(p);
    }

    public void ajouterClient(Client client){
        this.client = client;
    }

    public void ajouterServeur(Serveur serveur){
        this.serveur = serveur;
    }


//    public void calculatTotal(){
//
//    }
//
//    public void calculatTotal(){
//
//    }

    public void afficheDetails(){

            for(Plate plate : platList){
                System.out.println("plate " + plate.getNom() );
                System.out.println("prix : " + plate.getPrix() );
                System.out.println("Plate Statut : " +  (plate.getSpecial() ? "this is a special plate " : "normal plate") );
                System.out.println("Client name : " + this.client.getNom() );
                System.out.println("*".repeat(30));
            }
        System.out.println("serveur " + this.serveur.getName() );
        System.out.println("client " + this.client.getNom());
    }

    @Override
    public String toString() {
        return "Commande{" +
                "serveur=" + serveur +
                ", client=" + client +
                ", plate=" + plate +
                ", id=" + id +
                '}';
    }
}
