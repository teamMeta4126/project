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

    public abstract void levelUp();
    public abstract void levelDown();

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

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }
    public boolean getHasWater() {
        return hasWater;
    }

    public void setHasElectricity(boolean hasElectricity) {
        this.hasElectricity = hasElectricity;
    }
    public boolean getHasElectricity() {
        return hasElectricity;
    }

    public void setHasInternet(boolean hasInternet) {
        this.hasInternet = hasInternet;
    }
    public boolean getHasInternet() {
        return hasInternet;
    }

    public Zone(int n, int m) {
        super(n,m);
        this.level = 0;
        this.demand = 0;
        this.output = 0;
        this.hasSecurity = false;
        this.hasHealth = false;
        this.hasEducation = false;
        this.hasWater = false;
        this.hasElectricity = false;
        this.hasInternet = false;
    }
}
