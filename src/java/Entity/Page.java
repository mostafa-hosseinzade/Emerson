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
@Table(name = "page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p"),
    @NamedQuery(name = "Page.findById", query = "SELECT p FROM Page p WHERE p.id = :id"),
    @NamedQuery(name = "Page.findByCraetedAt", query = "SELECT p FROM Page p WHERE p.craetedAt = :craetedAt"),
    @NamedQuery(name = "Page.findByImg", query = "SELECT p FROM Page p WHERE p.img = :img"),
    @NamedQuery(name = "Page.findByMeta", query = "SELECT p FROM Page p WHERE p.meta = :meta"),
    @NamedQuery(name = "Page.findBySlug", query = "SELECT p FROM Page p WHERE p.slug = :slug"),
    @NamedQuery(name = "Page.findByTitleFa", query = "SELECT p FROM Page p WHERE p.titleFa = :titleFa"),
    @NamedQuery(name = "Page.findByUpdatedAt", query = "SELECT p FROM Page p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "Page.findByVisit", query = "SELECT p FROM Page p WHERE p.visit = :visit"),
    @NamedQuery(name = "Page.findByTitleEn", query = "SELECT p FROM Page p WHERE p.titleEn = :titleEn")})
public class Page implements Serializable {

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
    @Column(name = "craeted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date craetedAt;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Size(max = 255)
    @Column(name = "meta")
    private String meta;
    @Size(max = 255)
    @Column(name = "slug")
    private String slug;
    @Column(name = "title_fa")
    private Integer titleFa;
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
    private Date createdAt;

    public Page() {
    }

    public Page(Integer id) {
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

    public Date getCraetedAt() {
        return craetedAt;
    }

    public void setCraetedAt(Date craetedAt) {
        this.craetedAt = craetedAt;
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

    public Integer getTitleFa() {
        return titleFa;
    }

    public void setTitleFa(Integer titleFa) {
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

    @PrePersist
    public void PrePersisit() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void PreUpdate() {
        this.updatedAt = new Date();
    }
}
