package py.com.ci.colegio.examen.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import py.com.ci.colegio.examen.sale.controller.SaleController;
import py.com.ci.colegio.examen.sale.entities.Sale;

@Named("saleBean")
@SessionScoped
public class SaleBean implements Serializable{

    private Sale sale;
    private SaleController saleController;
    private List<Sale> saleList;

    @PostConstruct
    public void init() {
        sale = new Sale();
        saleController = new SaleController();
        saleList = saleController.getAll();

        logSale();
    }

    private void logSale() {
        if (saleList != null && !saleList.isEmpty()) {
            System.out.println("SaleBean  - init > " + saleList.size());
        } else {
            System.out.println("SaleBean  - init > no result found");
        }
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }
    
    public void addSale(){
        saleController.add(sale);
        init();
    }
    
    public void updateSale(){
        saleController.update(sale);
        init();
    }
    
    public void deleteSale(){
        saleController.delete(sale);
        init();
    }
    
    public void onSelect(SelectEvent event) {
        this.sale = (Sale) event.getObject();

        FacesMessage msg = new FacesMessage("Sale Selected id", String.valueOf(sale.getSaleId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("SaleBean > Select Row > " + this.sale);

    }
}
