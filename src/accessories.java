public interface accessories {

    /**
     * Show status of accessory.
     *  effects: print out status of accessory
     */
    void showStatus();

    /**
     *  change status values of accessory
     *  effects: modify status values
     */
    void updateStatus();

    /**
     * give value of currentExp
     * @return value of currentExp
     */
    int getCurrentExp();

    /**
     * give value of maxExp
     * @return value of maxExp
     */
    int getMaxExp();

    /**
     * increase the level of accessory by 1
     * effects: modify level of accessory
     */
    void updateLevel();

    /**
     * set value of currentExp to the received value
     * effect: modify currentExp of accessory
     * @param exp value of currentExp
     */
    void setCurrentExp(int exp);

    /**
     * give value of atk
     * @return atk of accessory
     */
    double getAtk();

    /**
     * give value of def
     * @return def of accessory
     */
    double getDef();

    /**
     * give value of mana
     * @return mana of accessory
     */
    double getMana();

    /**
     * give value of spd
     * @return spd of accessory
     */
    double getSpd();

    /**
     * change exp of accessory
     * @param exp value of the exp received
     */
    default void updateExp(int exp){
    setCurrentExp(getCurrentExp()+exp);
        if(getCurrentExp() >= getMaxExp()){
            setCurrentExp(getCurrentExp()-getMaxExp());
            updateLevel();
        }
    }

}
