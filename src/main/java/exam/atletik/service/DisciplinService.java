package exam.atletik.service;

import exam.atletik.dto.DisciplinDto;
import exam.atletik.entity.Disciplin;
import exam.atletik.repository.DisciplinRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisciplinService {

    private final DisciplinRepository disciplinRepository;

    public DisciplinService(DisciplinRepository disciplinRepository) {
        this.disciplinRepository = disciplinRepository;
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

    public void deleteById(int id) {
        disciplinRepository.deleteById(id);
    }
}
