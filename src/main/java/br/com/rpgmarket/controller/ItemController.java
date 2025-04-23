package br.com.rpgmarket.controller;

import br.com.rpgmarket.model.Item;
import br.com.rpgmarket.model.Character;
import br.com.rpgmarket.repository.ItemRepository;
import br.com.rpgmarket.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping
    public Item create(@RequestBody Item item, @RequestParam Long characterId) {
        Character c = characterRepository.findById(characterId).orElseThrow();
        item.setOwner(c);
        return itemRepo.save(item);
    }

    @GetMapping
    public List<Item> listAll() {
        return itemRepo.findAll();
    }

    @GetMapping("/by-name")
    public List<Item> findByName(@RequestParam String name) {
        return itemRepo.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/by-type")
    public List<Item> findByType(@RequestParam String type) {
        return itemRepo.findByTypeIgnoreCase(type);
    }

    @GetMapping("/by-rarity")
    public List<Item> findByRarity(@RequestParam String rarity) {
        return itemRepo.findByRarityIgnoreCase(rarity);
    }

    @GetMapping("/by-price")
    public List<Item> findByPrice(@RequestParam int min, @RequestParam int max) {
        return itemRepo.findByPriceBetween(min, max);
    }

}
