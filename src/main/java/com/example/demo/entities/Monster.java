package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "monster")
public class Monster {
    /*РАЗОБРАТЬСЯ*/
    //почему-то Id генерируется последовательно с Id аккаунта
    //т.е. добавляем аккаунт в БД - id=1, а у монстра, привязанного к нему id=2
    //добавляем второй аккаунт - id=3, у монстра id=4
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long monster_id;
    @Column(name = "maxhp")
    private int maxHp=100;
    @Column(name = "gold")
    private long gold=5;
    //Монстру не нужен контроллер, т.к. он привязан непосредственно к аккаунту
    //т.е. никаких действий отдельно проводить не требуется

    public Monster() {
    }

    public long getId() {
        return monster_id;
    }


    public int getMaxHp() {
        return maxHp;
    }

    public long getGold() {
        return gold;
    }
}
