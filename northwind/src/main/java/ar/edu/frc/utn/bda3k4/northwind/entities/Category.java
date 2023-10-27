package ar.edu.frc.utn.bda3k4.northwind.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @Column(name = "CategoryID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Categories")
    @TableGenerator(name = "Categories", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Categories",
            initialValue=1, allocationSize=1)
    Integer id;

    @Column(name = "CategoryName")
    String name;

    @Column(name = "Description")
    String description;

    @Column(name = "Picture")
    byte[] picture;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

    public void update(Category entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.picture = entity.getPicture();
    }
}
