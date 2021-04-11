public class MainApp {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 6, 2, 4, 9, 7, 0};
        int[] arr2;

        arr2 = arrAfterFour(arr1);
        for (int i = 0; i < arr2.length ; i++) {
            System.out.println(arr2[i]);
        }

        int[] arr3 = {1, 4, 1, 4, 1};
        int[] arr4 = {1, 1, 1, 1, 1};
        int[] arr5= {4, 4, 4, 4, 4};
        int[] arr6 = {1, 4, 1, 3, 1};

        System.out.println(checkArrIsOneFour(arr3));
        System.out.println(checkArrIsOneFour(arr4));
        System.out.println(checkArrIsOneFour(arr5));
        System.out.println(checkArrIsOneFour(arr6));


    }

    public static int[] arrAfterFour(int[] arr) {
        int indexElFour = -1;
        int[] arrAfterFour;
        for (int i = arr.length - 1; i > -1 ; i--) {
            if (arr[i] == 4) {
                indexElFour = i;
                break;
            }
        }
        if (indexElFour == -1) {
            throw new RuntimeException("В массиве нет ни одной четверки");
        } else {
//            System.out.println(arr.length - indexElFour - 1);
//            System.out.println(indexElFour);
            arrAfterFour = new int[arr.length - indexElFour - 1];
            System.arraycopy(arr, indexElFour + 1, arrAfterFour,0 ,arr.length - indexElFour - 1);
        }
        return arrAfterFour;
//        System.out.println(indexElFour);
    }

    public static boolean checkArrIsOneFour(int[] arr) {
        boolean isOne = false;
        boolean isFour = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) isOne = true;
            if (arr[i] == 4) isFour = true;
        }
        return isOne && isFour;
    }
}
