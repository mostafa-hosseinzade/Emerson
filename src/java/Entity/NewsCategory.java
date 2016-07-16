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
@Table(name = "news_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsCategory.findAll", query = "SELECT n FROM NewsCategory n"),
    @NamedQuery(name = "NewsCategory.findById", query = "SELECT n FROM NewsCategory n WHERE n.id = :id"),
    @NamedQuery(name = "NewsCategory.findByCreatedAt", query = "SELECT n FROM NewsCategory n WHERE n.createdAt = :createdAt"),
    @NamedQuery(name = "NewsCategory.findByDescribtionFa", query = "SELECT n FROM NewsCategory n WHERE n.describtionFa = :describtionFa"),
    @NamedQuery(name = "NewsCategory.findByImg", query = "SELECT n FROM NewsCategory n WHERE n.img = :img"),
    @NamedQuery(name = "NewsCategory.findByTitleFa", query = "SELECT n FROM NewsCategory n WHERE n.titleFa = :titleFa"),
    @NamedQuery(name = "NewsCategory.findByUpdatedAt", query = "SELECT n FROM NewsCategory n WHERE n.updatedAt = :updatedAt"),
    @NamedQuery(name = "NewsCategory.findByDescribtionEn", query = "SELECT n FROM NewsCategory n WHERE n.describtionEn = :describtionEn"),
    @NamedQuery(name = "NewsCategory.findByTitleEn", query = "SELECT n FROM NewsCategory n WHERE n.titleEn = :titleEn")})
public class NewsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Size(max = 3000)
    @Column(name = "describtion_fa")
    private String describtionFa;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Size(max = 255)
    @Column(name = "title_fa")
    private String titleFa;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 3000)
    @Column(name = "describtion_en")
    private String describtionEn;
    @Size(max = 300)
    @Column(name = "title_en")
    private String titleEn;
    @OneToMany(mappedBy = "ctgId")
    private Collection<News> newsCollection;

    public NewsCategory() {
    }

    public NewsCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescribtionFa() {
        return describtionFa;
    }

    public void setDescribtionFa(String describtionFa) {
        this.describtionFa = describtionFa;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDescribtionEn() {
        return describtionEn;
    }

    public void setDescribtionEn(String describtionEn) {
        this.describtionEn = describtionEn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
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
        if (!(object instanceof NewsCategory)) {
            return false;
        }
        NewsCategory other = (NewsCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.NewsCategory[ id=" + id + " ]";
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
