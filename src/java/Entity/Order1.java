/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "`order`")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByCompany", query = "SELECT o FROM Order1 o WHERE o.company = :company"),
    @NamedQuery(name = "Order1.findByName", query = "SELECT o FROM Order1 o WHERE o.name = :name"),
    @NamedQuery(name = "Order1.findByMobile", query = "SELECT o FROM Order1 o WHERE o.mobile = :mobile"),
    @NamedQuery(name = "Order1.findByEmail", query = "SELECT o FROM Order1 o WHERE o.email = :email"),
    @NamedQuery(name = "Order1.findByAddress", query = "SELECT o FROM Order1 o WHERE o.address = :address"),
    @NamedQuery(name = "Order1.findByPhone", query = "SELECT o FROM Order1 o WHERE o.phone = :phone"),
    @NamedQuery(name = "Order1.findByActivityCompany", query = "SELECT o FROM Order1 o WHERE o.activityCompany = :activityCompany"),
    @NamedQuery(name = "Order1.findByDescribtion", query = "SELECT o FROM Order1 o WHERE o.describtion = :describtion"),
    @NamedQuery(name = "Order1.findByUpdatedAt", query = "SELECT o FROM Order1 o WHERE o.updatedAt = :updatedAt"),
    @NamedQuery(name = "Order1.findByCreatedAt", query = "SELECT o FROM Order1 o WHERE o.createdAt = :createdAt")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "company")
    private String company;
    @Size(max = 300)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "email")
    private String email;
    @Size(max = 1200)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "phone")
    private String phone;
    @Size(max = 300)
    @Column(name = "activity_company")
    private String activityCompany;
    @Size(max = 3000)
    @Column(name = "describtion")
    private String describtion;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne
    private City cityId;
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    private BrandEmerson brandId;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, String company, String mobile, String email, String phone) {
        this.id = id;
        this.company = company;
        this.mobile = mobile;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivityCompany() {
        return activityCompany;
    }

    public void setActivityCompany(String activityCompany) {
        this.activityCompany = activityCompany;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public BrandEmerson getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandEmerson brandId) {
        this.brandId = brandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Order1[ id=" + id + " ]";
    }
    @PrePersist
    private void PrePersist(){
        this.createdAt = new Date();
    }
    @PreUpdate
    private void PreUpdate(){
        this.updatedAt = new Date();
    }
    
}
