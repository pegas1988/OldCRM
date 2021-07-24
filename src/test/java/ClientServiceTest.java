import dao.ClientDao;
import entity.Client;
import org.junit.Before;
import org.junit.Test;
import service.ClientService;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientServiceTest {

    private ClientDao clientDao = mock(ClientDao.class);
    ClientService clientService;

    @Before
    public void init() {
        clientService = new ClientService(clientDao);
    }

    @Test
    public void findAll_IfEveryObjectReturns() {
        List<Client> clientList = Arrays.asList(
                new Client("Mike", "Belikiy"),
                new Client("Kate", "Kateovna"),
                new Client("Serj", "Suroviy")
        );

        when(clientDao.findAll()).thenReturn(clientList);

        List<Client> clientListReal = clientService.findAll();

        assertEquals(clientListReal.get(0), clientList.get(0));
        assertEquals(clientListReal.get(1), clientList.get(1));
        assertEquals(clientListReal.get(2), clientList.get(2));

    }

    @Test
    public void findByName_IfClientWillBeFind() {
        List<Client> clientList = Arrays.asList(
                new Client("Mike", "Belikiy"),
                new Client("Kate", "Kateovna"),
                new Client("Serj", "Suroviy")
        );

        when(clientDao.findByFirstNameAndSecondName("Mike", "Belikiy")).thenReturn(clientList.get(0));

        Client client = clientService.findByName("Mike", "Belikiy");

        assertEquals(client, clientList.get(0));
    }
}