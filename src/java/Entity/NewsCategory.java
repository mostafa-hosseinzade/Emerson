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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "NewsCategory.findByTitle", query = "SELECT n FROM NewsCategory n WHERE n.title = :title"),
    @NamedQuery(name = "NewsCategory.findByDescribtion", query = "SELECT n FROM NewsCategory n WHERE n.describtion = :describtion"),
    @NamedQuery(name = "NewsCategory.findByCreatedAt", query = "SELECT n FROM NewsCategory n WHERE n.createdAt = :createdAt"),
    @NamedQuery(name = "NewsCategory.findByUpdatedAt", query = "SELECT n FROM NewsCategory n WHERE n.updatedAt = :updatedAt"),
    @NamedQuery(name = "NewsCategory.findByImg", query = "SELECT n FROM NewsCategory n WHERE n.img = :img")})
public class NewsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "title")
    private String title;
    @Size(max = 3000)
    @Column(name = "describtion")
    private String describtion;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 400)
    @Column(name = "img")
    private String img;
    @OneToMany(mappedBy = "ctgId")
    private Collection<News> newsCollection;

    public NewsCategory() {
    }

    public NewsCategory(Integer id) {
        this.id = id;
    }

    public NewsCategory(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
    
}
