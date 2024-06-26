package exam.atletik.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deltager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private int alder;
    private String køn;
    private String klub;


    @ManyToMany
    @JsonManagedReference
    private List<Disciplin> discipliner = new ArrayList<>();

    // tilføjet cascade = CascadeType.REMOVE for at sikre den fjerner resultater fra deltager der bliver slettet.
    @OneToMany(mappedBy = "deltager", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Resultat> resultater = new ArrayList<>();
}
