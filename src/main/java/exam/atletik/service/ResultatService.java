package exam.atletik.service;

import exam.atletik.repository.ResultatRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultatService {
    private final ResultatRepository resultatRepository;

    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }


}
