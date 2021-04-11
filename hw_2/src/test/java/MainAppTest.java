import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {
    MainApp mainApp;
    @AfterEach
    void tearDown() {
    }

    @BeforeEach
    void init () {
        mainApp = new MainApp();
    }

//    @CsvSource({
//            ""1, 2, 6, 2, 4, 9, 7, 0", "9, 7, 0""
//
//    })
  /



//    @ParameterizedTest
//    void arrAfterFour1(int[] arrIn, int[] arrOut) {
//
//        Assertions.assertArrayEquals(arrOut, mainApp.arrAfterFour(arrIn));
//    }

    @Test
    void arrAfterFour1() {
        int[] arrIn1 = {1, 2, 6, 2, 4, 9, 7, 0};
        int[] arrOut1 = {9, 7, 0};

        Assertions.assertArrayEquals(arrOut1, mainApp.arrAfterFour(arrIn1));
    }

    @Test
    void arrAfterFour2() {
        int[] arrIn1 = {1, 2, 6, 2, 4, 9, 7, 4};
        int[] arrOut1 = {};

        Assertions.assertArrayEquals(arrOut1, mainApp.arrAfterFour(arrIn1));

    }

    @Test
    void arrAfterFour3() {
        int[] arrIn1 = {1, 2, 6, 3, 9, 7};

        try {
            mainApp.arrAfterFour(arrIn1);
        } catch (RuntimeException e) {
            return;
        }
        Assertions.fail("Метод arrAfterFour() не выбросил ожидаемое RuntimeException исключение");


    }



//    @CsvSource({
//            "1, 4, 1, 4, 1"
//    })
//    @ParameterizedTest
//    void checkArrIsOneFour1(int[] arr) {
//        Assertions.assertTrue(mainApp.checkArrIsOneFour(arr));
//    }



    @Test
    void checkArrIsOneFour1() {
        int[] arr3 = {1, 4, 1, 4, 1};
        Assertions.assertTrue(mainApp.checkArrIsOneFour(arr3));
    }
    @Test
    void checkArrIsOneFour2() {
        int[] arr4 = {1, 1, 1, 1, 1};
        Assertions.assertTrue(mainApp.checkArrIsOneFour(arr4));
    }
    @Test
    void checkArrIsOneFour3() {
        int[] arr6 = {1, 4, 1, 3, 1};
        Assertions.assertTrue(mainApp.checkArrIsOneFour(arr6));
    }





}