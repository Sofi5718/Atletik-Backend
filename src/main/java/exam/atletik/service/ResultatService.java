package exam.atletik.service;

import exam.atletik.entity.Resultat;
import exam.atletik.repository.ResultatRepository;
import org.springframework.stereotype.Service;

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
}
