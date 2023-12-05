import java.util.List;
public interface Character {
    String getName();
    int getLevel();
    void updateLevel();
    int getCurrentExp();
    int getMaxExp();
    int getMaxHp();
    int getMaxMana();
    int getCurrentMana();
    void setCurrentExp(int exp);
    String getJob();
    void displayStats();
    void setBuffSPD(double spd);
    void setBuffAtk(double atk);
    void setBuffDef(double def);
    void setBuffMana(double mana);
    void updateStatus();
    void setBootEquip(boolean boot);
    boolean getBootEquip();
    void setRingEquip(boolean ring);
    boolean getRingEquip();
    void setArmorEquip(boolean armor);
    boolean getArmorEquip();
    void setIsUnconscious(boolean unconscious);
    boolean getIsUnconscious();
    int getCurrentHp();
    void setCurrentHp(int hp);
    double getDef();
    void updateTotalStatus();
    double attack();
    double skill1();
    double skill2();
    default void updateExp(int exp){
        this.setCurrentExp(getCurrentExp()+exp);
        if(this.getCurrentExp() >= this.getMaxExp()){
            setCurrentExp(getCurrentExp()-getMaxExp());
            this.updateLevel();

        }
    }
    default void equipBoot(boot boot){
        if(!getBootEquip()) {
            setBootEquip(true);
            setBuffSPD(boot.getSpd());
            setBuffDef(boot.getDef());
            setBuffAtk(boot.getAtk());
            setBuffMana(boot.getMana());
            updateTotalStatus();
        }else{
            System.out.println("you already equip boot");
        }

    }
    default void unEquipBoot(boot boot){
        if(getBootEquip()) {
            setBootEquip(false);
            setBuffSPD(-boot.getSpd());
            setBuffSPD(-boot.getSpd());
            setBuffDef(-boot.getDef());
            setBuffAtk(-boot.getAtk());
            setBuffMana(-boot.getMana());
            updateTotalStatus();
        }else{
            System.out.println("You didn't equip boots yet");
        }
    }
    default void equipRing(ring ring){
        if(!getRingEquip()) {
            setRingEquip(true);
            setBuffSPD(ring.getSpd());
            setBuffDef(ring.getDef());
            setBuffAtk(ring.getAtk());
            setBuffMana(ring.getMana());
            updateTotalStatus();
        }else{
            System.out.println("you already equip ring");
        }
    }
    default void unEquipRing(ring ring){
        if(getRingEquip()) {
            setRingEquip(false);
            setBuffSPD(-ring.getSpd());
            setBuffDef(-ring.getDef());
            setBuffAtk(-ring.getAtk());
            setBuffMana(-ring.getMana());
            updateTotalStatus();
        }else{
            System.out.println("You didn't equip ring yet");
        }
    }
    default void equipArmor(armor armor){
        if(!getArmorEquip()) {
            setArmorEquip(true);
            setBuffSPD(armor.getSpd());
            setBuffDef(armor.getDef());
            setBuffAtk(armor.getAtk());
            setBuffMana(armor.getMana());
            updateTotalStatus();
        }else{
            System.out.println("you already equip armor");
        }
    }
    default void umEquipArmor(armor armor){
        if(getArmorEquip()) {
            setArmorEquip(false);
            setBuffSPD(-armor.getSpd());
            setBuffDef(-armor.getDef());
            setBuffAtk(-armor.getAtk());
            setBuffMana(-armor.getMana());
            updateTotalStatus();
        }else {
            System.out.println("You didn't equip armor yet");
        }
    }
    default void wasAttacked(double damage){
        double damageTaken = damage - getDef() ;
        if(damageTaken > 0) {
            setCurrentHp((int) (getCurrentHp() - damageTaken));
            System.out.println(getName() + " obtained " + damageTaken + " damage");
            if (getCurrentHp() <= 0) {
                setCurrentHp(0);
                setIsUnconscious(true);
                System.out.println("your character is unconscious");
            }
        }else{
            System.out.println(getName()+" No damage");
        }
    }

    default void showCurrentState(){
        System.out.println("--Show " + getName() + " current state--");
        System.out.println("HP = " + getCurrentHp() + "/" + getMaxHp());
        System.out.println("Mana = " + getCurrentMana() + "/" + getMaxMana());
    }
}

