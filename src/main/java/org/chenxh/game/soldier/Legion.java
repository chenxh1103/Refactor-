package org.chenxh.game.soldier;

import java.util.List;

/**
 * @Description 军团，由军队组成
 * @Author chenxh
 * @date 2019/7/1
 */
public class Legion {
    private List<Forces> forces;

    public Legion(List<Forces> forces) {
        this.forces = forces;
    }

    public List<Forces> getForces() {
        return forces;
    }

    public void setForces(List<Forces> forces) {
        this.forces = forces;
    }

    public void attack(Legion legion){
        this.getForces().get(0).getSoldier();
    }
}
