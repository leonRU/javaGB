package lesson2;

public class Main {

    public static void main(String[] args) {
        String[][] a = {{"1" , "2"},{"3", "4"} };

        String[][] b = {{"1" , "2", "3", "4"},
                        {"1" , "2", "3", "4"},
                        {"1" , "a", "3", "4"},
                        {"1" , "2", "3", "4"} };


        String[][] c = {{"1" , "1", "1", "1"},
                        {"1" , "1", "1", "1"},
                        {"1" , "1", "1", "1"},
                        {"1" , "1", "1", "1"} };

        try{
            System.out.println(func(a));
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        } catch(Exception e){
            System.out.println("something went wrong");
        }
    }

    public static int func(String [][] array) throws MyArraySizeException, MyArrayDataException {
        if(!(array.length == 4 && array[0].length == 4 && array[1].length == 4 && array[2].length == 4 && array[3].length == 4))
            throw new MyArraySizeException("Wrong array size.");
        else{
            int i, j, sum = 0;
            for (i = 0 ;i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    }catch (NumberFormatException ex){
                        throw new MyArrayDataException("Wrong element in cell (" + ++i + ", " + ++j + ").");
                    }
                }
            }
            return sum;
        }
    }
}
