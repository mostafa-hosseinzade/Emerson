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
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id"),
    @NamedQuery(name = "News.findByCreatedAt", query = "SELECT n FROM News n WHERE n.createdAt = :createdAt"),
    @NamedQuery(name = "News.findByImg", query = "SELECT n FROM News n WHERE n.img = :img"),
    @NamedQuery(name = "News.findByMeta", query = "SELECT n FROM News n WHERE n.meta = :meta"),
    @NamedQuery(name = "News.findBySlug", query = "SELECT n FROM News n WHERE n.slug = :slug"),
    @NamedQuery(name = "News.findByTitleFa", query = "SELECT n FROM News n WHERE n.titleFa = :titleFa"),
    @NamedQuery(name = "News.findByUpdatedAt", query = "SELECT n FROM News n WHERE n.updatedAt = :updatedAt"),
    @NamedQuery(name = "News.findByVisit", query = "SELECT n FROM News n WHERE n.visit = :visit"),
    @NamedQuery(name = "News.findByTitleEn", query = "SELECT n FROM News n WHERE n.titleEn = :titleEn")})
public class News implements Serializable {

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
    @Column(name = "img")
    private String img;
    @Size(max = 255)
    @Column(name = "meta")
    private String meta;
    @Size(max = 255)
    @Column(name = "slug")
    private String slug;
    @Size(max = 255)
    @Column(name = "title_fa")
    private String titleFa;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "visit")
    private Integer visit;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "content_en")
    private String contentEn;
    @Size(max = 300)
    @Column(name = "title_en")
    private String titleEn;
    @JoinColumn(name = "ctg_id", referencedColumnName = "id")
    @ManyToOne
    private NewsCategory ctgId;

    public News() {
    }

    public News(Integer id) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
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

    public NewsCategory getCtgId() {
        return ctgId;
    }

    public void setCtgId(NewsCategory ctgId) {
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
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.News[ id=" + id + " ]";
    }

    @PrePersist
    public void PrePersisit() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void PreUpdate() {
        this.updatedAt = new Date();
    }
}
