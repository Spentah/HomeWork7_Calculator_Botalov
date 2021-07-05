import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Test {
    @Rule
    ExpectedException thrown = ExpectedException.none();

    @DataProvider
    public Object [][] positiveTestProvider() {
        return new Object[][]{
                {"4", "2", "2", "+"},
                {"-5", "5", "-10", "+"},
                {"15", "-3", "-5", "*"},
                {"-1", "-2", "-1", "-"},
                {"-6", "2", "-3", "*"},
                {"0", "0", "33", "/"}

        };
    }

    @org.testng.annotations.Test(dataProvider = "positiveTestProvider")
    public void positiveTest(String expected, String number1, String number2, String operation) {
        Calculator.calculation(number1,number2,operation);
        Assert.assertEquals(expected,Calculator.getResult());
    }

    @DataProvider
    public Object[][] negativeTestProvider(){
        return new Object[][]{
                {"Нельзя делить на ноль", "3", "0", "/"},
                {"Такая операция не предусмотрена", "23", "0", "="},
                {"Неверное значение", "o", "3", "+"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "negativeTestProvider")
    public void negativeTest(String expected, String number1, String number2, String operation) {
        Calculator.calculation(number1,number2,operation);
        Assert.assertEquals(expected,Calculator.getResult());

    }

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
    public void exceptionTest(){
        Calculator.calculation("666", "666", "*");
        Assert.assertEquals(RuntimeException.class, Calculator.getResult());
    }





}
