package zones;

public class Housing extends Zone {

    public Housing(int n, int m) {
        super(n,m);
        this.symbol ='H';
    }
   @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getHasInternet()) {
            level = 1;
            
        }
        else if (level == 1 && getHasElectricity() && getHasWater() && getHasInternet() && getHasSecurity() && getHasHealth() && getHasEducation()) {
         level = 2;
      
        }
        else if (level == 2 && getHasElectricity() && getHasWater() && getHasInternet() && getHasSecurity() && getHasHealth() && getHasEducation() && getLifestyle() > 0) {
          level = 3;
       
        }
    }
    @Override
    public void levelDown() {
        if (!(getHasElectricity() && getHasInternet() && getHasWater())) {
            if(level!=0) {
            level = 0;
        }
            return;
        }
        else if (level == 3 && !(getHasSecurity() && getHasHealth() && getHasEducation() && getLifestyle() > 0)) {
           level = 2;       
            
        }
       else if (level == 2 && !(getHasSecurity() && getHasHealth() && getHasEducation())) {
            level = 1;
  
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
        printOutput(generatedOutput,"population");

        
        if(generatedOutput>0){
            this.demand=output;
      }else{
            this.demand=1;
        }
    }
}
