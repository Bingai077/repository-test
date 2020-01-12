package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test03_EnumExperice;

/**
 * @author bingai
 * @create 2019-11-05 10:18
 */
public class ColorTest1 {

    public static void main(String[] args) {

        Color1.BLUE.reflectColor();
    }
}


interface Works{
    void reflectColor();
}



enum Color1 implements Works{
    RED(255,0,0) {
        @Override
        public void reflectColor() {
            System.out.println("反射红光");
        }

        @Override
        void meaning() {
            System.out.println("代表红色");
        }
    },
    BLUE(0,0,255) {
        @Override
        public void reflectColor() {
            System.out.println("反射蓝光");
        }

        @Override
        void meaning() {
            System.out.println("代表蓝色");
        }
    },
    BLACK(0,0,0) {
        @Override
        public void reflectColor() {
            System.out.println("反射黑光");

        }

        @Override
        void meaning() {
            System.out.println("代表黑色");
        }
    },
    YELLOW(255,255,0) {
        @Override
        public void reflectColor() {
            System.out.println("反射黄光");

        }

        @Override
        void meaning() {
            System.out.println("代表黄色");
        }
    },
    GREEN(0,255,0) {
        @Override
        public void reflectColor() {
            System.out.println("反射绿光");
        }

        @Override
        void meaning() {
            System.out.println("代表绿色");
        }
    };

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color1(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    abstract void meaning();

    @Override
    public String toString() {
        return "Color{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                "} " + super.toString();
    }
}