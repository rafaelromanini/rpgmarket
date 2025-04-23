package br.com.rpgmarket.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personagens")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String characterClass;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private int coins;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Item> itens;

    public Character() {}

    public Character(Long id, String name, String characterClass, int level, int coins, List<Item> itens) {
        this.id = id;
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.coins = coins;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}