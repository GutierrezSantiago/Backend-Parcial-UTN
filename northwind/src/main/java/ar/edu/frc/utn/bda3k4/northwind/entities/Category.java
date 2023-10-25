package ar.edu.frc.utn.bda3k4.northwind.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @Column(name = "CategoryID")
    Integer id;

    @Column(name = "CategoryName")
    String name;

    @Column(name = "Description")
    String description;

    @Column(name = "Picture")
    Byte[] picture;
}
