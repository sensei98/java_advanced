package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="stock_Seq", initialValue = 100_000)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(generator = "stock_seq")
    private Long id;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "guitar_id")
    private Guitar guitar;

    public Stock(Guitar guitar, int quantity) {
        this.guitar = guitar;
        this.quantity = quantity;
    }
}
