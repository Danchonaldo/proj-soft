package org.example.projsoft.Repository;

import org.example.projsoft.Entite.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
