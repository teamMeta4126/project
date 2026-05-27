package zones;

public class Industrial extends Zone{

    public Industrial(int n,int m){
        super(n,m);
        this.symbol='I';
    }
   @Override
    public void levelUp() {
        if (level == 0 && getHasElectricity() && getHasWater() && getPopulation() > 0) {
         level = 1;
          
        }
        else if (level == 1 && getHasElectricity() && getHasWater() && getPopulation() > 0 && getHasSecurity()) {
         level = 2;
         
        }
        else if (level == 2 && getHasElectricity() && getHasWater() && getPopulation() > 0 && getHasSecurity()) {
        level = 3;
          
        }
    }
    @Override
    public void levelDown() {
        if (!(getHasElectricity() && getHasWater())) {
            if (level != 0) {
             level = 0;
              
            }
            return;
        }
        if (level == 3 && !(getPopulation() > 0 && getHasSecurity())) {
             level = 2;
            
        }
        if (level == 2 && !(getPopulation() > 0 && getHasSecurity())) {
         level = 1;
           
        }
        if (level == 1 && !(getPopulation() > 0)) {
         level = 0;
       }
    }
        @Override
    public void controlOutput(){
        int m;
        if(getElectricity()<getWater()){
            m=getElectricity();
        }else {
            m=getWater();
        }
        int generatedOutput=0;

        if(level==1){
            generatedOutput=m;
        }
        else if(level==2){
            generatedOutput=m*2;
        }
        else if(level==3){
            generatedOutput=(m*2)+getPopulation();
        }
        this.output=generatedOutput;

        printOutput(generatedOutput, "goods");

        if(generatedOutput>0){
            this.demand=output;
            
        }else{
            this.demand=1;
        }
    }
}
