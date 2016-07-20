package Client;

import Entity.BrandEmerson;
import Entity.ServedEmerson;
import Entity.ServicesCategory;
import SessionBean.BrandEmersonFacade;
import SessionBean.ServedEmersonFacade;
import SessionBean.ServicesCategoryFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "main")
public class Main {
    @ManagedProperty(value = "#{param.lang}")
    private String language;
    private String title;
    
    @EJB
    private ServicesCategoryFacade serviceCategoryFacade;
    @EJB
    private ServedEmersonFacade servedEmersonFacade;
    @EJB
    private BrandEmersonFacade brandEmersonFacade;
    
    private ServicesCategory CoreOffering;
    private List<ServedEmerson> allServed;
    private List<BrandEmerson> allBrand;
    
    public ServicesCategory getCoreOffering() {
        return serviceCategoryFacade.find(2);
    }

    public void setCoreOffering(ServicesCategory CoreOffering) {
        this.CoreOffering = CoreOffering;
    }
    
    public String getTitle() {
        if(language == "EN"){
            title = "Piramoon";
        }else{
            title="پیرامون";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public String getLanguage() {
        System.out.println("Client.Main.getLanguage() : lang is "+language);
        if(language== null){
            return "EN";
        }
        if(language == "EN"){
            return "EN";
        }
        return "FA";
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public List<ServedEmerson> getAllServed(){
       return servedEmersonFacade.findAll();
    }
    
    public List<BrandEmerson> getAllBrand(){
        return brandEmersonFacade.findAll();
    }
}
