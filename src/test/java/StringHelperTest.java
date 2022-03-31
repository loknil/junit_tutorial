import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {

    StringHelper helper;

    @BeforeEach
    void before(){
        helper = new StringHelper();
    }


    @Test
    void testTruncateAInFirst2Positions_Ainfirst2Positions(){//name test after what it is doing, test_condition
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    void testTruncateAInFirst2Positions_AinFirstPosition(){//name test after what it is doing, test_condition
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_false(){
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));//check if input is false
    }
    @Test
    void testAreFirstAndLastTwoCharactersTheSame_true(){
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));//check if input is false
    }

    @ParameterizedTest
    @CsvSource(value= {"AACD, CD","ACD, CD"})
    void checkFirstAndLastTwoCharacters(String actual, String expected){
        assertEquals(expected, helper.truncateAInFirst2Positions(actual));
    }

}
