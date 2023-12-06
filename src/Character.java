import java.util.List;
public interface Character {
    /**
     * gets name of character
     * returns: name of character
     */
    String getName();

    /**
     * gets level of character
     * returns: level of the character
     */
    int getLevel();

    /**
     * increase level of the character by 1
     * side effects: update all base stats of the character by level that changed
     * side effects: update current total stats output of the character
     * side effects: reset current exp to 0
     */
    void updateLevel();

    /**
     * gets current exp of character
     * returns: currentExp of the character
     */
    int getCurrentExp();

    /**
     * gets max exp of character
     * returns: maxExp of the character
     */
    int getMaxExp();

    /**
     * gets max hp of character
     * returns: maxHp of the character
     */
    int getMaxHp();

    /**
     * gets max mana of character
     * returns: maxMana of the character
     */
    int getMaxMana();

    /**
     * gets current mana of character
     * returns: currentMana of the character
     */
    int getCurrentMana();

    /**
     * set current exp of character equal to input
     * effects: assign new value of currentExp by input exp
     */
    void setCurrentExp(int exp);

    /**
     * gets job name of character
     * returns: Job of character
     */
    String getJob();

    /**
     * show all stats of character
     * effects: print all stats variable of character to console
     */
    void displayStats();

    /**
     * increase buff speed of character by the input value
     * effects: buffSPD increased by spd
     */
    void setBuffSPD(double spd);

    /**
     * increase buff attack of character by the input value
     * effects: buffAtk increased by atk
     */
    void setBuffAtk(double atk);

    /**
     * increase buff defense of character by the input value
     * effects: buffDef increased by def
     */
    void setBuffDef(double def);

    /**
     * increase buff mam of character by the input value
     * effects: buffMana increased by mana
     */
    void setBuffMana(double mana);

    /**
     * update stats value depends on current level of character
     * effects: all base stats calculated by considering level
     * effects: currentMana will be assigned equal to maxMana
     */
    void updateStatus();

    /**
     * use to equip or unequip boots
     * effects:
     */
    void setBootEquip(boolean boot);

    /**
     * character equip boots
     * @returns */
    boolean getBootEquip();
    void setRingEquip(boolean ring);
    boolean getRingEquip();
    void setArmorEquip(boolean armor);
    boolean getArmorEquip();
    void setIsUnconscious(boolean unconscious);

    /**
     * check if character is unconscious or not
     * returns: truth value of consciousness of character*/
    boolean getIsUnconscious();

    /**
     * gets amount of hp that character currently has
     * returns: currentHp of character
     */
    int getCurrentHp();

    /**
     * assign current hp of character
     * effects: assign currentHp = input hp
     */
    void setCurrentHp(int hp);

    /**
     * gets defense of character
     * return: def of character
     */
    double getDef();

    /**
     * update character overall stats
     * effects: calculate total stats = base stats + buff
     * effects: recover currentMana = maxMana
     */
    void updateTotalStatus();

    /** character cast an attack
     * effects: decrease currentMana by 2 then print out mana consumption and damage output
     * effects: "You run out of mana" printed if currentMana is not enough
     * effects: "Character is unconscious" printed if character is unconscious
     * returns: amount of damage that character does (0 damage when unconscious or run out of mana)
     */
    double attack();

    /**
     * character cast a skill 1(severer than normal attack)
     * effects: decrease currentMana by 10 then print out mana consumption and damage output
     * effects: "You run out of mana" printed if currentMana is not enough
     * effects: "Character is unconscious" printed if character is unconscious
     * returns: amount of damage that character does (0 damage when unconscious or run out of mana)
     */
    double skill1();

    /**
     * character cast a skill 2(severer than skill 1)
     * effects: decrease currentMana by 30 then print out mana consumption and damage output
     * effects: "You run out of mana" printed if currentMana is not enough
     * effects: "Character is unconscious" printed if character is unconscious
     * returns: amount of damage that character does (0 damage when unconscious or run out of mana)
     */
    double skill2();

    /**
     * character gaining exp
     * effects: currentExp of character increase by value of exp
     * effects: level up when currentExp is reach max*/
    default void updateExp(int exp){
        this.setCurrentExp(getCurrentExp()+exp);
        if(this.getCurrentExp() >= this.getMaxExp()){
            setCurrentExp(getCurrentExp()-getMaxExp());
            this.updateLevel();
        }
    }

    /**
     * character put on boots accessory
     * effects: "you already equip boot" printed if character is already wore boot
     * effects: update buff stats and total stats of character consider to effects of boot
     */
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

   /**
    * character take off boots accessory
    * effects: "You didn't equip boots yet" printed if character didn't wear boots
    * effects: cancel buff effects of boot from total stats of character
    */
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

    /**
     * character put on ring accessory
     * effects: "you already equip ring" printed if character is already wore ring
     * effects: update buff stats and total stats of character consider to effects of ring
     */
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

    /**
     * character take off ring accessory
     * effects: "You didn't equip ring yet" printed if character didn't wear ring
     * effects: cancel buff effects of ring from total stats of character
     */
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

    /**
     * character put on armor accessory
     * effects: "you already equip armor" printed if character is already wore armor
     * effects: update buff stats and total stats of character consider to effects of armor
     */
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

    /**
     * character take off armor accessory
     * effects: "You didn't equip arnor yet" printed if character didn't wear arnor
     * effects: cancel buff effects of arnor from total stats of character
     */
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

    /**
     * character take damage
     * effects: print out amount of actual damage that character take(input damage can reduce by def of character)
     * effects: decrease currentHp of character by damage taken
     * effects: "your character is unconscious" printed and set isUnconscious = true when currentHp is lower than 1
     * effects: print "(name) No damage" when defense is high enough to block all damage
     */
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

    /**
    * show current state of character
    * effects: print  " --Show (name) current state--
    *                   HP = (currentHo)/250
    *                   Mana = (currentMana)/122      "
    */
    default void showCurrentState(){
        System.out.println("--Show " + getName() + " current state--");
        System.out.println("HP = " + getCurrentHp() + "/" + getMaxHp());
        System.out.println("Mana = " + getCurrentMana() + "/" + getMaxMana());
    }
}

