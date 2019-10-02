package org.chenxh.game.soldier;

/**
 * @Description 士兵
 * @Author chenxh
 * @date 2019/7/1
 */
public abstract class Soldier {
    protected int hp;
    protected int atk;
    protected Corps corps;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public Corps getCorps() {
        return corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }

    public void attack(Soldier soldier){
        int atk = (int)this.getCorps().getPoint(soldier.getCorps()) * getAtk();
        soldier.setHp(soldier.getHp()-atk);
    }
}
