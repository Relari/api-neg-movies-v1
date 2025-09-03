package pe.com.relari.dao.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "movies")
public class MovieEntity extends PanacheEntity {

    private String title;
    private Integer releaseYear;
    private String director;

}
