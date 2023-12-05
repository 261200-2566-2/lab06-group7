public class Tank implements Character{
    String name;
    private int level;
    private int maxExp;
    private int currentExp;
    private int maxHp;
    private int currentHp;
    private int maxMana;
    private int currentMana;
    private double SPD;
    private double atk;
    private double def;
    private double buffSPD;
    private double buffAtk;
    private double buffDef;
    private int buffMana;
    private double totalSPD;
    private double totalAtk;
    private double totalDef;
    private int totalMana;
    private boolean isBootEquip;
    private boolean isRingEquip;
    private boolean isArmorEquip;
    private boolean isUnconscious;
    public Tank(String name){
        this.name = name;
        level = 1;
        updateStatus();
        updateTotalStatus();
        currentHp = maxHp;
        currentMana = maxMana;
    }

    public void updateStatus(){
        maxHp = 500+(10*level);
        maxMana = 100+(2*level);
        maxExp = 100*level;
        SPD = 10+level;
        atk = 40+(5*level);
        def = 100+(6*level);
        currentMana = maxMana;
    }


    public void updateLevel(){
        level++;
        updateStatus();
        updateTotalStatus();
        updateExp(0);
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }
    public int getMaxExp(){
        return this.maxExp;
    }
    public int getCurrentExp(){
        return currentExp;
    }
    public int getCurrentHp(){
        return currentHp;
    }
    public void setCurrentExp(int exp){
        this.currentExp = exp;
    }
    public String getJob(){
        return "Tank";
    }
    public double getDef(){
        return def;
    }
    public int getMaxHp(){
        return this.maxHp;
    }
    public void setCurrentHp(int hp){
        currentHp = hp;
    }
    public int getMaxMana(){
        return this.maxMana;
    }
    public int getCurrentMana(){
        return this.currentMana;
    }
    public void setBuffSPD(double spd){
        this.buffSPD+=spd;
    }
    public void setBuffAtk(double atk){
        this.buffAtk += atk;
    }
    public void setBuffDef(double def){
        this.buffDef +=def;
    }
    public void setBuffMana(double mana){
        this.buffMana +=mana;
    }
    public void setBootEquip(boolean boot) {
        isBootEquip = boot;
    }
    public void setRingEquip(boolean ring){
        isRingEquip = ring;
    }
    public void setArmorEquip(boolean armor){
        isArmorEquip = armor;
    }
    public void setIsUnconscious(boolean unconscious){
        isUnconscious = unconscious;
    }

    @Override
    public boolean getBootEquip() {
        return isBootEquip;
    }

    @Override
    public boolean getRingEquip() {
        return isRingEquip;
    }
    @Override
    public boolean getArmorEquip() {
        return isArmorEquip;
    }
    public boolean getIsUnconscious(){
        return isUnconscious;
    }
    @Override
    public void updateTotalStatus() {
        totalSPD = SPD+buffSPD;
        totalDef = def+buffDef;
        totalAtk = atk+buffAtk;
        totalMana = maxMana+buffMana;
        currentMana = maxMana;
    }
    public double attack(){
        if(!isUnconscious){
            System.out.println(name+" attack "+atk);
            return atk;
        }else{
            System.out.println("Character is unconscious");
            return 0;
        }
    }
    public double skill1(){
        if(!isUnconscious){
            if(currentMana >= 10){
                System.out.println(name+" use 10 mana");
                currentMana -= 10;
                System.out.println(name+" attack "+2*atk);
                return 2*atk;
            }else{
                System.out.println("You run out of mana");
                return 0;
            }
        }else{
            System.out.println("Character is unconscious");
            return 0;
        }
    }
    public double skill2(){
        if(!isUnconscious){
            if(currentMana >= 30){
                System.out.println(name+" use 30 mana");
                currentMana -= 30;
                System.out.println(name+" attack "+50*level);
                return 50*level;
            }else{
                System.out.println("You run out of mana");
                return 0;
            }
        }else{
            System.out.println("Character is unconscious");
            return 0;
        }
    }
    public void displayStats() {
        System.out.println("name : " + this.name);
        System.out.println("level " + this.level+ " | exp : " + this.currentExp +"/" + this.maxExp);
        System.out.println("HP : " + this.currentHp +"/" + this.maxHp);
        System.out.println("Mana : "+this.currentMana+"/" + this.totalMana);
        System.out.println("Speed : " + this.totalSPD);
        System.out.println("Attack : " + this.totalAtk);
        System.out.println("Defense : " + this.totalDef);
    }
}
