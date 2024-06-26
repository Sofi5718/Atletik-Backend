package exam.atletik.service;

import exam.atletik.dto.DisciplinDto;
import exam.atletik.entity.Deltager;
import exam.atletik.entity.Disciplin;
import exam.atletik.repository.DeltagerRepository;
import exam.atletik.repository.DisciplinRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisciplinService {

    private final DisciplinRepository disciplinRepository;
    private final DeltagerRepository deltagerRepository;

    public DisciplinService(DisciplinRepository disciplinRepository, DeltagerRepository deltagerRepository) {
        this.disciplinRepository = disciplinRepository;
        this.deltagerRepository = deltagerRepository;
    }

    public List<Disciplin> getAllDiscipliner() {
        return disciplinRepository.findAll();
    }

    public Disciplin save(DisciplinDto disciplinDto) {
        Disciplin disciplin = new Disciplin();
        disciplin.setNavn(disciplinDto.getNavn());
        disciplin.setResultatType(disciplinDto.getResultatType());
        return disciplinRepository.save(disciplin);
    }

    public Disciplin update(int id, DisciplinDto disciplinDto) {
       Disciplin entity = disciplinRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplin blev ikke fundet"));
    entity.setNavn(disciplinDto.getNavn());
    entity.setResultatType(disciplinDto.getResultatType());
    return disciplinRepository.save(entity);

    }

    public void deleteDisciplin(int disciplinId) {
        Disciplin disciplin = disciplinRepository.findById(disciplinId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplin blev ikke fundet"));

        // Remove the association between the Deltager and the Disciplin
        for (Deltager deltager : disciplin.getDeltagere()) {
            deltager.getDiscipliner().remove(disciplin);
            deltagerRepository.save(deltager);  // Save the Deltager with the updated discipliner list
        }

        // Remove the association between the Disciplin and the Deltager
        disciplin.getDeltagere().clear();
        disciplinRepository.save(disciplin);  // Save the Disciplin with the updated deltagere list

        // Now you can delete the Disciplin
        disciplinRepository.delete(disciplin);
    }
}
