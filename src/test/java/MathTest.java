import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MathTest {

    @Test
    void mathmin(){
        int actualmin = Math.min(1, 5);
        int expectedmin = 1;

        assertEquals(expectedmin, actualmin);
    }

    @Test
    void mathmax(){
        int actualmax = Math.max(2,5);
        int expectedmax = 5;

        assertEquals(expectedmax, actualmax);

    }

    @Test
    void testArraySort_RandomArray(){
        int[] numbers = {12,3,5,1};
        int[] expected = {1,3,5,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);

    }

    //exception
    @Test()
    void testArraySort_NullArray(){
        int[] numbers = null;
        Arrays.sort(numbers);

    }


    @Test
    @Disabled
    void testSort_Performance(){//check performance for methods
        int array[] = {12,23,4};
        assertTimeout(Duration.ofSeconds(5), () -> {
            for (int i=1; i<= 1000000; i++){
                array[0]=i;
                Arrays.sort(array);
                System.out.println(i);
            }

        });
    }
}
