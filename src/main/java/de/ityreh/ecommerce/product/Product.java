package de.ityreh.ecommerce.product;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Product extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Size(max = 100, min = 2)
    @Column(length = 100, nullable = false, unique = true)
    public String name;

    @Column(nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    public static Product findById(UUID id) {
        return find("id", id).firstResult();
    }

    public static Product findByName(String name){
        return find("name", name).firstResult();
    }

    public static Boolean exists(Product entity) {
        return find("title = ?1", entity.name).count() > 0 ? true : false;
    }

    public static Boolean exists(Product entity, UUID id) {
        return find("title = ?1 AND id <> ?2", entity.name, id).count() > 0 ? true : false;
    }
}
