package br.gov.sp.fatec.springboot3app2025.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.springboot3app2025.entity.Fonte;

public interface FonteRepository extends JpaRepository<Fonte, Long>{

    @Query("SELECT f FROM Fonte f WHERE f.potenciaReal > :potencia AND f.dataLancamento < :data")
    List<Fonte> buscarPorPotenciaEData(@Param("potencia") Integer potencia, @Param("data") LocalDate data);

}
