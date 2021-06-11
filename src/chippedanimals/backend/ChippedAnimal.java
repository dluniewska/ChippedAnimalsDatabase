/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chippedanimals.backend;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lunie
 */
@Entity
@Table(name = "ChippedAnimal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChippedAnimal.findAll", query = "SELECT c FROM ChippedAnimal c"),
    @NamedQuery(name = "ChippedAnimal.findById", query = "SELECT c FROM ChippedAnimal c WHERE c.id = :id"),
    @NamedQuery(name = "ChippedAnimal.findByName", query = "SELECT c FROM ChippedAnimal c WHERE c.name = :name"),
    @NamedQuery(name = "ChippedAnimal.findByKind", query = "SELECT c FROM ChippedAnimal c WHERE c.kind = :kind"),
    @NamedQuery(name = "ChippedAnimal.findByChip", query = "SELECT c FROM ChippedAnimal c WHERE c.chip = :chip"),
    @NamedQuery(name = "ChippedAnimal.findByPhone", query = "SELECT c FROM ChippedAnimal c WHERE c.phone = :phone"),
    @NamedQuery(name = "ChippedAnimal.findByEmail", query = "SELECT c FROM ChippedAnimal c WHERE c.email = :email")})
public class ChippedAnimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Kind")
    private String kind;
    @Column(name = "Chip")
    private Integer chip;
    @Column(name = "Phone")
    private Integer phone;
    @Column(name = "Email")
    private String email;

    public ChippedAnimal() {
    }

    public ChippedAnimal(String name, String kind, Integer chip, Integer phone, String email) {
        this.name = name;
        this.kind = kind;
        this.chip = chip;
        this.phone = phone;
        this.email = email;
    }

    public ChippedAnimal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getChip() {
        return chip;
    }

    public void setChip(Integer chip) {
        this.chip = chip;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof ChippedAnimal)) {
            return false;
        }
        ChippedAnimal other = (ChippedAnimal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal: " + id + " "
                +this.name + " "
                +this.kind + " "
                +this.chip + " "
                +this.phone + " "
                +this.email;
    }
    
}
