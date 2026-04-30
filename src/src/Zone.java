public abstract class Zone extends Cell {
    protected int level;
    protected int demand;
    protected int output;
    protected boolean hasSecurity = false;
    protected boolean hasHealth = false;
    protected boolean hasEducation = false;

    public abstract void levelUp();
    public abstract void levelDown();

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public boolean getHasSecurity() {
        return hasSecurity;
    }

    public void setHasHealth(boolean hasHealth) {
        this.hasHealth = hasHealth;
    }
    public boolean isHasHealth(){
        return hasHealth;
    }

    public void setHasEducation(boolean hasEducation) {
        this.hasEducation = hasEducation;
    }
    public boolean getHasEducation(){
        return hasEducation;
    }


    public Zone(int n, int m) {
      super(n,m);
        this.level = 0;
        this.demand = 0;
        this.output = 0;
        this.hasSecurity = false;
        this.hasHealth = false;
        this.hasEducation = false;
    }
}
