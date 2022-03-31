import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class StringTest {

    private String str;

    /*
    @BeforeAll//should be a static, run only once
    static void beforeAll(){
        System.out.println("Initialize connection to database");
    }

    @AfterAll//should be static, run only once
    static void afterAll(){
        System.out.println("Close connection to database");
    }*/

    @BeforeEach
    void beforeEach(TestInfo info){
        System.out.println("Initialize Test Data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info){
        System.out.println("Clean up Test Data for " + info.getDisplayName());
    }


    @Test
    @Disabled//disable test, does not run
    void length_basic(){
        int actuallength = "ABCD".length();
        int expectedLength = 4;

        assertEquals(expectedLength, actuallength);
        //Assert length == 4
        //Write test code
        //Invoke method
        //Checks in place
    }


    @ParameterizedTest(name = "{0} capitalized is {1}")//same test, different values
    @CsvSource(value= {"abcd, ABCD","abc, ABC","'', ''","abcdefg, ABCDEFG"})
    void uppercase(String word, String capitalizedWord){
        assertEquals(capitalizedWord, word.toUpperCase());

    }

    @ParameterizedTest//same test with different values
    @ValueSource(strings= {"ABCD", "ABC", "A", "DEF"})//gives values?
    void lengthGreaterThanZeroParameterized(String str){
        assertTrue(str.length()>0);
    }

    @ParameterizedTest
    @CsvSource(value = {"abcd, 4", "abcdef, 6", "a, 1"})
    void checkStringlength(String str, int length){
        assertEquals(length, str.length());
    }



    @Test()
    @DisplayName("When length is null, throw an exception")//name for test
    void length_exception(){
        String str = null;
        assertThrows(NullPointerException.class,
                () -> {//lambda expression?
                    str.length();
                }
                );

    }


    @Test
    void toUpperCase_basic(){
        String str = "abcd";
        String result = str.toUpperCase();

        assertNotNull(result);//Check if not null
        //assertNull(result);//Check if not null
        assertEquals("ABCD", result);
    }

    @Test
    @RepeatedTest(10)//repeat test 10 times
    void contains_basic(){
        //assertEquals(false, result);
        assertFalse("abcdefg".contains("ijk"));
    }

    @Test
    void split_basic(){
        String str = "abc def ghi";
        String[] actualresult = str.split(" ");
        String[] expectedresult = new String[] {"abc", "def", "ghi"};

        assertArrayEquals(expectedresult, actualresult);
    }

    @Test
    @Disabled
    void performanceTest(){//check performance for methods
        assertTimeout(Duration.ofSeconds(5), () -> {
                    for(int i=0; i<=1000000; i++){
                        int j=i;
                        System.out.println(j);
                    }

                });
    }

    @Nested
    class EmptyStringTests {

        @BeforeEach
        void setToEmpty(){
            str = "";
        }

        @Test
        void lengthIsZero() {
            assertEquals(0, str.length());
        }

        @Test
        void uppercaseIsEmpty() {
            assertEquals("", str.toUpperCase());
        }

    }
}
