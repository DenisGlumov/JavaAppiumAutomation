import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber() {
        Assert.assertTrue("тест не пройден, возвращаемое число не равно 14", mainClass.getLocalNumber() == 14);
    }
}
