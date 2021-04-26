package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity //newly added
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Guitar {

    @Id //newly added
    @GeneratedValue //item added
    private long id;
    @ManyToOne
    @JsonBackReference
    private Brand brand;
    private String model;
    private Double price;


//    public Guitar(){} //either this or line 9

    public Guitar(Brand brand, String model, Double price) {

        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
