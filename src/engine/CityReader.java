package engine;

import core.*;
import zones.*;
import services.*;
import utilities.*;

import java.io.*;
import java.util.*;

public class CityReader {
    private String fileName;
    private int rows;
    private int cols;
    private Cell[][] mapGrid;

    public CityReader(String fileName){
        this.fileName = fileName;
        this.rows = 0; // we are setting them as 0 bc we don't know the map for now on
        this.cols = 0;
    }

    // reader method of the CityReader object
    public void readAndParseMap(){
        ArrayList<String> lines = new ArrayList<>();
        Scanner sc = null;

        try {
            sc = new Scanner(new File(this.fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().length() > 0){
                    lines.add(line.trim());
                }
            }
        } catch (FileNotFoundException e) {
            throw new teamMeta4126_Exception("ERROR: The file ("+ this.fileName+") has not found.",e);
        
        } finally {
            if (sc != null) sc.close();
        }

        if (lines.isEmpty()) {
            throw new teamMeta4126_Exception("ERROR : file is EMPTY.");
        }

        int maxColumns=0;
        for(String rowLine: lines){
            if(rowLine.length()>maxColumns){
                maxColumns=rowLine.length();
            }
        }

        // updating the fields of the object which we gave initial value as 0
        this.rows = lines.size();
        this.cols = maxColumns;
        this.mapGrid = new Cell[rows][cols];

        // putting objects to the 2d array
        for (int i = 0; i < this.rows; i++) {
            String currentLine = lines.get(i);

            for (int j = 0; j < this.cols; j++) {
                char c ;
                if(j<currentLine.length()){
                    c=currentLine.charAt(j);
                }else {
                    c = 'E';
                }

                switch (c){
                    case 'H':
                        this.mapGrid[i][j] = new Housing(i,j);
                        break;
                    case 'P':
                        this.mapGrid[i][j] = new PowerPlant(i,j);
                        break;
                    case 'R':
                        this.mapGrid[i][j] = new Road(i,j);
                        break;
                    case 'C':
                        this.mapGrid[i][j] = new Commercial(i,j);
                        break;
                    case 'I':
                        this.mapGrid[i][j]=new Industrial(i,j);
                        break;
                    case 'W':
                        this.mapGrid[i][j]= new WaterPumping(i,j);
                        break;
                    case 'F':
                        this.mapGrid[i][j]=new PoliceStation(i,j);
                        break;
                    case 'T' :
                        this.mapGrid[i][j]=new InternetHub(i,j);
                        break;
                    case 'D':
                        this.mapGrid[i][j]= new Hospital(i,j);
                        break;
                    case 'S':
                        this.mapGrid[i][j] = new  School(i,j);
                        break;
                    case 'E':
                        this.mapGrid[i][j] = new Empty(i, j);
                        break;

                    // other foreign letters
                    default:
                        throw new teamMeta4126_Exception ("ERROR: Invalid character: "+ c);
                }
            }
        }
    }



    public Cell[][] getMapGrid () {
        return mapGrid;
    }
    public int getRows (){
        return rows;
    }

    public int getCols (){
        return cols;
    }
}
