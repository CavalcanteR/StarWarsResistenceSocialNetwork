package com.ricardocavalcante.cadastro.repository;

import com.ricardocavalcante.cadastro.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensRepository extends JpaRepository<Item, Long> {

}
