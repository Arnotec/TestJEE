package org.arnotec.gestprodback.dao;

import org.arnotec.gestprodback.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
