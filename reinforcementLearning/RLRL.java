package reinforcementLearning;

import java.util.Random;

public class RLRL {
    private static final double seimitusa = 0.0001;
    private static Variable var;
    private static Evaluation eva;
    private static VariableData bad;
    private static VariableData excellence;
    private static VariableData combination;
    private static int alpha = 0;
    private static int epsilon = 0;
    private static double o[][] = new double[10][1];
    private static double varEva;

    public static void firstRLRL() {
        //bad = new VariableData("bad.csv");
        excellence = new VariableData("excellence.csv");
        combination = new VariableData("combination.csv");
        var = new Variable(50000, 0.0001, 0.06571466);
        for (int i = 0; i < 10; i++) {
            o[i][0] = 0;
        }
    }

    public static boolean nextOrderRLRL() {
        if (varOrderChange()) {
            eva = new Learning(var);
            varEva = varEva();
        }
        //if (alpha*epsilon == 1/seimitusa*0.3/seimitusa) return false;
        if (var.getEpsilon() == 0.065715) return false;
        return true;
    }

    public static void nextRandomRLRL() {
        eva = new Learning(var);
        varRandomChange();
    }

    private static void varRandomChange() {
        Random rr = new Random();
        varEva = varEva();
        if (varEva > 3) {
            while (excellence.isDataExistence(var)) {
                var.setAlpha(eva.getAlpha() + seimitusa * rr.nextInt((int)(1/seimitusa - eva.getAlpha()*1/seimitusa)));
                var.setEpsilon(eva.getEpsilon() - seimitusa * rr.nextInt((int)(0.3/seimitusa - eva.getEpsilon()*0.3/seimitusa)));
            } return;
        }
        while(combination.isDataExistence(var)) {
            var.setAlpha(seimitusa + seimitusa * rr.nextInt((int)(1/seimitusa - 1)));
            var.setEpsilon(seimitusa + seimitusa * rr.nextInt((int)(0.3/seimitusa - 1)));
        }
    }

    private static boolean varOrderChange() {
        if (var.getEpisodes() != 50000) var.setEpisodes(50000);
        if (var.getEpsilon() != 0.06571466) var.setEpsilon(0.06571466);
        var.setAlpha(var.getAlpha() + seimitusa);
        return true;
        /*if (alpha != 1/seimitusa) {
            alpha++;
            var.setAlpha(seimitusa * alpha);
            var.setEpsilon(seimitusa * epsilon);
        } else if (epsilon != 0.3/seimitusa) {
            alpha = 1;
            epsilon++;
            var.setAlpha(seimitusa * alpha);
            var.setEpsilon(seimitusa * epsilon);
        } return !combination.isDataExistence(var);*/
    }

    private static double varEva() {
        Print.setData(eva);
        combination.addData(eva);
        if (eva.getSuccessRate() == 0) {
            //bad.addData(eva);
            return 0;
        }
        double varEva = (eva.getSuccessRate() * 2) + (13.6 / eva.getAverageStep()) + (13 / eva.getStep_min());
        if (varEva > 3) {
            excellence.addData(eva);
        }
        return varEva;
    }
}