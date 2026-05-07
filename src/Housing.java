public class Housing extends Zone {

    public Housing(int n, int m) {
        super(n,m);
        this.symbol ='H';
    }
    @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getHasInternet()) {
            level = 1;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 0 to 1");
        }
        else if (level == 1 && getHasElectricity() && getHasWater() && getHasInternet() && getHasSecurity() && getHasHealth() && getHasEducation()) {
            level = 2;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 1 to 2");
        }
        else if (level == 2 && getHasElectricity() && getHasWater() && getHasInternet() && getHasSecurity() && getHasHealth() && getHasEducation() && getLifestyle() > 0) {
            level = 3;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 2 to 3");
        }
    }
    @Override
    public void levelDown() {
        if (!(getHasElectricity() && getHasInternet() && getHasWater())) {
            if (level != 0) {
                System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from " + level + " to 0");
                level = 0;
            }
            return;
        }
        if (level == 3 && !(getHasSecurity() && getHasHealth() && getHasEducation() && getLifestyle() > 0)) {
            level = 2;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 3 to 2");
        }
        else if (level == 2 && !(getHasSecurity() && getHasHealth() && getHasEducation())) {
            level = 1;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 2 to 1");
        }
    }
}
