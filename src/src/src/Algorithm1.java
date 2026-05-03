public class Algorithm1 {
    public void provideServices(Cell[][] cityMap){
        int mapRows=cityMap.length;
        int mapColumns=cityMap[0].length;


        //Searching for the service providers
        for (int i=0;i<mapRows;i++){
            for(int j=0;j<mapColumns;j++){
                if(cityMap[i][j] instanceof Service){
                    Service service=(Service) cityMap[i][j];


                    //Searching for the zones that will receive the service
                    for(int k=0;k<mapRows;k++){
                        for (int l=0;l<mapColumns;l++){
                            if (cityMap[k][l] instanceof Zone){
                                Zone zone=(Zone)cityMap[k][l];

                                //Calculating the distance between the service provider and the zone
                                double distance=Math.sqrt(Math.pow(k-i, 2) + Math.pow(l-j, 2));

                                //Providing the service to the zone depending on the radius
                                if(distance<=service.getRadius()){

                                    if(service instanceof Hospital){
                                        zone.setHasHealth(true);
                                        printServiceOutput(zone, "health service");
                                    }
                                    else if(service instanceof PoliceStation){
                                        zone.setHasSecurity(true);
                                        printServiceOutput(zone, "security service");
                                    }
                                    else if(service instanceof School){
                                        zone.setHasEducation(true);
                                        printServiceOutput(zone, "education service");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    // This helper method is for printing the service distribution output for Tick-1
    private void printServiceOutput(Zone zone, String serviceName) {
        System.out.println(zone.getBuildingName()+" at (" +zone.getRow()+","+ zone.getColumn()+") received " +serviceName);
    }
}
