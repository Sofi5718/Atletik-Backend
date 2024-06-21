package exam.atletik.api;

import exam.atletik.dto.DisciplinDto;
import exam.atletik.entity.Disciplin;
import exam.atletik.service.DisciplinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipliner")
public class DisciplinController {
    private final DisciplinService disciplinService;

    public DisciplinController(DisciplinService disciplinService) {
        this.disciplinService = disciplinService;
    }

    @GetMapping
    public List<Disciplin> getAllDiscipliner() {
        return disciplinService.getAllDiscipliner();
    }

    @PostMapping
    public Disciplin createDisciplin(DisciplinDto disciplinDto) {
        return disciplinService.save(disciplinDto);
    }

    @PutMapping("/{id}")
    public Disciplin updateDisciplin(@PathVariable int id, @RequestBody DisciplinDto disciplinDto) {
        return disciplinService.update(id, disciplinDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplin(@PathVariable int id) {
        disciplinService.deleteById(id);
    }
}
