package reinforcementLearning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Print {
    private final int x = config.x;
    private final int y = config.y;
    private final int n = config.n;
    private final double r[][] = config.r;

    private int Episodes;
    private int Success;
    private int step_min;
    private double Alpha;
    private double Epsilon;
    private double SuccessRate;
    private double AverageStep;
    private double Q[][];

    public Print(Variable var, Evaluation eva) {
        this.Episodes = var.getEpisodes();
        this.Success = eva.getSuccess();
        this.step_min = eva.getStep_min();
        this.Alpha = var.getAlpha();
        this.Epsilon = var.getEpsilon();
        this.SuccessRate = eva.getSuccessRate();
        this.AverageStep = eva.getAverageStep();
        this.Q = eva.getQ();
    }

    public void SimplifiedDisplay() {
        System.out.printf("episodes:%d, alpha:%f, epsilon:%f\n", Episodes, Alpha, Epsilon);
        if (Success >0) {
            System.out.printf("Success rate:%f, Ave step:%f, Minimum step:%d\n", SuccessRate, AverageStep, step_min);
        } else {
            System.out.printf("Success rate:%f\n", SuccessRate);
        }
    }

    public void File() {
        try {
            FileWriter file = new FileWriter("combination.csv", true);
            PrintWriter pw = new PrintWriter(new BufferedWriter(file));

            pw.println(Episodes + "," + Alpha + "," + Epsilon + "," + SuccessRate + "," + AverageStep + "," + step_min);
            pw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void normalDisplay() {
        System.out.println("==="+Episodes+"�G�s�\�[�h�w�K�I����̍s�����l�֐�===");
        for(int i=0;i < n;i++) {
            System.out.printf("Q{s"+i+", ��)=%4.3f", Q[i][0]);
            System.out.printf(", Q(s"+i+", ��)=%4.3f", Q [i][1]);
            System.out.printf(", Q(s"+i+"�C��) =%4.3f", Q[i][2]);
            System.out.printf(", Q(s"+i+"�C��) =%4.3f\n", Q[i][3]);
        }
        //�������猋�ʕ\���p�����C�^�C���Ɋ��蓖�Ă���Ԕԍ���\��
        System.out.println(" �\ �\ �\ �\ �\ �\ �\ �\ �\ �\ ");
        for (int i=y-1; i >= 0; i--){
            System.out.print("|");
            for (int j=0; j < x; j++){
                System.out.printf("%2d|",i*x+j);
            }
            System.out.print("\n");
            System.out.println(" �\ �\ �\ �\ �\ �\ �\ �\ �\ �\ ");
        }
        //�����܂Ō��ʕ\���p�����C�^�C���Ɋ��蓖�Ă���Ԕԍ���\��

        //�������猋�ʕ\���p�����C�e��Ԃɂ����čł�Q�l���傫���s����\��
        System.out.println(" �\ �\ �\ �\ �\ �\ �\ �\ �\ �\ ");
        for (int i=y-1; i >= 0; i--){
            System.out.print("|");
            for (int j=0; j < x; j++){
                if (r[i][j]==0.0){
                    if(      Q[i*x+j][0] > Q[i*x+j][1] && Q[i*x+j][0] > Q[i*x+j][2] && Q[i*x+j][0] > Q[i*x+j][3]) System.out.print("��|");
                    else if (Q[i*x+j][1] > Q[i*x+j][0] && Q[i*x+j][1] > Q[i*x+j][2] && Q[i*x+j][1] > Q[i*x+j][3]) System.out.print("��|");
                    else if (Q[i*x+j][2] > Q[i*x+j][0] && Q[i*x+j][2] > Q[i*x+j][1] && Q[i*x+j][2] > Q[i*x+j][3]) System.out.print("��|");
                    else if (Q[i*x+j][3] > Q[i*x+j][0] && Q[i*x+j][3] > Q[i*x+j][1] && Q[i*x+j][3] > Q[i*x+j][2]) System.out.print("��|");
                    else System.out.print("  |");
                }
                else
                    System.out.printf("%2.0f|",r[i][j]);
            }
            System.out.print("\n");
            System.out.println(" �\ �\ �\ �\ �\ �\ �\ �\ �\ �\ ");
        }
        //�����܂Ō��ʕ\���p�����C�e��Ԃɂ����čł�Q�l���傫���s����\��

        //�������猋�ʕ\���p�����C�����񐔂�X�e�b�v����\��
        if (Success>0)
            System.out.printf("Success rate:%f, Ave step:%f, Minimum step:%d\n", SuccessRate, AverageStep, step_min);
        else
            System.out.printf("Success rate:%f\n", SuccessRate);
        //�����܂Ō��ʕ\���p�����C�����񐔂�X�e�b�v����\��
    }
}
