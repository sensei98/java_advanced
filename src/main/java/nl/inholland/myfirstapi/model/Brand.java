package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Brand {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "brand")
    private Set<Guitar> guitars = new HashSet<>();

    public Brand(String name) {
        this.name = name;
    }
}
