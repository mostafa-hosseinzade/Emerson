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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findById", query = "SELECT s FROM Services s WHERE s.id = :id"),
    @NamedQuery(name = "Services.findByTitle", query = "SELECT s FROM Services s WHERE s.title = :title"),
    @NamedQuery(name = "Services.findByImg", query = "SELECT s FROM Services s WHERE s.img = :img"),
    @NamedQuery(name = "Services.findByVisit", query = "SELECT s FROM Services s WHERE s.visit = :visit"),
    @NamedQuery(name = "Services.findByMeta", query = "SELECT s FROM Services s WHERE s.meta = :meta"),
    @NamedQuery(name = "Services.findBySlug", query = "SELECT s FROM Services s WHERE s.slug = :slug"),
    @NamedQuery(name = "Services.findByPdf", query = "SELECT s FROM Services s WHERE s.pdf = :pdf"),
    @NamedQuery(name = "Services.findByCreatedAt", query = "SELECT s FROM Services s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "Services.findByUpdatedAt", query = "SELECT s FROM Services s WHERE s.updatedAt = :updatedAt")})
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Size(max = 300)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit")
    private int visit;
    @Size(max = 400)
    @Column(name = "meta")
    private String meta;
    @Size(max = 300)
    @Column(name = "slug")
    private String slug;
    @Size(max = 300)
    @Column(name = "pdf")
    private String pdf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "ctg_id", referencedColumnName = "id")
    @ManyToOne
    private ServicesCategory ctgId;

    public Services() {
    }

    public Services(Integer id) {
        this.id = id;
    }

    public Services(Integer id, String title, int visit, Date createdAt) {
        this.id = id;
        this.title = title;
        this.visit = visit;
        this.createdAt = createdAt;
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

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
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

    public ServicesCategory getCtgId() {
        return ctgId;
    }

    public void setCtgId(ServicesCategory ctgId) {
        this.ctgId = ctgId;
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
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Services[ id=" + id + " ]";
    }
    
}
