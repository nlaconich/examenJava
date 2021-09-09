package py.com.ci.colegio.examen.presentation.console;

import java.util.List;
import java.util.Scanner;
import py.com.ci.colegio.examen.client.controller.ClientController;
import py.com.ci.colegio.examen.client.entities.Client;

/**
 *
 * @author nick
 */
public class ClientUI {

    Scanner sc = new Scanner(System.in);
    ClientController clientController = new ClientController();
    Client client = new Client();

    public static void main(String[] args) {
        ClientUI ui = new ClientUI();
        ui.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to ClientUI");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all Clients");
        System.out.println("2 : Add a Client");
        System.out.println("3 : Delete a Client");
        System.out.println("4 : Update a Client");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllClients();
                    break;
                case 2:
                    registerClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllClients() {
        List<Client> listClients=clientController.getAll();
        if (!listClients.isEmpty()) {
            for (Client client : listClients) {
                System.out.println(client);
            }
        } else {
            System.out.println("No client found");
        }
    }

    private void registerClient() {

        sc.nextLine();
        System.out.println("Insert Name");
        String name = sc.nextLine();
        System.out.println("Insert Last Name");
        String lastName = sc.nextLine();
        System.out.println("Insert Phone");
        String phone = sc.nextLine();
        System.out.println("Insert Address");
        String address = sc.nextLine();

        client.setClientName(name);
        client.setClientLastname(lastName);
        client.setClientPhone(phone);
        client.setClientAddress(address);

        clientController.add(client);
    }

    private void deleteClient() {
        this.listAllClients();

        System.out.println("Insert Id ");
        int id = sc.nextInt();
        client.setClientId(id);
        
        boolean ban = clientController.delete(client);
        if (ban == true) {
            System.out.println("Delete Successful");
        } else {
            System.out.println("Japiro");
        }
    }

    private void updateClient() {

        this.listAllClients();
        System.out.println("Insert Id ");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert new Name ");
        String name = sc.nextLine();
        System.out.println("Insert new Last Name");
        String lastName = sc.nextLine();
        System.out.println("Insert new Phone");
        String phone = sc.nextLine();
        System.out.println("Insert new Address");
        String address = sc.nextLine();

        client.setClientId(id);
        client.setClientName(name);
        client.setClientLastname(lastName);
        client.setClientPhone(phone);
        client.setClientAddress(address);

        boolean ban = clientController.update(client);
        if (ban == true) {
            System.out.println("Update Successful");
        } else {
            System.out.println("Japiro");
        }
    }
}
