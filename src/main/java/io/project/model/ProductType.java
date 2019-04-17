package io.project.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "product_types")
public class ProductType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @QuerySqlField(index = true)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @QuerySqlField(index = true)
    private String name;

    @Column(name = "description")
    @QuerySqlField(index = true)
    private String description;

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
}
