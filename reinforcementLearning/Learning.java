package reinforcementLearning;

import java.util.Random;

public class Learning extends Evaluation{
    private static final int x = config.x;
    private static final int n = config.n;
    private static final double r[][] = config.r;

    private static final double gamma=0.9; //割引率y

    private int step; //追加，各エピソードのステップ数（移動した回数）
    private int s, next_s; //現在の状態sと次状態next_s
    private int a; //【拡張】選択する行動（a=O右ヘ， a=1左へ，a=2上へ，a=3下へ）
    private double r_value; //追加，乱数値
    private double maxQ; //Q値の更新に使う次状態の最大Q領
    private double Q[][]=new double [n][4];//0～(x*y-1)の状態におけるQ値｛Q[x*(y-1)-2]［］はゴール）

    public Learning(Variable var) {
        super(var);
        Random rr = new Random (031);
        final int episodes = var.getEpisodes();
        final double alpha = var.getAlpha();
        final double epsilon = var.getEpsilon();
        Q = super.getQ();

        for (int epi=0; epi <= episodes; epi++) {
            System.out.printf("%d/%d a:%f e:%f", epi, episodes, alpha, epsilon);
            s=next_s=11; //初期状態を状態11に変更
            step=0; //追加，ステップ数
            while (true) { //ゴールに到達するまでが1エピソード，【拡張】while文の中身を行動数の増加に合わせて修正
                if (rr. nextDouble () <= epsilon) {//乱数がE以下ならランダムに行動
                    r_value = rr.nextDouble();
                    if(r_value<=(1.0/4.0)) a=0;//乱数が1/4以下ならば右へ移動
                    else if (r_value <= (2.0/4.0)) a=1;//乱数が1/4から2/4ならば左
                    else if (r_value <= (3.0/4.0)) a=2;//乱数が2/4から3/4ならば上
                    else a=3;//乱数が3/4より大きければ下へ
                }
                else {
                    if(Q[s][0] >= Q[s][1] && Q[s][0] >= Q[s] [2] && Q[s][0] >= Q[s] [3] ) a=0;//グリーディ方策で行動
                    else if (Q [s][1] >= Q[s][0] && Q [s][1] >= Q[s][2] && Q [s][1] >= Q[s][3]) a=1;
                    else if (Q [s][2] >= Q[s][0] && Q [s][2] >= Q[s][1] && Q [s][2] >= Q[s][3]) a=2;
                    else if (Q [s][3] >= Q[s][0] && Q [s][3] >= Q[s][1] && Q [s][3] >= Q[s][2]) a=3;
                    else { //Qに違いのないときはランダムに
                        r_value = rr.nextDouble();
                        if(r_value<=(1.0/4.0)) a=0;//乱数が1/4以下ならば右へ移動
                        else if (r_value <= (2.0/4.0)) a=1;//乱数が1/4から2/4ならば左
                        else if (r_value <= (3.0/4.0)) a=2;//乱数が2/4から3/4ならば上
                        else a=3;//乱数が3/4より大きければ下へ
                    }
                }
                if (a==0) { //（行動が→の場合の次状態next_s)
                    next_s=s+1;
                }
                else if(a==1){ //｛行動が←の場合の次状態next_s)
                    next_s=s-1;
                }
                else if(a==2) { //（行動が↑の場合の次状態next_s)
                    next_s=s+x;
                }
                else if(a==3) { //（行動が↓の場合の次状態next_s)
                    next_s=s-x;
                }
                maxQ = Q[next_s][0]; //更新式用のmaxQの生成
                for(int j=1;j<4;j++){
                    if (Q [next_s][j] > maxQ) maxQ=Q[next_s][j];
                }
                Q [s][a] = Q[s][a] + alpha* (r[(int)(next_s/x)][next_s%x]+gamma*maxQ-Q [s][a]);//Q値の更新式
                step++; //追加，ステップ数を増やす
                if(r[(int)(next_s/x)][next_s%x]!=0) break; //【拡張】エピソード終了
                s=next_s; //次の時刻へ
            }
            // ここから結果表示用の処理
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