package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nickname", unique = true)
    private String nickname;
    @Column(name = "password")
    private String password;

    //следующее, возможно, следует занести в отдельный класс - Player, после чего связать его с аккаунтом
    @Column(name= "gold")
    private long gold;
    @Column(name = "damage")
    private int damage = 10;
    @Column(name = "lvl")
    private int lvl=1;
    @Column(name = "damageUpgradePrice")
    private int damageUpgradePrice = 20;
    //тут содержатся данные о монстре, привязанного к аккаунту: HP, Золото, возможно, что-либо ещё
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monster")
    private Monster monster;
    /* *********************** */

    public Account() {
        this.monster = new Monster();
    }

    public Account(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getGold() {
        return gold;
    }

    public int getDamage() {
        return damage;
    }

    public int getLvl() {
        return lvl;
    }

    public int getDamageUpgradePrice() {
        return damageUpgradePrice;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setDamageUpgradePrice(int damageUpgradePrice) {
        this.damageUpgradePrice = damageUpgradePrice;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setData(Account acc){
        setLvl(acc.getLvl());
        setGold(acc.getGold());
        setDamageUpgradePrice(acc.getDamageUpgradePrice());
        setDamage(acc.getDamage());
        setMonster(acc.getMonster());
    }
}