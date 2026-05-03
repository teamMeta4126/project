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
            System.out.println("ERROR: " + this.fileName + " the file HAS NOT FOUND!");
            return;
        } finally {
            if (sc != null) sc.close();
        }

        if (lines.isEmpty()) {
            System.out.println("ERROR : file is EMPTY.");
            return;
        }

        // updating the fields of the object which we gave initial value as 0
        this.rows = lines.size();
        this.cols = lines.get(0).length();
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
                        this.mapGrid[i][j] = new Housing();
                        break;
                    case 'P':
                        this.mapGrid[i][j] = new PowerPlant();
                        break;
                    case 'R':
                        this.mapGrid[i][j] = new Road();
                        break;
                    case 'C':
                        this.mapGrid[i][j] = new Commercial();
                        break;
                    case 'I':
                        this.mapGrid[i][j]=new Industrial();
                        break;
                    case 'W':
                        this.mapGrid[i][j]= new WaterStation();
                        break;
                    case 'F':
                        this.mapGrid[i][j]=new PoliceStation();
                        break;
                    case 'T' :
                        this.mapGrid[i][j]=new InternetHub();
                        break;
                    case 'D':
                        this.mapGrid[i][j]= new Hospital();
                        break;
                    case 'S':
                        this.mapGrid[i][j] = new  School();
                        break;

                    // other foreign letters
                    default:
                        this.mapGrid[i][j] = new Empty();
                        break;
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

