package exam.atletik.repository;

import exam.atletik.entity.Disciplin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinRepository extends JpaRepository<Disciplin, Integer> {
}
