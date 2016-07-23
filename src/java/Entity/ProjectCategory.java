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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "project_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectCategory.findAll", query = "SELECT p FROM ProjectCategory p"),
    @NamedQuery(name = "ProjectCategory.findById", query = "SELECT p FROM ProjectCategory p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectCategory.findByTitleEn", query = "SELECT p FROM ProjectCategory p WHERE p.titleEn = :titleEn"),
    @NamedQuery(name = "ProjectCategory.findByTitleFa", query = "SELECT p FROM ProjectCategory p WHERE p.titleFa = :titleFa"),
    @NamedQuery(name = "ProjectCategory.findByDescribtionEn", query = "SELECT p FROM ProjectCategory p WHERE p.describtionEn = :describtionEn"),
    @NamedQuery(name = "ProjectCategory.findByDescribtionFa", query = "SELECT p FROM ProjectCategory p WHERE p.describtionFa = :describtionFa"),
    @NamedQuery(name = "ProjectCategory.findByCreatedAt", query = "SELECT p FROM ProjectCategory p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProjectCategory.findByUpdatedAt", query = "SELECT p FROM ProjectCategory p WHERE p.updatedAt = :updatedAt")})
public class ProjectCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "title_en")
    private String titleEn;
    @Size(max = 300)
    @Column(name = "title_fa")
    private String titleFa;
    @Size(max = 3000)
    @Column(name = "describtion_en")
    private String describtionEn;
    @Size(max = 3000)
    @Column(name = "describtion_fa")
    private String describtionFa;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "ctgId")
    private Collection<Project> projectCollection;

    public ProjectCategory() {
    }

    public ProjectCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleFa() {
        return titleFa;
    }

    public void setTitleFa(String titleFa) {
        this.titleFa = titleFa;
    }

    public String getDescribtionEn() {
        return describtionEn;
    }

    public void setDescribtionEn(String describtionEn) {
        this.describtionEn = describtionEn;
    }

    public String getDescribtionFa() {
        return describtionFa;
    }

    public void setDescribtionFa(String describtionFa) {
        this.describtionFa = describtionFa;
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

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
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
        if (!(object instanceof ProjectCategory)) {
            return false;
        }
        ProjectCategory other = (ProjectCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProjectCategory[ id=" + id + " ]";
    }
    
}
