package br.com.rpgmarket.repository;

import br.com.rpgmarket.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameContainingIgnoreCase(String name);
    List<Item> findByTypeIgnoreCase(String type);
    List<Item> findByRarityIgnoreCase(String raridade);
    List<Item> findByPriceBetween(int min, int max);
}