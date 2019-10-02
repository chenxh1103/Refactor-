package org.chenxh.game.soldier;

public enum Corps {
    Archaer(1,0.8),
    Infantry(1.2,1);

    private double archer;//对弓兵的克制
    private double infantry;//对步兵的克制
    Corps(double archer, double infantry) {
        this.archer = archer;
        this.infantry = infantry;
    }

    public double getArcher() {
        return archer;
    }

    public double getInfantry() {
        return infantry;
    }

    public double getPoint(Corps corps){
        Object result = 1;
        try {
            result = this.getClass().getMethod("get"+corps.name()).invoke(this);
        }catch (Exception e){

        }
        return Double.parseDouble((result.toString()));
    }
}
