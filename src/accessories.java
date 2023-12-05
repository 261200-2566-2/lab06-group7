public interface accessories {
    void showStatus();
    void updateStatus();
    int getCurrentExp();
    int getMaxExp();
    void updateLevel();
    void setCurrentExp(int exp);
    double getAtk();
    double getDef();
    double getMana();
    double getSpd();
    default void updateExp(int exp){
    setCurrentExp(getCurrentExp()+exp);
        if(getCurrentExp() >= getMaxExp()){
            setCurrentExp(getCurrentExp()-getMaxExp());
            updateLevel();
        }
    }

}
