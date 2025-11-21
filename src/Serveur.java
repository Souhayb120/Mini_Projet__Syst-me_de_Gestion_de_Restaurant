import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private int id;
    private static int count = 1;
    private String name;
    private List<Commande> commandeList;


    public Serveur(String name){
        this.id = count++;
        this.name = name;
        commandeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeCommande(Commande c){
        this.commandeList.add(c);
        c.afficheDetails();
        System.out.println("command add successfully !! by : " + this.getName());
        System.out.println("*".repeat(30));
    }


}
