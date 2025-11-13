package org.example.projsoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.projsoft.Entite.Footballer;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
}
