package exam.atletik.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResultatDto {
    private int id;
    private int deltagerId;
    private int disciplinId;
    private double resultat;
    private LocalDateTime dato;

}
