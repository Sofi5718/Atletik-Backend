package exam.atletik.api;

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
    public Disciplin createDisciplin(Disciplin disciplin) {
        return disciplinService.save(disciplin);
    }

    @PutMapping("/{id}")
    public Disciplin updateDisciplin(@PathVariable int id, @RequestBody Disciplin disciplin) {
        return disciplinService.update(id, disciplin);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplin(@PathVariable int id) {
        disciplinService.deleteById(id);
    }
}
