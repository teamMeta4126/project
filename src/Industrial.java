public class Industrial extends Zone{

    public Industrial(int n,int m){
        super(n,m);
        this.symbol='I';
    }
    @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getPopulation() > 0) {
            level = 1;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 0 to 1");
        }
        else if (level == 1 && getHasElectricity() && getHasWater() && getPopulation() > 0 && getHasSecurity()) {
            level = 2;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 1 to 2");
        }
        else if (level == 2 && getHasElectricity() && getHasWater() && getPopulation() > 0 && getHasSecurity()) {
            level = 3;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 2 to 3");
        }
    }
    @Override
    public void levelDown() {
        if (!(getHasElectricity() && getHasWater())) {
            if (level != 0) {
                System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from " + level + " to 0");
                level = 0;
            }
            return;
        }
        if (level == 3 && !(getPopulation() > 0 && getHasSecurity())) {
            level = 2;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 3 to 2");
        }
        else if (level == 2 && !(getPopulation() > 0 && getHasSecurity())) {
            level = 1;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 2 to 1");
        }
        else if (level == 1 && !(getPopulation() > 0)) {
            level = 0;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 1 to 0");
        }
    }
}
