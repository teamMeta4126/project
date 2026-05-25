package zones;

public class Commercial extends Zone {

    public Commercial(int n, int m) {
        super(n, m);
        this.symbol = 'C';
    }

   @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getHasInternet() && getPopulation() > 0 && getGoods() > 0) {
            int oldLevel=level;
            level = 1;
            displayLevelChange(oldLevel,level);
        } else if (level == 1 && getHasElectricity() && getHasWater() && getHasInternet() && getPopulation() > 0 && getGoods() > 0 && getHasSecurity()) {
            int oldLevel=level;
            level = 2;
            displayLevelChange(oldLevel,level);
        } else if (level == 2 && getHasElectricity() && getHasWater() && getHasInternet() && getPopulation() > 0 && getGoods() > 0 && getHasSecurity()) {
            int oldLevel=level;
            level = 3;
            displayLevelChange(oldLevel,level);
        }
    }

    @Override
    public void levelDown() {
        if (!(getHasElectricity() && getHasInternet() && getHasWater())) {
            if (level != 0) {
                int oldLevel=level;
                level = 0;
                displayLevelChange(oldLevel,level);
            }
            return;
        }
        if (level == 3 && !(getPopulation() > 0 && getGoods() > 0 && getHasSecurity())) {
            int oldLevel=level;
            level = 2;
            displayLevelChange(oldLevel,level);
        }
        else if (level == 2 && !(getPopulation() > 0 && getGoods() > 0 && getHasSecurity())) {
            int oldLevel=level;
            level = 1;
            displayLevelChange(oldLevel,level);
        }
        else if (level == 1 && !(getPopulation() > 0 && getGoods() > 0)) {
            int oldLevel=level;
            level = 0;
            displayLevelChange(oldLevel,level);
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

