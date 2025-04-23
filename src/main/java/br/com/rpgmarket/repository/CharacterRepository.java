package br.com.rpgmarket.repository;

import br.com.rpgmarket.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameIgnoreCase(String name);
    List<Character> findBycharacterClassIgnoreCase(String characterClass);
}