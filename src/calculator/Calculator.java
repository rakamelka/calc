package calculator;

import java.util.Scanner;

public class Calculator {

    private static String calc(String str) throws CalculatorExceptions {

        Numbers numbers = Numbers.numsDefine(str);
        int result;
        if (str.contains("+")) {
            result = numbers.getA() + numbers.getB();
        } else if (str.contains("-")) {
            result = numbers.getA() - numbers.getB();
        } else if (str.contains("*")) {
            result = numbers.getA() * numbers.getB();
        } else {
            result = numbers.getA() / numbers.getB();
        }

        return numbers.isArabic() ? (result + "") : RomanNumbers.convert(result);
    }

    public static void calculate() {
        System.out.println("Консольное приложение \"Калькулятор\".");
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, " +
                "умножения и деления с двумя числами: a + b, a - b, a * b, a / b. " +
                "Данные передаются в одну строку.");
        System.out.println("Чтобы закончить вычисления напишите \"STOP\"");
        System.out.println("Введите пример:");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("stop")) {
                scanner.close();
                return;
            }
            System.out.println("Ответ: " + Calculator.calc(str));
            System.out.println("Следующий пример:");
        }
    }
}
