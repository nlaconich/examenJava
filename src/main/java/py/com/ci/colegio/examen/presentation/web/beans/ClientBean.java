package py.com.ci.colegio.examen.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.colegio.examen.client.controller.ClientController;
import py.com.ci.colegio.examen.client.entities.Client;


@Named("clientBean")
@SessionScoped
public class ClientBean implements Serializable {

    private Client client;
    private ClientController clientController;
    private List<Client> clientList;

    @PostConstruct
    public void init() {
        this.client = new Client();
        this.clientController = new ClientController();
        this.clientList = clientController.getAll();
        logClient();
        RequestContext.getCurrentInstance().update("client-form:dtClient");
    }

    private void logClient() {
        if (clientList != null && !clientList.isEmpty()) {
            System.out.println("ClientBean  - init > " + clientList.size());
        } else {
            System.out.println("ClientBean  - init > no result found");
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public void addClient() {
        clientController.add(client);
        init();
    }

    public void updateClient() {
        clientController.update(client);
        init();
    }

    public void deleteClient() {
        clientController.delete(client);
        init();
    }

    public void onSelect(SelectEvent event) {
        this.client = (Client) event.getObject();

        FacesMessage msg = new FacesMessage("Client Selected id", String.valueOf(client.getClientId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("ClientBean > Select Row > " + this.client);

    }
}
