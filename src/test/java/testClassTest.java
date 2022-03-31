import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testClassTest {

    @Test
    void printingWorld(){
        testClass hello = new testClass();
        System.out.println(hello.printHello());
    }
}