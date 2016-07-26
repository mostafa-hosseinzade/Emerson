/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Entity.City;
import Entity.Order1;
import SessionBean.CityFacade;
import SessionBean.Order1Facade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Order {
    private Order1 order;
    private List<City> city;
    private boolean ShowForm = false;

    public boolean isShowForm() {
        return ShowForm;
    }

    public void setShowForm(boolean ShowForm) {
        this.ShowForm = ShowForm;
    }
    @EJB
    private Order1Facade order1Facade;
    @EJB
    private CityFacade cityFacade;
    
    public Order1 getOrder() {
        return order;
    }

    public void setOrder(Order1 order) {
        this.order = order;
    }

    public List<City> getCity() {
        return city;
    }
    
    
}
