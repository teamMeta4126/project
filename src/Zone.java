public abstract class Zone extends Cell {
    protected int level;
    protected int demand;
    protected int output;
    protected boolean hasSecurity ;
    protected boolean hasHealth ;
    protected boolean hasEducation;
    protected boolean hasWater;
    protected boolean hasElectricity;
    protected boolean hasInternet;

    protected int internet;
    protected int water;
    protected int electricity;
    protected int lifestyle;
    protected int population;
    protected int goods;

    public abstract void levelUp();
    public abstract void levelDown();
    public abstract void controlOutput();

    public void resetForNextTick(){
        this.setHasSecurity(false);
        this.setHasEducation(false);
        this.setHasHealth(false);

        this.setWater(0);
        this.setElectricity(0);
        this.setInternet(0);

        this.setLifestyle(0);
        this.setPopulation(0);
        this.setGoods(0);
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }
    public boolean getHasSecurity() {
        return hasSecurity;
    }

    public void setHasHealth(boolean hasHealth) {
        this.hasHealth = hasHealth;
    }
    public boolean getHasHealth(){
        return hasHealth;
    }

    public void setHasEducation(boolean hasEducation) {
        this.hasEducation = hasEducation;
    }
    public boolean getHasEducation(){
        return hasEducation;
    }


    public boolean getHasWater() {
        return hasWater;
    }


    public boolean getHasElectricity() {
        return hasElectricity;
    }


    public boolean getHasInternet() {
        return hasInternet;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
        this.hasWater=this.water>0;
    }
    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
        this.hasElectricity=this.electricity>0;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
        this.hasInternet=this.internet>0;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    public int getGoods() {
        return goods;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public Zone(int n, int m) {
        super(n,m);
        this.level = 0;
        this.demand = 1;
        this.output = 0;
        this.hasSecurity = false;
        this.hasHealth = false;
        this.hasEducation = false;
        this.hasWater = false;
        this.hasElectricity = false;
        this.hasInternet = false;
        this.lifestyle=0;
        this.population=0;
        this.goods=0;
    }
}
