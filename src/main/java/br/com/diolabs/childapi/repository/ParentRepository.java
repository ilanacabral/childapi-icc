package br.com.diolabs.childapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.diolabs.childapi.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>{

    @Query("SELECT p FROM Parent p WHERE p.cpf = :cpf")
    Optional<Parent> findByCPF(@Param("cpf") String cpf);
    
}
