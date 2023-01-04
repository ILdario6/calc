import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Dange {
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();
        System.out.print(calc(num));
    }

    public static String calc(String input) throws Dange {
        int[] numbersRim = perevodRim(input);
        int[] numbersArabic = perevodArabic(input);
        char[] read = znak1(input);
        int a = 0;
        String ok = null;
        int[] res = new int[1];
        for(int i = 0; i < numbersRim.length; i ++){
            if((numbersRim[i] > numbersArabic[i] && 0 < numbersArabic[i]) ||(numbersRim[i] < numbersArabic[i] && numbersRim[i] > 0)){
                throw new Dange("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        }
        if(numbersRim[0] > numbersArabic[0]) {
            for (int i = 0; i < numbersRim.length; i++) {
                if (numbersRim[i] < 1 && numbersRim[i] > 10 ) {
                    throw new Dange("Что то пошло не так");
                }
            }
            for (int i = 0; i < numbersRim.length; i = i + 2) {
                if (read[a] == '+') {
                    res[a] = numbersRim[i] + numbersRim[i + 1];
                    a++;
                } else if (read[a] == '-') {
                    res[a] = numbersRim[i] - numbersRim[i + 1];
                    a++;
                } else if (read[a] == '*') {
                    res[a] = numbersRim[i] * numbersRim[i + 1];
                    a++;
                } else if (read[a] == '/') {
                    res[a] = numbersRim[i] / numbersRim[i + 1];
                    a++;
                }
            }
            for(int var: res){
                if(var < 1){
                    throw new Dange("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
            }
            String[] res1Rim = new String[numbersRim.length - 1];
            for(int i = 0; i < res.length; i++){
                res1Rim[i] = IntegerConverter.intToRoman(res[i]);
            }
            ok = String.join(", ", res1Rim);
        }
        if(numbersRim[0] < numbersArabic[0]) {
            for (int i = 0; i < numbersArabic.length; i++) {
                if (numbersArabic[i] < 1 || numbersArabic[i] > 10 ) {
                    throw new Dange("Что то не так");
                }
            }
            for (int i = 0; i < numbersArabic.length; i = i + 2) {
                if (read[a] == '+') {
                    res[a] = numbersArabic[i] + numbersArabic[i + 1];
                    a++;
                } else if (read[a] == '-') {
                    res[a] = numbersArabic[i] - numbersArabic[i + 1];
                    a++;
                } else if (read[a] == '*') {
                    res[a] = numbersArabic[i] * numbersArabic[i + 1];
                    a++;
                } else if (read[a] == '/') {
                    res[a] = numbersArabic[i] / numbersArabic[i + 1];
                    a++;
                }
            }
            String[] lll = new String[res.length];
            for (int i = 0; i < res.length; i++) {
                lll[i] = String.valueOf(res[i]);
            }
            ok = String.join(", ", lll);
        }
        return ok;
    }

    static char[] znak1(String one) throws Dange {
        String[] num1 = one.split("[,.]");
        char[] op = new char[num1.length];
        int[] ap = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            if (num1[i].indexOf('+') > 0) {
                ap[i] = num1[i].indexOf('+');
            } else if (num1[i].indexOf('-') > 0) {
                ap[i] = num1[i].indexOf('-');
            } else if (num1[i].indexOf('*') > 0) {
                ap[i] = num1[i].indexOf('*');
            } else if (num1[i].indexOf('/') > 0) {
                ap[i] = num1[i].indexOf('/');
            }
        }
        for (int i = 0; i < num1.length; i++) {
            op[i] = num1[i].charAt(ap[i]);
        }
        if(op.length >= 2) {
            throw new Dange("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        }

        return op;
    }

    static int[] perevodRim(String num) throws Dange {
        String[] res1 = num.split("[ */+,.-]");
        String[] res2 = num.split("[-+*/,.]");
        int[] res = new int[res2.length];
        int a = 0;
        for (int i = 0; i < res1.length; i++) {
            if (res1[i].equals(Rim.I.toString())) {
                res[a] = 1;
                a++;
            } else if (res1[i].equals(Rim.II.name())) {
                res[a] = 2;
                a++;
            } else if (res1[i].equals(Rim.III.name())) {
                res[a] = 3;
                a++;
            } else if (res1[i].equals(Rim.IV.name())) {
                res[a] = 4;
                a++;
            } else if (res1[i].equals(Rim.V.name())) {
                res[a] = 5;
                a++;
            } else if (res1[i].equals(Rim.VI.name())) {
                res[a] = 6;
                a++;
            } else if (res1[i].equals(Rim.VII.name())) {
                res[a] = 7;
                a++;
            } else if (res1[i].equals(Rim.VIII.name())) {
                res[a] = 8;
                a++;
            } else if (res1[i].equals(Rim.IX.name())) {
                res[a] = 9;
                a++;
            } else if (res1[i].equals(Rim.X.name())) {
                res[a] = 10;
                a++;
            }
            if(res.length >= 3){
                throw new Dange("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        return res;
    }

    static int[] perevodArabic(String num) throws Dange {
        String[] res1 = num.split("[ */+,.-]");
        String[] res2 = num.split("[-+*/,.]");
        int[] res = new int[res2.length];
        int a = 0;
        for (int i = 0; i < res1.length; i++) {
            if (res1[i].equals("1")) {
                res[a] = 1;
                a++;
            } else if (res1[i].equals("2")) {
                res[a] = 2;
                a++;
            } else if (res1[i].equals("3")) {
                res[a] = 3;
                a++;
            } else if (res1[i].equals("4")) {
                res[a] = 4;
                a++;
            } else if (res1[i].equals("5")) {
                res[a] = 5;
                a++;
            } else if (res1[i].equals("6")) {
                res[a] = 6;
                a++;
            } else if (res1[i].equals("7")) {
                res[a] = 7;
                a++;
            } else if (res1[i].equals("8")) {
                res[a] = 8;
                a++;
            } else if (res1[i].equals("9")) {
                res[a] = 9;
                a++;
            } else if (res1[i].equals("10")) {
                res[a] = 10;
                a++;
            }
            if(res.length >= 3) {
                throw new Dange("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            }
        }
        return res;
    }
}
    class Dange extends Exception {
        public Dange(String danger) {
            super(danger);
        }
    }
class IntegerConverter {

    public static String intToRoman(int number) {
        if (number > 100 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(81, "XXCI");
        initMap.put(80, "XXC");
        initMap.put(72, "LXXII");
        initMap.put(70, "LXX");
        initMap.put(64, "LXIV");
        initMap.put(63, "LXIII");
        initMap.put(60, "LX");
        initMap.put(56, "LVI");
        initMap.put(54, "LIV");
        initMap.put(50, "L");
        initMap.put(49, "IL");
        initMap.put(48, "IIL");
        initMap.put(45, "VL");
        initMap.put(42, "XLII");
        initMap.put(40, "XL");
        initMap.put(36, "XXXVI");
        initMap.put(35, "XXXV");
        initMap.put(32, "XXXII");
        initMap.put(30, "XXX");
        initMap.put(28, "XXVIII");
        initMap.put(27, "XXVII");
        initMap.put(25, "XXV");
        initMap.put(24, "XXIV");
        initMap.put(21, "XX");
        initMap.put(20, "XX");
        initMap.put(18, "XVIII");
        initMap.put(17, "XVII");
        initMap.put(16, "XVI");
        initMap.put(15, "XV");
        initMap.put(14, "XIV");
        initMap.put(13, "XIII");
        initMap.put(12, "XII");
        initMap.put(11, "XI");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(8, "VIII");
        initMap.put(7, "VII");
        initMap.put(6, "VI");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(3, "III");
        initMap.put(2, "II");
        initMap.put(1, "II");
        units = Collections.unmodifiableNavigableMap(initMap);
    }
}