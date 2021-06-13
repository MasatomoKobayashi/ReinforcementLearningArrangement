package reinforcementLearning;

import java.util.Scanner;

public class Variable {
    private int episodes;
    private double alpha;
    private double epsilon;

    public Variable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("episodes:");
        setEpisodes(sc.nextInt());
        System.out.print("alpha:");
        setAlpha(sc.nextDouble());
        System.out.print("epsilon:");
        setEpsilon(sc.nextDouble());
    }

    public Variable(int episodes, double alpha, double epsilon) {
        setEpisodes(episodes);
        setAlpha(alpha);
        setEpsilon(epsilon);
    }

    public void setEpisodes(int episodes) {
        if (episodes < 0) episodes = 0;
        this.episodes = episodes;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setAlpha(double alpha) {
        if (alpha < 0) alpha = 0;
        if (alpha > 1) alpha = 1;
        this.alpha = alpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setEpsilon(double epsilon) {
        if (epsilon < 0) epsilon = 0;
        if (epsilon > 0.3) epsilon = 0.3;
        this.epsilon = epsilon;
    }

    public double getEpsilon() {
        return epsilon;
    }
}
