package com.katkam.cello.entity;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author User
 */
@Entity
@Table
public class Uom {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(unique = true, nullable = false)
    private String code;
    
    @Column
    private String description;
    
    public Uom() {}
    public Uom(String a_code, String a_description) { code = a_code; description = a_description; }
    public Uom(int a_id, String a_code, String a_description) { id = a_id; code = a_code; description = a_description; }
    
    @OneToMany(mappedBy = "uom")
    private List<Part> parts;
    
    @Override
    public String toString() {
        return String.format("%d - %s - %s", id, code, description);
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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
    
    
}
