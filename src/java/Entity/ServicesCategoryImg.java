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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "services_category_img")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesCategoryImg.findAll", query = "SELECT s FROM ServicesCategoryImg s"),
    @NamedQuery(name = "ServicesCategoryImg.findById", query = "SELECT s FROM ServicesCategoryImg s WHERE s.id = :id"),
    @NamedQuery(name = "ServicesCategoryImg.findByAlt", query = "SELECT s FROM ServicesCategoryImg s WHERE s.alt = :alt"),
    @NamedQuery(name = "ServicesCategoryImg.findByCreatedAt", query = "SELECT s FROM ServicesCategoryImg s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServicesCategoryImg.findByImg", query = "SELECT s FROM ServicesCategoryImg s WHERE s.img = :img"),
    @NamedQuery(name = "ServicesCategoryImg.findByUpdatedAt", query = "SELECT s FROM ServicesCategoryImg s WHERE s.updatedAt = :updatedAt")})
public class ServicesCategoryImg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "alt")
    private String alt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "services_category_id", referencedColumnName = "id")
    @ManyToOne
    private ServicesCategory servicesCategoryId;

    public ServicesCategoryImg() {
    }

    public ServicesCategoryImg(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ServicesCategory getServicesCategoryId() {
        return servicesCategoryId;
    }

    public void setServicesCategoryId(ServicesCategory servicesCategoryId) {
        this.servicesCategoryId = servicesCategoryId;
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
        if (!(object instanceof ServicesCategoryImg)) {
            return false;
        }
        ServicesCategoryImg other = (ServicesCategoryImg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ServicesCategoryImg[ id=" + id + " ]";
    }
    
    @PrePersist
    public void PrePersisit(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    public void PreUpdate(){
        this.updatedAt = new Date();
    }    
}
