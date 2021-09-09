package py.com.ci.colegio.examen.client.boundary;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.colegio.examen.client.entities.Client;
import py.com.ci.colegio.examen.utils.ConnectionManager;

/**
 *
 * @author nick
 */
public class ClientManager {
    Client client = new Client();

    public String getStatement() {
        String statement = "SELECT id_client, name_client, lastname_client,phone_client"
                + ",address_client FROM public.client";
        return statement;
    }

    public void add(Client client) {
        String sql = "INSERT INTO public.client(name_client, lastname_client,address_client,phone_client) VALUES ( ?,?,?,?)";

        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, client.getClientName());
            s1.setString(2, client.getClientLastname());
            s1.setString(3, client.getClientAddress());
            s1.setString(4, client.getClientPhone());
            s1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Client> getAll() {
        List<Client> listClient = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listClient.add(getFromRsClient(rs));
                }
            }
            return listClient;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public boolean deleteById(Client client) {
        String sql = "DELETE FROM public.client WHERE id_client= ?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, client.getClientId());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean updateById(Client client) {
        String sql = "UPDATE public.client SET name_client=?, lastname_client=?,address_client=?,phone_client=? WHERE id_client=?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, client.getClientName());
            s1.setString(2, client.getClientLastname());
            s1.setString(3, client.getClientAddress());
            s1.setString(4, client.getClientPhone());
            s1.setInt(5, client.getClientId());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public Client getFromRsClient(ResultSet rs) {
        try {
            Client data = new Client();
            data.setClientId(rs.getInt("id_client"));
            data.setClientName(rs.getString("name_client"));
            data.setClientLastname(rs.getString("lastname_client"));
            data.setClientAddress(rs.getString("address_client"));
            data.setClientPhone(rs.getString("phone_client"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
     ClientManager clientManager = new ClientManager();
        List<Client> clientList = clientManager.getAll();
        System.out.println("all clients " + clientList.size());
        for (Client client : clientList)
            System.out.println("Client: " + client);
    }

}
