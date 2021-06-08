package reinforcementLearning;

public class config {
    public static final int x = 10;
    public static final int y = 9;
    public static final int n = x * y;
    public static final double gamma=0.9; //割引率y
    public static final double r[][]={{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0,-1.0,-1.0, 0.0,-1.0,-1.0,-1.0},
            {-1.0, 0.0, 0.0,-1.0, 0.0, 0.0, 0.0,-1.0, 1.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0, 0.0,-1.0,-1.0,-1.0, 0.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0, 0.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0}};

    //以下はどっちかを選択
    public static final boolean importVariable = false;//3変数を下から入力
        public static final int episodes = 500000;
        public static final double alpha = 0.01;
        public static final double epsilon = 0.1;
    //public static final boolean importVariable = true;//3変数をコマンドプロンプトから入力

    //以下は1つ選択
    public static final PrintType printType = PrintType.normal;//出力タイプ：授業と同じ
    //public static PrintType printType = PrintType.simple;//簡略表示
    //public static PrintType printType = PrintType.file;//簡略表示の内容をCSVに出力
}
