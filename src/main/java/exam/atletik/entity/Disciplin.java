package exam.atletik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Disciplin {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private String navn;
    private String resultatType;

    @ManyToMany(mappedBy = "discipliner")
    @JsonBackReference
    private List<Deltager> deltagere = new ArrayList<>();
// tilføjet cascade = CascadeType.REMOVE for at sikre den fjerner resultater fra disciplin der bliver slettet.
    @OneToMany(mappedBy = "disciplin", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<Resultat> resultater = new ArrayList<>();

}
