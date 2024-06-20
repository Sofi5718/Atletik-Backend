package exam.atletik.service;

import exam.atletik.entity.Disciplin;
import exam.atletik.repository.DisciplinRepository;
import org.springframework.stereotype.Service;

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

    public Disciplin save(Disciplin disciplin) {
        return disciplinRepository.save(disciplin);
    }

    public Disciplin update(int id, Disciplin disciplin) {
        if (disciplinRepository.existsById(id)) {
            disciplin.setId(id);
            return disciplinRepository.save(disciplin);
        }
        return null;
    }

    public void deleteById(int id) {
        disciplinRepository.deleteById(id);
    }
}
