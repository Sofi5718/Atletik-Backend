package exam.atletik.api;

import exam.atletik.dto.DeltagerDto;
import exam.atletik.entity.Deltager;
import exam.atletik.service.DeltagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deltagere")
public class DeltagerController {

    private final DeltagerService deltagerService;

    public DeltagerController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }

    @GetMapping
    public List<Deltager> getAllDeltagere() {
        return deltagerService.findAll();
    }

    @GetMapping("/{id}")
    public Deltager getDeltager(int id) {
        return deltagerService.findById(id);
    }

    @PostMapping
    public Deltager createDeltager(@RequestBody DeltagerDto deltagerDto) {
        return deltagerService.save(deltagerDto);
    }

    @PutMapping("/{id}")
    public Deltager updateDeltager(@PathVariable int id, @RequestBody DeltagerDto deltagerDto) {
        return deltagerService.update(id, deltagerDto);
    }
    @DeleteMapping("/{id}")
    public void deleteDeltager(@PathVariable int id) {
        deltagerService.deleteById(id);
    }

}
