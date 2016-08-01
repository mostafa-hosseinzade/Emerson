/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Entity.City;
import Entity.Order1;
import Entity.Product;
import Entity.Province;
import JsfClass.util.JsfUtil;
import SessionBean.CityFacade;
import SessionBean.Order1Facade;
import SessionBean.ProductFacade;
import SessionBean.ProvinceFacade;
import com.sun.xml.ws.resources.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@SessionScoped
public class Order implements Serializable{

    private Order1 order;
    private List<City> city;
    private boolean ShowForm = false;
    private City citySelect;
    private List<Province> allProvince;
    private Province province;
    @ManagedProperty(value = "#{param.product_id}")
    private Integer productId;
    private Product product;
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Province> getAllProvince() {
        this.allProvince = provinceFacade.findAll();
        return allProvince;
    }

    public Province getProvince() {
        return province;
    }

    public City getCitySelect() {
        return citySelect;
    }

    public void setCitySelect(City citySelect) {
        System.out.println("Client.Order.setCitySelect() nnnnnnnnnnnnnnn " +citySelect);
        this.citySelect = citySelect;
    }

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
    @EJB
    private ProvinceFacade provinceFacade;
    @EJB
    private ProductFacade productFacade;
    
    public Order1 getOrder() {
        return order;
    }

    public void setOrder(Order1 order) {
        this.order = order;
    }

    @PostConstruct
    public void setAll() {
        this.order = new Order1();
    }

    public List<City> getCity() {
        this.city = cityFacade.findAll();
        return city;
    }

    public void insert() {
        if(productId != null){
        this.product = productFacade.find(this.productId);
        }
        order.setProductId(product);
        order.setBrandId(product.getBrandId());
        order1Facade.create(order);
        JsfUtil.addSuccessMessage("اطلاعات با موفقیت ثبت شد");     
    }
    private String cityId; 

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        System.out.println("Client.Order.setCityId()"+cityId);
        this.cityId = cityId;
    }
}
