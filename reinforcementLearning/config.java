package reinforcementLearning;

public class config {
    public static final int x = 10;
    public static final int y = 9;
    public static final int n = x * y;
    public static final double gamma=0.9; //������y
    public static final double r[][]={{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0,-1.0,-1.0, 0.0,-1.0,-1.0,-1.0},
            {-1.0, 0.0, 0.0,-1.0, 0.0, 0.0, 0.0,-1.0, 1.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0, 0.0,-1.0,-1.0,-1.0, 0.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0, 0.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0, 0.0,-1.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,-1.0},
            {-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0}};

    //�ȉ��͂ǂ�������I��
    public static final boolean importVariable = false;//3�ϐ������������
        public static final int episodes = 500000;
        public static final double alpha = 0.01;
        public static final double epsilon = 0.1;
    //public static final boolean importVariable = true;//3�ϐ����R�}���h�v�����v�g�������

    //�ȉ���1�I��
    public static final PrintType printType = PrintType.normal;//�o�̓^�C�v�F���ƂƓ���
    //public static PrintType printType = PrintType.simple;//�ȗ��\��
    //public static PrintType printType = PrintType.file;//�ȗ��\���̓��e��CSV�ɏo��
}
