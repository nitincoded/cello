package com.katkam.cello.entity;

import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
@Table
public class Part {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(unique = true, nullable = false)
    private String code;
    
    @Column
    private String description;
    
    public Part() {}
    public Part(String a_code, String a_description) { code = a_code; description = a_description; }
    public Part(int a_id, String a_code, String a_description) { id = a_id; code = a_code; description = a_description; }
    
    @ManyToOne
    @JoinColumn(name = "uom_id")
    private Uom uom;
    
    @Override
    public String toString() {
        return String.format("%d - %s - %s - %s", id, code, description, uom.getCode());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }
    
    
}
