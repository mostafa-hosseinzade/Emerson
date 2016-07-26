package Client;

import SessionBean.ContactFacade;
import Entity.Contact;
import JsfClass.util.JsfUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "Contacts", eager = true)
@SessionScoped
public class Contacts implements Serializable {
    
    private Contact contact;
    
    @EJB
    private ContactFacade cF;
    
    @PostConstruct
    public void PostContacts() {
        this.contact = new Contact();
    }
    
    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public void insert() {
        cF.create(this.contact);
        this.contact = new Contact();
        JsfUtil.addSuccessMessage("اطلاعات با موفقیت ثبت شد");        
    }
}
