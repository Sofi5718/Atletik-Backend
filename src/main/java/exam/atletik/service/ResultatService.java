package exam.atletik.service;

import exam.atletik.dto.ResultatDto;
import exam.atletik.entity.Resultat;
import exam.atletik.repository.ResultatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultatService {
    private final ResultatRepository resultatRepository;

    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }


    public Resultat save(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

    public Resultat update(int id, Resultat resultat) {
        if (resultatRepository.existsById(id)) {
            resultat.setId(id);
            return resultatRepository.save(resultat);
        }
        return null;
    }

    public void deleteById(int id) {
        resultatRepository.deleteById(id);
    }

    public List<ResultatDto> getAllResultater() {
      List<Resultat>allResultater = resultatRepository.findAll();
        return convertToResultat(allResultater);

    }
    private List<ResultatDto> convertToResultat(List<Resultat> resultater){
        return resultater.stream()
                .map(resultat -> {
                    ResultatDto resultatDto = new ResultatDto();
                    resultatDto.setId(resultat.getId());
                    resultatDto.setDeltagerId(resultat.getDeltager().getId());
                    resultatDto.setDisciplinId(resultat.getDisciplin().getId());
                    resultatDto.setDato(resultat.getDato());

                    resultatDto.setResultat(resultat.getResultat());
                    return resultatDto;
                })
                .collect(Collectors.toList());
    }
}
