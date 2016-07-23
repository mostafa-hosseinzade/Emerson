package Client;

import Entity.BrandEmerson;
import Entity.ServedEmerson;
import Entity.Services;
import Entity.ServicesCategory;
import SessionBean.BrandEmersonFacade;
import SessionBean.ServedEmersonFacade;
import SessionBean.ServicesCategoryFacade;
import SessionBean.ServicesFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "main")
@SessionScoped
public class Main implements Serializable {

    @ManagedProperty(value = "#{param.lang}")
    private String language;
    @ManagedProperty(value = "#{param.servicesid}")
    private Integer servicesId;
    private String title;
    private List<String> relatedBrand;

    public List<String> getRelatedBrand() {
        relatedBrand = new ArrayList<>();
        relatedBrand.add("EIM");
        relatedBrand.add("Dantorque");
        relatedBrand.add("Bettis");
        relatedBrand.add("El-O-Matic");
        relatedBrand.add("FieldQ");
        relatedBrand.add("and Instruments");
        relatedBrand.add("Fisher Regulators");
        relatedBrand.add("Francel");
        relatedBrand.add("Hytork");
        return relatedBrand;
    }

    public Integer getServicesId() {
        return servicesId;
    }

    public void setServicesId(Integer servicesId) {
        this.servicesId = servicesId;
    }

    @EJB
    private ServicesCategoryFacade serviceCategoryFacade;
    @EJB
    private ServedEmersonFacade servedEmersonFacade;
    @EJB
    private BrandEmersonFacade brandEmersonFacade;
    @EJB
    private ServicesFacade servicesFacade;

    private Services services;
    private ServicesCategory CoreOffering;
    private List<ServedEmerson> allServed;
    private List<BrandEmerson> allBrand;

    public Services getServices() {
        System.out.println("Client.Main.getServices() : Services Id : " + servicesId);
        if (servicesId != null) {
            return servicesFacade.find(servicesId);
        }
        return this.services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public ServicesCategory getCoreOffering() {
        return serviceCategoryFacade.find(2);
    }

    public void setCoreOffering(ServicesCategory CoreOffering) {
        this.CoreOffering = CoreOffering;
    }

    public String getTitle() {
        if (language == "EN") {
            title = "Piramoon";
        } else {
            title = "پیرامون";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        System.out.println("Client.Main.getTitle() Language is : " + language);
        if (language == null) {
            return "EN";
        }
        if (language == "EN") {
            return "EN";
        }
        return "FA";
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<ServedEmerson> getAllServed() {
        return servedEmersonFacade.findAll();
    }

    public List<BrandEmerson> getAllBrand() {
        return brandEmersonFacade.findAll();
    }
    
    
}
