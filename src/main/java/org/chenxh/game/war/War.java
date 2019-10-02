package org.chenxh.game.war;

import org.chenxh.game.soldier.Forces;
import org.chenxh.game.soldier.Legion;

import java.util.List;

/**
 * @Description 战斗地图
 * @Author chenxh
 * @date 2019/7/1
 */
public class War {
    private Legion redLegion;
    private Legion blueLegion;

    public War(Legion redLegion, Legion blueLegion) {
        this.redLegion = redLegion;
        this.blueLegion = blueLegion;
    }

    public Legion getRedLegion() {
        return redLegion;
    }

    public void setRedLegion(Legion redLegion) {
        this.redLegion = redLegion;
    }

    public Legion getBlueLegion() {
        return blueLegion;
    }

    public void setBlueLegion(Legion blueLegion) {
        this.blueLegion = blueLegion;
    }

    public void startWar(){
        do {
            this.getBlueLegion().attack(this.getRedLegion());
            this.getRedLegion().attack(this.getBlueLegion());
        }while (true);
    }
}
