package org.arnotec.gestprodback.dao;

import org.arnotec.gestprodback.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @Query("select p from Produit p where p.designation like :x")
    public List<Produit> findByMotCle(@Param("x") String mc);
}
