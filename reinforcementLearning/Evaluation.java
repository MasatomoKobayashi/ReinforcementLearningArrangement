package reinforcementLearning;

public class Evaluation extends Variable{
    private final static int n = config.n;

    private int episodes;
    private int success;
    private int step_sum;
    private int step_min;
    private double successRate;
    private double averageStep;
    private double Q[][]=new double [n][4];//0～(x*y-1)の状態におけるQ値｛Q[x*(y-1)-2]［］はゴール）

    public Evaluation(Variable var) {
        super(var.getEpisodes(), var.getAlpha(), var.getEpsilon());
        this.episodes = var.getEpisodes();
        this.success = 0;
        this.step_sum = 0;
        this.step_min = n;
        this.successRate = 0;
        this.averageStep = 0;
        for (int i=0; i < n; i++){
            Q[i][0]=Q[i][1]=Q[i][2]=Q[i][3]=0.00;//各状態の初期Q値はすべて0.0
        } //}}ゴール状態のQ値は常に0.0
    }

    public void addSuccess() {
        this.success ++;
        this.averageStep = (double)this.step_sum/(double)this.success;
        if (this.episodes != 0) this.successRate = (double)this.success/(double)this.episodes;
    }

    public int getSuccess() {
        return this.success;
    }

    public void addStep_sum(int step) {
        this.step_sum += step;
        if (this.success != 0) this.averageStep = (double)this.step_sum/(double)this.success;
    }

    public void setStep_min(int step_min) {
        this.step_min = step_min;
    }

    public int getStep_min() {
        return this.step_min;
    }

    public void setQ(double[][] q) {
        this.Q = q;
    }

    public double[][] getQ() {
        return this.Q;
    }

    public double getAverageStep() {
        return this.averageStep;
    }

    public double getSuccessRate() {
        return this.successRate;
    }
}
