import java.util.Arrays;

public class ArrayAverage {
    public static void main(String[] args){

        String[] arr1 = {"1","2","3","4","5"};

        try {
            int[] arr = new int[arr1.length];
            for (int i = 0; i < arr1.length;i++){
                arr[i] = Integer.parseInt(arr1[i]);
            }
            int sum = 0;
            for(int i = 0; i <= arr1.length;i++)
                sum += arr[i];
            System.out.println(sum/arr.length);
            System.out.println(Arrays.toString(arr));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Out of Bounds");
        } catch (NumberFormatException e){
            System.out.println("Not a Num");
        }
    }
}


