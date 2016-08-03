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
@Table(name = "diagram_person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagramPerson.findAll", query = "SELECT d FROM DiagramPerson d"),
    @NamedQuery(name = "DiagramPerson.findById", query = "SELECT d FROM DiagramPerson d WHERE d.id = :id"),
    @NamedQuery(name = "DiagramPerson.findByTitleEn", query = "SELECT d FROM DiagramPerson d WHERE d.titleEn = :titleEn"),
    @NamedQuery(name = "DiagramPerson.findByTitleFa", query = "SELECT d FROM DiagramPerson d WHERE d.titleFa = :titleFa"),
    @NamedQuery(name = "DiagramPerson.findByDescribtionFa", query = "SELECT d FROM DiagramPerson d WHERE d.describtionFa = :describtionFa"),
    @NamedQuery(name = "DiagramPerson.findByDescribtionEn", query = "SELECT d FROM DiagramPerson d WHERE d.describtionEn = :describtionEn"),
    @NamedQuery(name = "DiagramPerson.findByPhone", query = "SELECT d FROM DiagramPerson d WHERE d.phone = :phone"),
    @NamedQuery(name = "DiagramPerson.findByEmail", query = "SELECT d FROM DiagramPerson d WHERE d.email = :email"),
    @NamedQuery(name = "DiagramPerson.findByImg", query = "SELECT d FROM DiagramPerson d WHERE d.img = :img"),
    @NamedQuery(name = "DiagramPerson.findByWorkEn", query = "SELECT d FROM DiagramPerson d WHERE d.workEn = :workEn"),
    @NamedQuery(name = "DiagramPerson.findByWorkFa", query = "SELECT d FROM DiagramPerson d WHERE d.workFa = :workFa"),
    @NamedQuery(name = "DiagramPerson.findByCreatedAt", query = "SELECT d FROM DiagramPerson d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DiagramPerson.findByUpdatedAt", query = "SELECT d FROM DiagramPerson d WHERE d.updatedAt = :updatedAt")})
public class DiagramPerson implements Serializable {

    public String getWorkEn() {
        return workEn;
    }

    public void setWorkEn(String workEn) {
        this.workEn = workEn;
    }

    public String getWorkFa() {
        return workFa;
    }

    public void setWorkFa(String workFa) {
        this.workFa = workFa;
    }

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
    @Size(max = 4000)
    @Column(name = "describtion_fa")
    private String describtionFa;
    @Size(max = 4000)
    @Column(name = "describtion_en")
    private String describtionEn;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 300)
    @Column(name = "email")
    private String email;
    @Size(max = 400)
    @Column(name = "img")
    private String img;
    @Size(max = 255)
    @Column(name = "work_en")
    private String workEn;
    @Size(max = 255)
    @Column(name = "work_fa")
    private String workFa;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "diagram_section_id", referencedColumnName = "id")
    @ManyToOne
    private DiagramSection diagramSectionId;

    public DiagramPerson() {
    }

    public DiagramPerson(Integer id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public DiagramSection getDiagramSectionId() {
        return diagramSectionId;
    }

    public void setDiagramSectionId(DiagramSection diagramSectionId) {
        this.diagramSectionId = diagramSectionId;
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
        if (!(object instanceof DiagramPerson)) {
            return false;
        }
        DiagramPerson other = (DiagramPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DiagramPerson[ id=" + id + " ]";
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
