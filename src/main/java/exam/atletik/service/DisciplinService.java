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

}
