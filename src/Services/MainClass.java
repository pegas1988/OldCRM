package Services;

import DaoLayer.ClientDao;
import entities.Client;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        List<Client> allClients = clientService.findAll();
        for(Client client: allClients){
            System.out.println(client);
        }

        System.out.println("");

        List<Client> byName = clientService.findByName("Romanova");
        for(Client client: byName){
            System.out.println(client);
        }
    }
}
