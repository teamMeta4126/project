public abstract class Cell {
    protected int n;
    protected int m;
    protected char symbol;

    public Cell(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getRow() {
        return n;
    }

    public int getColumn() {
        return m;
    }

    public String getBuildingName() {
        switch (this.symbol) {
            case 'H':
                return "House";
            case 'I':
                return "Industrial";
            case 'C':
                return "Commercial";
            case 'P':
                return "Power Plant";
            case 'W':
                return "Water Pumping Station";
            case 'T':
                return "Internet Hub";
            case 'F':
                return "Police Station";
            case 'D':
                return "Hospital";
            case 'S':
                return "School";
            case 'R':
                return "Road";
            case 'E':
                return "Empty";
            default:
                throw new SE116ConfigurationException("Invalid cell: " + this.symbol);
        }
    }
}
