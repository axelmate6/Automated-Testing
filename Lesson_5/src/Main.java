
public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = {{"3", "5", "1", "2"},
                {"2", "5", "8", "10"},
                {"7", "3", "3", "2"},
                {"-3", "5", "5", "-1"}};
        System.out.println(arraySum(array));
        try {
            array[10][10] = "10";
            System.out.println(array[10][10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public static int arraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}