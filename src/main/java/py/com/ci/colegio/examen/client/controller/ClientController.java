package py.com.ci.colegio.examen.client.controller;
import java.util.List;
import py.com.ci.colegio.examen.client.boundary.ClientManager;
import py.com.ci.colegio.examen.client.entities.Client;

/**
 *
 * @author nick
 */
public class ClientController {

    ClientManager clientManager = new ClientManager();

    public void add(Client client) {
        clientManager.add(client);
    }

    public List<Client> getAll() {
        List<Client> listClients = clientManager.getAll();
        return listClients;
    }

    public boolean update(Client client) {
        boolean ban = clientManager.updateById(client);
        return ban;
    }

    public boolean delete(Client client) {
        boolean ban = clientManager.deleteById(client);
        return ban;
    }
}
