package exam.atletik.repository;

import exam.atletik.entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultatRepository extends JpaRepository<Resultat, Integer> {
}
