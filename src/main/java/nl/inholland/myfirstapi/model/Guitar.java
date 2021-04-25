package nl.inholland.myfirstapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //newly added
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Guitar {

    @Id //newly added
    @GeneratedValue //item added
    private long id;
    private String brand;
    private String model;
    private Double price;

//    public Guitar(){} //either this or line 9

    public Guitar(String brand, String model, Double price) {

        this.brand = brand;
        this.model = model;
        this.price = price;
    }

//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }

//    @Override
//    public String toString() {
//        return "Guitar{" +
//                "id=" + id +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
