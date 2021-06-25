package calculator;
/*
  Конвертер для перевода римских чисел в арабские и обратно. Так же имеется булевый метод опеределяющий
  к какому семейству чисел относится данное число.
 */

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    HashMap<Integer, String> numbers = new HashMap<>();

    protected RomanNumbers() {
        numbers.put(1, "I");
        numbers.put(2, "II");
        numbers.put(3, "III");
        numbers.put(4, "IV");
        numbers.put(5, "V");
        numbers.put(6, "VI");
        numbers.put(7, "VII");
        numbers.put(8, "VIII");
        numbers.put(9, "IX");
        numbers.put(10, "X");
        numbers.put(20, "XX");
        numbers.put(30, "XXX");
        numbers.put(40, "XL");
        numbers.put(50, "L");
        numbers.put(60, "LX");
        numbers.put(70, "LXX");
        numbers.put(80, "LXXX");
        numbers.put(90, "XC");
        numbers.put(100, "C");
    }

    public static String convert(int i) {
        RomanNumbers rn = new RomanNumbers();
        if (i < 11) {
            return rn.numbers.get(i);
        } else if (i % 10 == 0) {
            return rn.numbers.get(i);
        } else {
            return (rn.numbers.get(i / 10 * 10) + rn.numbers.get(i % 10));
        }
    }

    public static int convert(String str) {
        RomanNumbers rn = new RomanNumbers();
        int result = 0;
        for (Map.Entry<Integer, String> entry :
                rn.numbers.entrySet()) {
            if (entry.getValue().equals(str)) {
                result = entry.getKey();
            }
        }
        return result;
    }

    public static boolean isRoman(String str) {
        RomanNumbers rn = new RomanNumbers();
        return rn.numbers.containsValue(str);
    }
}
