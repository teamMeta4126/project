package zones;

public class Housing extends Zone {

    public Housing(int n, int m) {
        super(n,m);
        this.symbol ='H';
    }
   @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getHasInternet()) {
            int oldLevel=level;
            level = 1;
            displayLevelChange(oldLevel,level);
        }
        else if (level == 1 && getHasElectricity() && getHasWater() && getHasInternet() && getHasSecurity() && getHasHealth() && getHasEducation()) {
            int oldLevel=level;
            level = 2;
            displayLevelChange(oldLevel,level);
        }
        else if (level == 2 && getHasElectricity() && getHasWater() && getHasInternet() && getHasSecurity() && getHasHealth() && getHasEducation() && getLifestyle() > 0) {
            int oldLevel=level;
            level = 3;
            displayLevelChange(oldLevel,level);
        }
    }
    @Override
    public void levelDown() {
        if (!(getHasElectricity() && getHasInternet() && getHasWater())) {
            if(level!=0) {
                int oldLevel = level;
                level = 0;
                displayLevelChange(oldLevel, level);
            }
            return;
        }
        if (level == 3 && !(getHasSecurity() && getHasHealth() && getHasEducation() && getLifestyle() > 0)) {
            int oldLevel=level;
            level = 2;
            displayLevelChange(oldLevel,level);
        }
        else if (level == 2 && !(getHasSecurity() && getHasHealth() && getHasEducation())) {
            int oldLevel=level;
            level = 1;
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
            generatedOutput=(m*2)+getLifestyle();
        }
       this.output=generatedOutput;
        if(generatedOutput>0){
            this.demand=output;
            printOutput(generatedOutput,"population");
        }else{
            this.demand=1;
        }
    }
}
