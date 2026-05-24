import core.*;
import zones.*;
import services.*;
import utilities.*;
import engine.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        if(args.length != 2){
            throw new SE116ConfigurationException("ERROR: Missing map file or tick count.");
        }

        String fileName = args[0];
        int tickCount;

        try{
            tickCount = Integer.parseInt(args[1]);

            if(tickCount < 1){
                throw new SE116ConfigurationException("ERROR: Tick count must be greater than 0.");
            }

        } catch (NumberFormatException e){
            throw new SE116ConfigurationException("ERROR: Invalid tick count.", e);
        }

        CityReader cityReader = new CityReader(fileName);
        cityReader.readAndParseMap();

        Cell[][] cityMap = cityReader.getMapGrid();

        Algorithm1 algorithm1 = new Algorithm1();
        Algorithm2 algorithm2 = new Algorithm2();
        Algorithm3 algorithm3 = new Algorithm3();

        int totalPopulation = 0;
        int totalGoods = 0;
        int totalLifestyle = 0;

        for(int tick = 1; tick <= tickCount; tick++){

            System.out.println("TICK " + tick);

            int rows = cityMap.length;
            int cols = cityMap[0].length;

            ArrayList<Zone> allZones = new ArrayList<>();

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){

                    if(cityMap[i][j] instanceof Zone){
                        allZones.add((Zone) cityMap[i][j]);
                    }
                }
            }

            allZones.forEach(zone -> zone.resetForNextTick());

            algorithm1.provideServices(cityMap);

            algorithm2.distributeUtility(cityMap);

            algorithm3.distributeResources(cityMap, totalPopulation, totalGoods, totalLifestyle);

            allZones.forEach(zone -> {
                zone.controlLevel();zone.controlOutput();
            });

            totalPopulation = 0;
            totalGoods = 0;
            totalLifestyle = 0;

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){

                    if(cityMap[i][j] instanceof Housing){
                        Housing housing = (Housing) cityMap[i][j];
                        totalPopulation += housing.getOutput();
                    }

                    else if(cityMap[i][j] instanceof Industrial){
                        Industrial industrial = (Industrial) cityMap[i][j];
                        totalGoods += industrial.getOutput();
                    }

                    else if(cityMap[i][j] instanceof Commercial){
                        Commercial commercial = (Commercial) cityMap[i][j];
                        totalLifestyle += commercial.getOutput();
                    }
                }
            }

            System.out.println();
        }
    }
}
