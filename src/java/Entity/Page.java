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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p"),
    @NamedQuery(name = "Page.findById", query = "SELECT p FROM Page p WHERE p.id = :id"),
    @NamedQuery(name = "Page.findByTitle", query = "SELECT p FROM Page p WHERE p.title = :title"),
    @NamedQuery(name = "Page.findByImg", query = "SELECT p FROM Page p WHERE p.img = :img"),
    @NamedQuery(name = "Page.findByVisit", query = "SELECT p FROM Page p WHERE p.visit = :visit"),
    @NamedQuery(name = "Page.findByMeta", query = "SELECT p FROM Page p WHERE p.meta = :meta"),
    @NamedQuery(name = "Page.findBySlug", query = "SELECT p FROM Page p WHERE p.slug = :slug"),
    @NamedQuery(name = "Page.findByCraetedAt", query = "SELECT p FROM Page p WHERE p.craetedAt = :craetedAt"),
    @NamedQuery(name = "Page.findByUpdatedAt", query = "SELECT p FROM Page p WHERE p.updatedAt = :updatedAt")})
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "title")
    private int title;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit")
    private int visit;
    @Size(max = 300)
    @Column(name = "meta")
    private String meta;
    @Size(max = 300)
    @Column(name = "slug")
    private String slug;
    @Basic(optional = false)
    @NotNull
    @Column(name = "craeted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date craetedAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Page() {
    }

    public Page(Integer id) {
        this.id = id;
    }

    public Page(Integer id, int title, String img, int visit, Date craetedAt) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.visit = visit;
        this.craetedAt = craetedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getCraetedAt() {
        return craetedAt;
    }

    public void setCraetedAt(Date craetedAt) {
        this.craetedAt = craetedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Page[ id=" + id + " ]";
    }
    
}
