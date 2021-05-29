package Services;

import DaoLayer.ClientDao;
import entities.Client;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        /*
        List<Client> allClients = clientService.findAll();
        for (Client client : allClients) {
            System.out.println(client);
        }

        System.out.println("");

        List<Client> byName = clientService.findByName("Romanova");
        for (Client client : byName) {
            System.out.println(client);
        }*/


        /*long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        Client clientOne = new Client("Nick", "Voznyak", date, "M", "Healthy");*/
        //clientService.create(clientOne);

        /*Client clientOne = new Client();
        clientOne.setLastName("Persik");
        clientService.delete(clientOne);*/

        Client clientOne = new Client();
        clientOne.setFirstName("Briatko");
        clientService.update(clientOne);

    }
}
