public abstract class Zone extends Cell {
    protected int level;
    protected int demand;
    protected int output;

    public abstract void levelUp();
    public abstract void levelDown();

    public Zone(int n, int m) {
      super(n,m);
        this.level = 0;
        this.demand = 0;
        this.output = 0;
    }
}
