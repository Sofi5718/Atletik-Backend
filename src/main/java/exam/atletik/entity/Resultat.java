package exam.atletik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultat {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private LocalDateTime dato;
    private double resultat;

    @ManyToOne
    @JsonBackReference
    private Deltager deltager;
    @ManyToOne
    @JsonBackReference
    private Disciplin disciplin;

}
