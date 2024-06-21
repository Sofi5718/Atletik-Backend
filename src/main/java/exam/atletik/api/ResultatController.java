package exam.atletik.api;

import exam.atletik.entity.Disciplin;
import exam.atletik.entity.Resultat;
import exam.atletik.service.ResultatService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultater")
public class ResultatController {

    private final ResultatService resultatService;

    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @GetMapping
    public List<Resultat> getAllResultater() {
        return resultatService.getAllResultater();
    }

    @PostMapping
    public Resultat createResultat(@RequestBody Resultat resultat) {
        return resultatService.save(resultat);
    }

    @PutMapping("/{id}")
    public Resultat updateResultat(@PathVariable int id, @RequestBody Resultat resultat) {
        return resultatService.update(id, resultat);
    }

    @DeleteMapping("/{id}")
    public void deleteResultat(@PathVariable int id) {
        resultatService.deleteById(id);
    }




}
