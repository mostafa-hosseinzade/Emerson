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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "diagram_section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagramSection.findAll", query = "SELECT d FROM DiagramSection d"),
    @NamedQuery(name = "DiagramSection.findById", query = "SELECT d FROM DiagramSection d WHERE d.id = :id"),
    @NamedQuery(name = "DiagramSection.findByTitleFa", query = "SELECT d FROM DiagramSection d WHERE d.titleFa = :titleFa"),
    @NamedQuery(name = "DiagramSection.findByTitleEn", query = "SELECT d FROM DiagramSection d WHERE d.titleEn = :titleEn"),
    @NamedQuery(name = "DiagramSection.findByDescribtionFa", query = "SELECT d FROM DiagramSection d WHERE d.describtionFa = :describtionFa"),
    @NamedQuery(name = "DiagramSection.findByDescribtionEn", query = "SELECT d FROM DiagramSection d WHERE d.describtionEn = :describtionEn"),
    @NamedQuery(name = "DiagramSection.findByCreatedAt", query = "SELECT d FROM DiagramSection d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DiagramSection.findAllByOrder", query = "SELECT d FROM DiagramSection d order by d.order asc"),
    @NamedQuery(name = "DiagramSection.findByUpdatedAt", query = "SELECT d FROM DiagramSection d WHERE d.updatedAt = :updatedAt")})
public class DiagramSection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "title_fa")
    private String titleFa;
    @Size(max = 300)
    @Column(name = "title_en")
    private String titleEn;
    @Size(max = 4000)
    @Column(name = "describtion_fa")
    private String describtionFa;
    @Size(max = 4000)
    @Column(name = "describtion_en")
    private String describtionEn;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "parent")
    private Collection<DiagramSection> diagramSectionCollection;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne
    private DiagramSection parent;
    @OneToMany(mappedBy = "diagramSectionId")
    private Collection<DiagramPerson> diagramPersonCollection;
    @Column(name = "`order`")
    private Integer order;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public DiagramSection() {
    }

    public DiagramSection(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleFa() {
        return titleFa;
    }

    public void setTitleFa(String titleFa) {
        this.titleFa = titleFa;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getDescribtionFa() {
        return describtionFa;
    }

    public void setDescribtionFa(String describtionFa) {
        this.describtionFa = describtionFa;
    }

    public String getDescribtionEn() {
        return describtionEn;
    }

    public void setDescribtionEn(String describtionEn) {
        this.describtionEn = describtionEn;
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
    public Collection<DiagramSection> getDiagramSectionCollection() {
        return diagramSectionCollection;
    }

    public void setDiagramSectionCollection(Collection<DiagramSection> diagramSectionCollection) {
        this.diagramSectionCollection = diagramSectionCollection;
    }

    public DiagramSection getParent() {
        return parent;
    }

    public void setParent(DiagramSection parent) {
        this.parent = parent;
    }

    @XmlTransient
    public Collection<DiagramPerson> getDiagramPersonCollection() {
        return diagramPersonCollection;
    }

    public void setDiagramPersonCollection(Collection<DiagramPerson> diagramPersonCollection) {
        this.diagramPersonCollection = diagramPersonCollection;
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
        if (!(object instanceof DiagramSection)) {
            return false;
        }
        DiagramSection other = (DiagramSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.titleEn;
    }
    @PrePersist
    private void PrePersist(){
        this.createdAt = new Date();
    }
    @PreUpdate
    private void PreUpdate(){
        this.updatedAt = new Date();
    }
}
