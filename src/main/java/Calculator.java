import java.util.Scanner;

public class Calculator {
    private static String result;

    public static String getResult() {
        return result;
    }

    public static int sum(int num1, int num2) {
        return num1 +  num2;
    }

    public static int multiply(int num1, int num2) {
        if (num1==666 && num2==666) throw new RuntimeException("Побойся бога!");
        return num1 * num2;
    }

    public static int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    public static int division(int num1, int num2) {
        return num1 / num2;
    }

    public static void calculation(String num1, String num2, String operation) {
        int firstNumber = 0;
        int secondNumber = 0;
        try {
            firstNumber = Integer.parseInt(num1);
            secondNumber = Integer.parseInt(num2);
            int result = 0;
        } catch (NumberFormatException e) {
            result = "Неверное значение";
            return;
        }
        switch (operation) {
            case "+" :
                result = sum(firstNumber, secondNumber) + "";
                break;
            case "-" :
                result = subtraction(firstNumber, secondNumber) + "";
                break;
            case  "*" :
                result = multiply(firstNumber, secondNumber) + "";
                break;
            case "/" :
                if (secondNumber==0) {
                    result = "Нельзя делить на ноль";
                    return;
                }
                 result = division(firstNumber, secondNumber) + "";
                break;
            default :
                 result = "Такая операция не предусмотрена";
        } System.out.println("Результат вычисления калькулятора: " + getResult());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int number1 = 0;
//        int number2 = 0;
        System.out.println("Введите операцию");
        String operation = scan.nextLine();
        System.out.println("Введите первое число");
        String number1 = scan.nextLine();
        System.out.println("Введите второе число");
        String number2 = scan.nextLine();

        try {
            calculation(number1, number2, operation);
        } catch (NullPointerException e) {
            System.out.println("Введены некорректные данные");
        }

    }

}
