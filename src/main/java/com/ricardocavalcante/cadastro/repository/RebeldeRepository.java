package com.ricardocavalcante.cadastro.repository;

import com.ricardocavalcante.cadastro.model.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RebeldeRepository extends JpaRepository<Rebelde, Long> {

    //@Query("SELECT R.* FROM rebelde AS R INNER JOIN denuncias AS D ON D.traidor = R.id GROUP BY R.id WHERE COUNT(D.traidor) >= 3 ")
    //List<Rebelde> findAllTraidores();

}
