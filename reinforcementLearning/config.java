package reinforcementLearning;

public class config {
    //Qtile�̐ݒ�
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

    //runOnce()�̐ݒ�
    public static final boolean once = false;
        //3�ϐ����͂��邩���Ȃ���
            public static final boolean importVariable = true;//3�ϐ����R�}���h�v�����v�g�������
            //public static final boolean importVariable = false;//3�ϐ���������擾
                public static final int episodes = 500000;
                public static final double alpha = 0.01;
                public static final double epsilon = 0.1;

        //�o�̓^�C�v(true:�o��, false:�o�͂��Ȃ�)
            public static final boolean normalOut = false;// (���ƂƓ����o��)
            public static final boolean simpleOut = true;// (�ȗ��\��)
            public static final boolean fileOut = false;// (CSV�o��)

    public static final boolean multi = true;
        public static final boolean Order = true;
        public static final boolean Random = false;
}
