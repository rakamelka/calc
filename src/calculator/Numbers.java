package calculator;

/*
 * Класс позволяющий получить из подходящей строки два числа, для дальнейших математических операций.
 * Имеется флаг, определяющий принадлежность чисел к семейству арабских или римских чисел.
 * Все проверки вводимых данных проводятся на данном этапе. В случае некорректно введенных данных будут
 * выброшены созданные для этого Калькулятора исключения.
 */

class Numbers {
    private int a;
    private int b;
    private boolean arabic;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public boolean isArabic() {
        return arabic;
    }

    public static Numbers numsDefine(String str) throws CalculatorExceptions {
        Numbers result = new Numbers();
        String[] numbers = str.replaceAll("\\s+", "").split("\\+|-|\\*|/");

        if (numbers.length > 2 || numbers.length == 1) {
            throw new IneligibleInputException("Неподходящие данные");
        }

        try {
            result.a = Integer.parseInt(numbers[0]);
            result.b = Integer.parseInt(numbers[1]);
            result.arabic = true;
        } catch (NumberFormatException e) {
            if (RomanNumbers.isRoman(numbers[0]) && RomanNumbers.isRoman(numbers[1])) {
                result.a = RomanNumbers.convert(numbers[0]);
                result.b = RomanNumbers.convert(numbers[1]);
                result.arabic = false;
            } else if (RomanNumbers.isRoman(numbers[0]) ^ RomanNumbers.isRoman(numbers[1])) {
                throw new DifferentNumbersException("Разные форматы чисел");
            } else {
                throw new IneligibleInputException("Неподходящие данные");
            }
        }

        if (result.a > 10 || result.a < 1 || result.b > 10 || result.b < 1) {
            throw new WrongNumbersException("Слишком большие(маленькие) числа");
        }

        return result;
    }
}
