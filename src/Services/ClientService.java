package Services;

import DaoLayer.ClientDao;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import entities.Client;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Objects;

public class ClientService {
    ClientDao clientDao = new ClientDao();

    public List<Client> findAll() {
        List<Client> allClients = clientDao.findAll();
        if (allClients.isEmpty())
            System.out.println("List is empty");
        return allClients;
    }

    public List<Client> findByName(String name) {
        List<Client> byName = clientDao.findByName(name);
        if (Objects.isNull(byName)) {
            System.out.println(String.format("Clinet with name %s was not found", name));
        }
        return byName;
    }

    public void create(Client client) {
        clientDao.create(client);
    }
    public void delete(Client client) {
        clientDao.delete(client);
    }
    public void update(Client client) {clientDao.update(client);}
}
