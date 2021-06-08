package reinforcementLearning;

import java.util.Scanner;

public class Variable {
    private int episodes;
    private double alpha;
    private double epsilon;

    public Variable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("episodes:");
        this.episodes = sc.nextInt();
        System.out.print("alpha:");
        this.alpha = sc.nextDouble();
        System.out.print("epsilon:");
        this.epsilon = sc.nextDouble();
    }

    public Variable(int episodes, double alpha, double epsilon) {
        this.episodes = episodes;
        this.alpha = alpha;
        this.epsilon = epsilon;
    }

    public int getEpisodes() {
        return this.episodes;
    }

    public double getAlpha() {
        return this.alpha;
    }

    public double getEpsilon() {
        return this.epsilon;
    }
}
