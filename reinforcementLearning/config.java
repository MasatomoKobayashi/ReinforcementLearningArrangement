package reinforcementLearning;

public class config {
    //Qtileの設定
        public static final int x = 10;
        public static final int y = 9;
        public static final int n = x * y;
        public static final double r[][]={{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0,-1.0,-1.0, 0.0,-1.0,-1.0,-1.0},
            {-1.0, 0.0, 0.0,-1.0, 0.0, 0.0, 0.0,-1.0, 1.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0, 0.0,-1.0,-1.0,-1.0, 0.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0, 0.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0}};

    //runOnce()の設定
    public static final boolean once = false;
        //3変数入力するかしないか
            public static final boolean importVariable = true;//3変数をコマンドプロンプトから入力
            //public static final boolean importVariable = false;//3変数を下から取得
                public static final int episodes = 500000;
                public static final double alpha = 0.01;
                public static final double epsilon = 0.1;

        //出力タイプ(true:出力, false:出力しない)
            public static final boolean normalOut = false;// (授業と同じ出力)
            public static final boolean simpleOut = true;// (簡略表示)
            public static final boolean fileOut = false;// (CSV出力)

    public static final boolean multi = true;
        public static final boolean Order = true;
        public static final boolean Random = false;
}
