package com.ricardocavalcante.cadastro.repository;

import com.ricardocavalcante.cadastro.model.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, Long> {

}
