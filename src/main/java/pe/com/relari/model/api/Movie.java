package pe.com.relari.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Integer id;
    private String title;
    private Integer year;
    private String director;

}