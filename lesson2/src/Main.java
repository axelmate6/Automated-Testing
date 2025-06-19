import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        {
//            printThreeWords();
//            checkSumSign();
//            printColor();
//            compareNumbers();
//            System.out.println(boolMethod(13,-12));
//            positiveCheck(12);
//            System.out.println(negativeCheck(-123));
//            stringPrinter("New", 12);
//            System.out.println(isLeapYear(11));
//            arrayChange();
//            arrayFill();
//            arrayMult();
//            doubleArrayDiag();
            System.out.println(Arrays.toString(arrayRet(15,3)));
        }
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -11;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 333;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 101;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static boolean boolMethod(int a, int b) {
        if (a + b >= 10) {
            if (a + b <= 20) {
                return true;
            }
        }
        return false;
    }

    public static void positiveCheck(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean negativeCheck(int a) {
        if (a < 0) {
            return true;
        }
        return false;
    }

    public static void stringPrinter(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static void arrayChange() {
        int[] a = {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0};
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void arrayFill() {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void arrayMult() {
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] = a[i] * 2;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void doubleArrayDiag() {
        int[][] a = new int[5][5];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == j || i + j == a[i].length - 1) {
                    a[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] arrayRet(int len, int initialValue){
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = initialValue;
        }
        return a;
    }
}