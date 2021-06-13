package reinforcementLearning;

import java.util.Random;

public class Learning extends Evaluation{
    private static final int x = config.x;
    private static final int n = config.n;
    private static final double r[][] = config.r;

    private static final double gamma=0.9; //������y

    private int step; //�ǉ��C�e�G�s�\�[�h�̃X�e�b�v���i�ړ������񐔁j
    private int s, next_s; //���݂̏��s�Ǝ����next_s
    private int a; //�y�g���z�I������s���ia=O�E�w�C a=1���ցCa=2��ցCa=3���ցj
    private double r_value; //�ǉ��C�����l
    private double maxQ; //Q�l�̍X�V�Ɏg������Ԃ̍ő�Q��
    private double Q[][]=new double [n][4];//0�`(x*y-1)�̏�Ԃɂ�����Q�l�oQ[x*(y-1)-2]�m�n�̓S�[���j

    public Learning(Variable var) {
        super(var);
        Random rr = new Random (031);
        final int episodes = var.getEpisodes();
        final double alpha = var.getAlpha();
        final double epsilon = var.getEpsilon();
        Q = super.getQ();

        for (int epi=0; epi <= episodes; epi++) {
            System.out.printf("%d/%d a:%f e:%f", epi, episodes, alpha, epsilon);
            s=next_s=11; //������Ԃ����11�ɕύX
            step=0; //�ǉ��C�X�e�b�v��
            while (true) { //�S�[���ɓ��B����܂ł�1�G�s�\�[�h�C�y�g���zwhile���̒��g���s�����̑����ɍ��킹�ďC��
                if (rr. nextDouble () <= epsilon) {//������E�ȉ��Ȃ烉���_���ɍs��
                    r_value = rr.nextDouble();
                    if(r_value<=(1.0/4.0)) a=0;//������1/4�ȉ��Ȃ�ΉE�ֈړ�
                    else if (r_value <= (2.0/4.0)) a=1;//������1/4����2/4�Ȃ�΍�
                    else if (r_value <= (3.0/4.0)) a=2;//������2/4����3/4�Ȃ�Ώ�
                    else a=3;//������3/4���傫����Ή���
                }
                else {
                    if(Q[s][0] >= Q[s][1] && Q[s][0] >= Q[s] [2] && Q[s][0] >= Q[s] [3] ) a=0;//�O���[�f�B����ōs��
                    else if (Q [s][1] >= Q[s][0] && Q [s][1] >= Q[s][2] && Q [s][1] >= Q[s][3]) a=1;
                    else if (Q [s][2] >= Q[s][0] && Q [s][2] >= Q[s][1] && Q [s][2] >= Q[s][3]) a=2;
                    else if (Q [s][3] >= Q[s][0] && Q [s][3] >= Q[s][1] && Q [s][3] >= Q[s][2]) a=3;
                    else { //Q�ɈႢ�̂Ȃ��Ƃ��̓����_����
                        r_value = rr.nextDouble();
                        if(r_value<=(1.0/4.0)) a=0;//������1/4�ȉ��Ȃ�ΉE�ֈړ�
                        else if (r_value <= (2.0/4.0)) a=1;//������1/4����2/4�Ȃ�΍�
                        else if (r_value <= (3.0/4.0)) a=2;//������2/4����3/4�Ȃ�Ώ�
                        else a=3;//������3/4���傫����Ή���
                    }
                }
                if (a==0) { //�i�s�������̏ꍇ�̎����next_s)
                    next_s=s+1;
                }
                else if(a==1){ //�o�s�������̏ꍇ�̎����next_s)
                    next_s=s-1;
                }
                else if(a==2) { //�i�s�������̏ꍇ�̎����next_s)
                    next_s=s+x;
                }
                else if(a==3) { //�i�s�������̏ꍇ�̎����next_s)
                    next_s=s-x;
                }
                maxQ = Q[next_s][0]; //�X�V���p��maxQ�̐���
                for(int j=1;j<4;j++){
                    if (Q [next_s][j] > maxQ) maxQ=Q[next_s][j];
                }
                Q [s][a] = Q[s][a] + alpha* (r[(int)(next_s/x)][next_s%x]+gamma*maxQ-Q [s][a]);//Q�l�̍X�V��
                step++; //�ǉ��C�X�e�b�v���𑝂₷
                if(r[(int)(next_s/x)][next_s%x]!=0) break; //�y�g���z�G�s�\�[�h�I��
                s=next_s; //���̎�����
            }
            // �������猋�ʕ\���p�̏���
            if (r[(int)(next_s/x)][next_s%x]>0.0){
                super.addStep_sum(step);
                super.addSuccess();
                if (super.getStep_min()>step) super.setStep_min(step);
                super.setQ(Q);
            }
            System.out.print("\r");
        }
    }
}