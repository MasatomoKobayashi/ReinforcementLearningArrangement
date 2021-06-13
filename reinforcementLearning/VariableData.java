package reinforcementLearning;

import java.util.ArrayList;

public class VariableData extends Print{
    private ArrayList<ArrayList<Double>> Data;
    private String fileName;

    public VariableData(String fileName) {
        this.fileName = fileName;
        readFile rf = new readFile(fileName);
        Data = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<String>> stringData = rf.getData();
        int i = rf.getI();
        for (int j = 1; j < i; j++) {
            ArrayList<Double> tempDatum = new ArrayList<Double>();
            for (int k = 0; k < 3; k++) {
                tempDatum.add(Double.parseDouble(stringData.get(j).get(k)));
            }
            Data.add(tempDatum);
        }
    }

    public void addData(Variable var) {
        ArrayList<Double> tempDatum = new ArrayList<Double>();
        tempDatum.add((double) var.getEpisodes());
        tempDatum.add(var.getAlpha());
        tempDatum.add(var.getEpsilon());
        Data.add(tempDatum);
        Print.File(fileName);
    }

    public boolean isDataExistence(Variable var) {
        int i = Data.size();
        for (int j = 0; j < i; j++) {
            int flag = 0;
            if (Data.get(j).get(0) == (double) var.getEpisodes()) flag++;
            if (Data.get(j).get(1) == var.getAlpha()) flag++;
            if (Data.get(j).get(2) == var.getEpsilon()) flag++;
           if (flag == 3) return true;
        }
        return false;
    }
}

