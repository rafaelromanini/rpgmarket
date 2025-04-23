package br.com.rpgmarket.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String rarity;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Character owner;

    public Item() {}

    public Item(String name, String type, String rarity, int price, Character owner) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.price = price;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public Character getOwner() { return owner; }
    public void setOwner(Character owner) { this.owner = owner; }
}