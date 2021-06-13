package reinforcementLearning;

public class reinforcementLearning {

    public static void main(String[] args) {
        //àÍâÒé¿çs
        if (config.once) runOnce();

        //ï°êîâÒé¿çs
        if (config.multi) {
            RLRL.firstRLRL();
            if (config.Random) {
                while (true) {
                    RLRL.nextRandomRLRL();
                }
            }
            if (config.Order) {
                boolean bo = true;
                while (bo) {
                    bo = RLRL.nextOrderRLRL();
                }
            }
        }
    }

    private static void runOnce() {
        Variable var;
        final boolean importVariable = config.importVariable;
        final int episodes = config.episodes;
        final double alpha = config.alpha;
        final double epsilon = config.epsilon;
        final boolean normal = config.normalOut;
        final boolean simple = config.simpleOut;
        final boolean file = config.fileOut;

        if (importVariable) {
            var = new Variable();
        } else {
            var = new Variable(episodes, alpha, epsilon);
        }

        Evaluation eva = new Learning(var);

        Print.setData(eva);
        if (normal) Print.NormalDisplay();
        if (simple) Print.SimplifiedDisplay();
        if (file) Print.File("combination.csv");
    }
}
