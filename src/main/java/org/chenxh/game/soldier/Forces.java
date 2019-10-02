package org.chenxh.game.soldier;

import java.util.List;

/**
 * @Description 军队
 * @Author chenxh
 * @date 2019/7/1
 */
public class Forces {
    private Soldier soldier;
    private int number;

    public Forces(Soldier soldier, int number) {
        this.soldier = soldier;
        this.number = number;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void attack(Forces forces){
        for (int i = 0;i<getNumber();i++){
            getSoldier().attack(forces.getSoldier());
        }
    }
}
