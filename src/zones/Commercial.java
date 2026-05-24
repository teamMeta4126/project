public class Commercial extends Zone {

    public Commercial(int n, int m) {
        super(n, m);
        this.symbol = 'C';
    }

    @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getHasInternet() && getPopulation() > 0 && getGoods() > 0) {
            level = 1;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 0 to 1");
        } else if (level == 1 && getHasElectricity() && getHasWater() && getHasInternet() && getPopulation() > 0 && getGoods() > 0 && getHasSecurity()) {
            level = 2;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels up from 1 to 2");
        } else if (level == 2 && getHasElectricity() && getHasWater() && getHasInternet() && getPopulation() > 0 && getGoods() > 0 && getHasSecurity()) {
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
        if (level == 3 && !(getPopulation() > 0 && getGoods() > 0 && getHasSecurity())) {
            level = 2;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 3 to 2");
        }
        else if (level == 2 && !(getPopulation() > 0 && getGoods() > 0 && getHasSecurity())) {
            level = 1;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 2 to 1");
        }
        else if (level == 1 && !(getPopulation() > 0 && getGoods() > 0)) {
            level = 0;
            System.out.println(getBuildingName() + " at (" + getRow() + "," + getColumn() + ") levels down from 1 to 0");
        }
    }
    @Override
    public void controlOutput(){
        int m=getElectricity();
        if(getInternet()<m) {
            m = getInternet();
        }
        if(getWater()<m){
            m=getWater();
        }
        int generatedOutput=0;
        if(level==1){
            generatedOutput=m;
        } else if (level==2) {
            generatedOutput=m*2;
        }else if(level==3){
            int minResource=getPopulation();
            if(getGoods()<minResource){
                minResource=getGoods();
            }
            generatedOutput=(m*2)+minResource;
        }
        this.output=generatedOutput;
        if(generatedOutput>0){
            this.demand=output;
            printOutput(generatedOutput,"lifestyle");
        }else{
            this.demand=1;
        }
    }
}

