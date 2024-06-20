package exam.atletik.repository;

import exam.atletik.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepository extends JpaRepository<Deltager, Integer> {
}
