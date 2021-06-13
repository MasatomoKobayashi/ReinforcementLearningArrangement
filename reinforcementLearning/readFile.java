package reinforcementLearning;

import java.io.*;
import java.util.*;

public class readFile {
    private String temp[];
    private ArrayList<ArrayList<String>> Data;
    private ArrayList<String> Datum;
    private int i;

    public readFile(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            Data = new ArrayList<ArrayList<String>>();

            String line = "";
            i = 0;
            while ((line = br.readLine()) != null) {
                Datum = new ArrayList<String>();
                temp = line.split(",");
                for (int n = 0; n < 6; n++) {
                    Datum.add(temp[n]);
                }
                Data.add(Datum);
                i++;
            }
            br.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> getData() {
        return Data;
    }

    public int getI() {
        return i;
    }
}
