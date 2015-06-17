package format.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class Roman {

    /**
     * Method yang mengembalikan nilai dari sebuah karakter romawi kedalam bentuk arabic 
     * @param letter character yang akan diubah menjadi bentuk romawi
     * @return Mengembalikan bentuk romawi
     */
    private int decodeSingle(char letter) {
        switch (letter) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Method yang mengubah format input string romawi dan mengembalikan nilai arabic.
     * @param roman String dengan format romawi.
     * @return int dengan format arabic
     */
    public int RomanToArabic(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase(); //case-insensitive

        for (int i = 0; i < uRoman.length() - 1; i++) {//loop over all but the last character
            //if this character has a lower value than the next character
            if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
                //subtract it
                result -= decodeSingle(uRoman.charAt(i));
                
            } else {
                //add it
                result += decodeSingle(uRoman.charAt(i));
            }
            if(decodeSingle(uRoman.charAt(i)) == 0){
                    return 0;
            }
        }
        //decode the last character, which is always added
        result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
        return result;
    }
    
    public String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
          int matches = Int/entry.getValue();
          res += repeat(entry.getKey(), matches);
          Int = Int % entry.getValue();
        }
        return res;
      }
      public String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
      }
      
      /**
     * Method yang mengubah format input string arabic dan mengembalikan nilai
     * roman
     *
     * @param arabic bilangan arabic yang ingin diketahui nilainya dalam format
     * romawi
     * @return nilai bilangan arabic dalam format romawi
     */
    public String ArabicToRoman(int arabic) {
        int[] numbers = {1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"};

        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            while (arabic >= numbers[i]) {
                result += letters[i];
                arabic -= numbers[i];
            }
        }
        return result;
    }
}
