
package py.com.ci.colegio.examen.client.entities;
public class Client {
    private int clientId;
    private String clientName;
    private String clientLastname;
    private String clientAddress;
    private String clientPhone;

    
    @Override
    public String toString() {
        return "clientId=" + clientId + 
                ", Name=" + clientName + 
                ", Lastname=" + clientLastname + 
                ", Address=" + clientAddress + 
                ", Phone=" + clientPhone+
                "\n--------------------------------";
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
}
