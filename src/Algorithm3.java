public class Algorithm3 {

    public void distributeResources(Cell[][] cityMap,
                                    int totalPopulation,
                                    int totalGoods,
                                    int totalLifestyle) {
        
        if (cityMap == null || cityMap.length == 0) {
            throw new SE116ConfigurationException("ERROR: City map is null or empty. Resource distribution cannot proceed.");
        }

        int rows = cityMap.length;
        int cols = cityMap[0].length;

        int industrialCount = 0;
        int commercialCount = 0;
        int housingCount = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(cityMap[i][j] instanceof Industrial) industrialCount++;
                else if(cityMap[i][j] instanceof Commercial) commercialCount++;
                else if(cityMap[i][j] instanceof Housing) housingCount++;
            }
        }

        int populationPerReceiver = 0;
        int goodsPerCommercial = 0;
        int lifestylePerHouse = 0;

        int totalPopReceivers = industrialCount + commercialCount;

        if(totalPopReceivers > 0)
            populationPerReceiver = totalPopulation / totalPopReceivers;

        if(commercialCount > 0)
            goodsPerCommercial = totalGoods / commercialCount;

        if(housingCount > 0)
            lifestylePerHouse = totalLifestyle / housingCount;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(cityMap[i][j] instanceof Zone){
                    Zone zone = (Zone) cityMap[i][j];

                    if(zone instanceof Industrial || zone instanceof Commercial){
                        zone.setPopulation(populationPerReceiver);
                        printResource(zone, "population", populationPerReceiver);
                    }

                    if(zone instanceof Commercial){
                        zone.setGoods(goodsPerCommercial);
                        printResource(zone, "goods", goodsPerCommercial);
                    }

                    if(zone instanceof Housing){
                        zone.setLifestyle(lifestylePerHouse);
                        printResource(zone, "lifestyle", lifestylePerHouse);
                    }
                }
            }
        }
    }

    private void printResource(Zone zone, String resource, int amount){
        System.out.println(zone.getBuildingName() +
                " at (" + zone.getRow() + "," + zone.getColumn() + ")" +
                " received " + amount + " " + resource);
    }
}
