package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Entite.Footballer;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
}
