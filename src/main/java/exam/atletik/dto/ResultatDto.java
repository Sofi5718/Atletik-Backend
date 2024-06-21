package exam.atletik.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultatDto {
    private DeltagerDto deltager;
    private DisciplinDto disciplin;
    private String resultat;
    private String enhed;
    private String dato;

}
