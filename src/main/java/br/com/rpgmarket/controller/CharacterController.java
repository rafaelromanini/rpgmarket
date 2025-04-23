package br.com.rpgmarket.controller;

import br.com.rpgmarket.model.Character;
import br.com.rpgmarket.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping
    public Character create(@RequestBody Character c) {
        if (c.getLevel() < 1 || c.getLevel() > 99) {
            throw new IllegalArgumentException("The level should between 1 and 99 ");
        }
        return characterRepository.save(c);
    }

    @GetMapping
    public List<Character> listAll() {
        return characterRepository.findAll();
    }

    @GetMapping("/by-name")
    public List<Character> findByName(@RequestParam String name) {
        return characterRepository.findByNameIgnoreCase(name);
    }

    @GetMapping("/by-class")
    public List<Character> findByCharacterClass(@RequestParam String characterClass) {
        return characterRepository.findBycharacterClassIgnoreCase(characterClass);
    }

    @PutMapping("/{id}")
    public Character update(@PathVariable Long id, @RequestBody Character update) {
        Character c = characterRepository.findById(id).orElseThrow();
        c.setName(update.getName());
        c.setCharacterClass(update.getCharacterClass());
        c.setLevel(update.getLevel());
        c.setCoins(update.getCoins());
        return characterRepository.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }
}