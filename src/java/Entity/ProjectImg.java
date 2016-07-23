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
@Table(name = "project_img")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectImg.findAll", query = "SELECT p FROM ProjectImg p"),
    @NamedQuery(name = "ProjectImg.findById", query = "SELECT p FROM ProjectImg p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectImg.findByAlt", query = "SELECT p FROM ProjectImg p WHERE p.alt = :alt"),
    @NamedQuery(name = "ProjectImg.findByImg", query = "SELECT p FROM ProjectImg p WHERE p.img = :img"),
    @NamedQuery(name = "ProjectImg.findByCraetedAt", query = "SELECT p FROM ProjectImg p WHERE p.craetedAt = :craetedAt"),
    @NamedQuery(name = "ProjectImg.findByUpdatedAt", query = "SELECT p FROM ProjectImg p WHERE p.updatedAt = :updatedAt")})
public class ProjectImg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "alt")
    private String alt;
    @Size(max = 500)
    @Column(name = "img")
    private String img;
    @Column(name = "craeted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date craetedAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne
    private Project projectId;

    public ProjectImg() {
    }

    public ProjectImg(Integer id) {
        this.id = id;
    }

    public ProjectImg(Integer id, String alt) {
        this.id = id;
        this.alt = alt;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
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
        if (!(object instanceof ProjectImg)) {
            return false;
        }
        ProjectImg other = (ProjectImg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProjectImg[ id=" + id + " ]";
    }
    
}
