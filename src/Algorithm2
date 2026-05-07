import java.util.Queue;
import java.util.LinkedList;

public class Algorithm2 {

    public void distributeUtility(Cell[][] cityMap){
        int rows = cityMap.length;
        int columns = cityMap[0].length;
// Based on the output, we printed the utilities in the order of InternetHub, WaterPumping, and PowerPlant
for(int priorityOutput=0;priorityOutput<3;priorityOutput++) {

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (cityMap[i][j] != null && cityMap[i][j] instanceof UtilityProvider) {

                //The required utility type is filtered for the output.

                if (priorityOutput == 0 && !(cityMap[i][j] instanceof InternetHub)) {
                    continue;
                }
                if (priorityOutput == 1 && !(cityMap[i][j] instanceof WaterPumping)) {
                    continue;
                }
                if (priorityOutput == 2 && !(cityMap[i][j] instanceof PowerPlant)) {
                    continue;
                }
// Resetting the distributed matrix allows utilities to propagate through already distributed zones (only distributing to the needed zones).
                boolean[][] distributed = new boolean[rows][columns];
                Queue<Cell> cellQueue = new LinkedList<>();

                cellQueue.add(cityMap[i][j]);
                distributed[i][j] = true;
                UtilityProvider currentProvider = (UtilityProvider) cityMap[i][j];
                int utilityAmount = currentProvider.getCapacity();


                while (cellQueue.isEmpty() == false) {
                    Cell currentCell = cellQueue.poll();

                    if (utilityAmount <= 0) break;


                    if (currentCell instanceof Zone) {
                        Zone currentZone = (Zone) currentCell;
                        int currentDemand = currentZone.getDemand();
                        int remainingDemand=0;

                        if (currentProvider instanceof WaterPumping) {
                            remainingDemand = currentDemand - currentZone.getWater();
                        } else if (currentProvider instanceof PowerPlant) {
                            remainingDemand = currentDemand - currentZone.getElectricity();
                        } else if (currentProvider instanceof InternetHub) {
                            remainingDemand = currentDemand - currentZone.getInternet();
                        }
                        if (remainingDemand>0) {
                            int distributedAmount = 0;

                            if (utilityAmount >= remainingDemand) {
                                distributedAmount = remainingDemand;
                            } else {
                                distributedAmount = utilityAmount;
                            }
                            utilityAmount = utilityAmount - distributedAmount;

                            if (currentProvider instanceof InternetHub) {
                                currentZone.setInternet(currentZone.getInternet() + distributedAmount);
                                printUtilityOutput(currentZone, "internet", distributedAmount);
                            } else if (currentProvider instanceof WaterPumping) {
                                currentZone.setWater(currentZone.getWater() + distributedAmount);
                                printUtilityOutput(currentZone, "water", distributedAmount);
                            } else if (currentProvider instanceof PowerPlant) {
                                currentZone.setElectricity(currentZone.getElectricity() + distributedAmount);
                                printUtilityOutput(currentZone, "electricity", distributedAmount);
                            }
                        }
                    }

                    int currentRow = currentCell.getRow();
                    int currentColumn = currentCell.getColumn();

                    int northRow = currentRow - 1;
                    int northColumn = currentColumn;
                    int southRow = currentRow + 1;
                    int southColumn = currentColumn;
                    int westRow = currentRow;
                    int westColumn = currentColumn - 1;
                    int eastRow = currentRow;
                    int eastColumn = currentColumn + 1;


                    //Checking the neighbors of the current cell and continuing to distribute if possible
                    if (northRow >= 0 && distributed[northRow][northColumn] == false) {
                        Cell cellNorth = cityMap[northRow][northColumn];
                        if (cellNorth != null && (cellNorth instanceof Road || cellNorth instanceof Zone)) {
                            cellQueue.add(cellNorth);
                            distributed[northRow][northColumn] = true;
                        }
                    }
                    if (southRow < rows && distributed[southRow][southColumn] == false) {
                        Cell cellSouth = cityMap[southRow][southColumn];
                        if (cellSouth != null && (cellSouth instanceof Road || cellSouth instanceof Zone)) {
                            cellQueue.add(cellSouth);
                            distributed[southRow][southColumn] = true;
                        }
                    }
                    if (westColumn >= 0 && distributed[westRow][westColumn] == false) {
                        Cell cellWest = cityMap[westRow][westColumn];
                        if (cellWest != null && (cellWest instanceof Road || cellWest instanceof Zone)) {
                            cellQueue.add(cellWest);
                            distributed[westRow][westColumn] = true;
                        }
                    }
                    if (eastColumn < columns && distributed[eastRow][eastColumn] == false) {
                        Cell cellEast = cityMap[eastRow][eastColumn];
                        if (cellEast != null && (cellEast instanceof Road || cellEast instanceof Zone)) {
                            cellQueue.add(cellEast);
                            distributed[eastRow][eastColumn] = true;
                        }
                    }
                }

            }
        }
    }
}

    }
    //This helper method is for printing the utility distribution output for Tick-2
    private void printUtilityOutput(Zone zone , String utilityName, int demand ){
        System.out.println(zone.getBuildingName()+" at ("+zone.getRow() +"," +zone.getColumn()+ ") received " +demand +" "+ utilityName);
    }

}
