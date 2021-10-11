package com.datatables.demo.beans;


import org.joda.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "datatables")
@SequenceGenerator(name = "datatables_seq", initialValue = 20000, allocationSize = 50)
public class Datatables {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "datatables_seq")
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdStamp;
    private LocalDateTime updatedStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(LocalDateTime createdStamp) {
        this.createdStamp = createdStamp;
    }

    public LocalDateTime getUpdatedStamp() {
        return updatedStamp;
    }

    public void setUpdatedStamp(LocalDateTime updatedStamp) {
        this.updatedStamp = updatedStamp;
    }
}
