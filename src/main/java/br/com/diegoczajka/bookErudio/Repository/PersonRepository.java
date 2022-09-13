package br.com.diegoczajka.bookErudio.Repository;

import br.com.diegoczajka.bookErudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
