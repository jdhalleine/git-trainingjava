package com.company.patternstrategy;

public class Civil extends Personnage{
    public Civil() {}

    public Civil(EspritCombatif esprit, Soin soin, Deplacement dep) {
        super(esprit, soin, dep);
    }
}
