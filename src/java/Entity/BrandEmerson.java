/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "brand_emerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandEmerson.findAll", query = "SELECT b FROM BrandEmerson b"),
    @NamedQuery(name = "BrandEmerson.findById", query = "SELECT b FROM BrandEmerson b WHERE b.id = :id"),
    @NamedQuery(name = "BrandEmerson.findByCreatedAt", query = "SELECT b FROM BrandEmerson b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BrandEmerson.findByLink", query = "SELECT b FROM BrandEmerson b WHERE b.link = :link"),
    @NamedQuery(name = "BrandEmerson.findByTitleFa", query = "SELECT b FROM BrandEmerson b WHERE b.titleFa = :titleFa"),
    @NamedQuery(name = "BrandEmerson.findByUpdatedAt", query = "SELECT b FROM BrandEmerson b WHERE b.updatedAt = :updatedAt"),
    @NamedQuery(name = "BrandEmerson.findByTitleEn", query = "SELECT b FROM BrandEmerson b WHERE b.titleEn = :titleEn")})
public class BrandEmerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "content_fa")
    private String contentFa;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Size(max = 255)
    @Column(name = "link")
    private String link;
    @Size(max = 255)
    @Column(name = "title_fa")
    private String titleFa;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "content_en")
    private String contentEn;
    @Size(max = 300)
    @Column(name = "title_en")
    private String titleEn;
    @OneToMany(mappedBy = "brandId")
    private Collection<Product> productCollection;

    public BrandEmerson() {
    }

    public BrandEmerson(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentFa() {
        return contentFa;
    }

    public void setContentFa(String contentFa) {
        this.contentFa = contentFa;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitleFa() {
        return titleFa;
    }

    public void setTitleFa(String titleFa) {
        this.titleFa = titleFa;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
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
        if (!(object instanceof BrandEmerson)) {
            return false;
        }
        BrandEmerson other = (BrandEmerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BrandEmerson[ id=" + id + " ]";
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
