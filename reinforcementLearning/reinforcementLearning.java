package reinforcementLearning;

public class reinforcementLearning {
    private static boolean importVariable = config.importVariable;
    private static PrintType printType = config.printType;
    private static final int episodes = config.episodes;
    private static final double alpha = config.alpha;
    private static final double epsilon = config.epsilon;

    public static void main(String[] args) {
        Variable var;

        if (importVariable) {
            var = new Variable();
        } else {
            var = new Variable(episodes, alpha, epsilon);
        }

        Evaluation eva = new Learning(var);
        Print p = new Print(var, eva);

        switch (printType) {
            case simple:
                p.SimplifiedDisplay();
                break;
            case file:
                p.File();
                break;
            case normal:
            default:
                p.normalDisplay();
                break;
        }
    }
}
