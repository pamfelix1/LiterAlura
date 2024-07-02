package com.alura.LiterAlura.Repository;

import com.alura.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnoNascimento(int ano);
    List<Autor> findByAnoFalecimentoIsNullOrAnoFalecimentoGreaterThanEqual(int ano);


}


