package exam.atletik.service;

import exam.atletik.dto.DeltagerDto;
import exam.atletik.entity.Deltager;
import exam.atletik.repository.DeltagerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeltagerService {
    private final DeltagerRepository deltagerRepository;

    public DeltagerService(DeltagerRepository deltagerRepository) {
        this.deltagerRepository = deltagerRepository;
    }

    public List<Deltager> findAll() {
        return deltagerRepository.findAll();
    }

    public Deltager findById(int id) {
        return deltagerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deltager blev ikke fundet"));
    }

public Deltager save(DeltagerDto deltagerDto) {
        Deltager deltager = new Deltager();
        deltager.setNavn(deltagerDto.getNavn());
        deltager.setAlder(deltagerDto.getAlder());
        deltager.setKøn(deltagerDto.getKøn());
        deltager.setKlub(deltagerDto.getKlub());
        return deltagerRepository.save(deltager);
    }

    public void deleteById(int id) {
        deltagerRepository.deleteById(id);
    }

    public Deltager update(int id, DeltagerDto deltager) {
        Deltager entity = deltagerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deltager blev ikke fundet"));
        entity.setNavn(deltager.getNavn());
        entity.setAlder(deltager.getAlder());
        entity.setKøn(deltager.getKøn());
        entity.setKlub(deltager.getKlub());
        return deltagerRepository.save(entity);
    }

}
