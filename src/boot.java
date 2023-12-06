public class boot implements accessories{
    private double atk;
    private double def;
    private double mana;
    private double spd;
    private int currentExp;
    private int maxExp;
    private int level;

    /**
     * set default value of boot
     * effect: modify status of boot
     */
    public boot(){
        level = 1;
        this.spd = 50;
        this.atk = 10;
        this.def = 20;
        this.mana = 10;
        this.updateStatus();
    }
    @Override
    public double getAtk() {
        return atk;
    }
    @Override
    public double getMana() {
        return mana;
    }
    @Override
    public double getDef() {
        return def;
    }
    @Override
    public double getSpd() {
        return spd;
    }
    @Override
    public int getCurrentExp() {
        return currentExp;
    }
    public int getMaxExp(){
        return maxExp;
    }
    @Override
    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }
    @Override
    public void updateLevel() {
        level++;
        updateStatus();
    }
    public void showStatus(){
        System.out.println("------Show status of boots-----");
        System.out.println("level : " + this.level);
        System.out.println("exp :" + this.currentExp +"/"+this.maxExp);
        System.out.println("atk +"+atk);
        System.out.println("def +"+def);
        System.out.println("mana +" +mana);
        System.out.println("spd +"+ spd);
    }
    public void updateStatus() {
        atk = level;
        def = 2 * level;
        mana = 2 * level;
        spd = 15 * level;
        maxExp = 10 * level;
        updateExp(0);
    }

}
