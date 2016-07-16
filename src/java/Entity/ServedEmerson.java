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
@Table(name = "served_emerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServedEmerson.findAll", query = "SELECT s FROM ServedEmerson s"),
    @NamedQuery(name = "ServedEmerson.findById", query = "SELECT s FROM ServedEmerson s WHERE s.id = :id"),
    @NamedQuery(name = "ServedEmerson.findByCreatedAt", query = "SELECT s FROM ServedEmerson s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServedEmerson.findByImg", query = "SELECT s FROM ServedEmerson s WHERE s.img = :img"),
    @NamedQuery(name = "ServedEmerson.findByTitleFa", query = "SELECT s FROM ServedEmerson s WHERE s.titleFa = :titleFa"),
    @NamedQuery(name = "ServedEmerson.findByUpdatedAt", query = "SELECT s FROM ServedEmerson s WHERE s.updatedAt = :updatedAt"),
    @NamedQuery(name = "ServedEmerson.findByTitleEn", query = "SELECT s FROM ServedEmerson s WHERE s.titleEn = :titleEn")})
public class ServedEmerson implements Serializable {

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

    public ServedEmerson() {
    }

    public ServedEmerson(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServedEmerson)) {
            return false;
        }
        ServedEmerson other = (ServedEmerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ServedEmerson[ id=" + id + " ]";
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
