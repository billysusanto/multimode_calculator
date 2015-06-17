package checker;

public class StringChecker {
    public StringChecker(){
        
    }
    
    /**
     * Method untuk mengecek format numerik
     * @param s Variabel yang akan dicek
     * @return mengembalikan true jika input parameter berupa bilangan, dan false bila bukan bilangan
     */
    public static boolean isNumeric(String s) {
        try{  
          double d = Double.parseDouble(s);  
        }  
        catch(NumberFormatException nfe){  
          return false;  
        }  
        return true;  
    }
    
    /**
     * Method untuk mengecek format operator
     * @param s Variabel yang akan dicek
     * @return mengembalikan true jika input parameter berupa operator, dan false bila bukan operator
     */
    public static  boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^") || s.equals("x") || s.equals(":");
    }
    
    /**
     * Method untuk mengecek format logika
     * @param s Variabel yang akan dicek
     * @return mengembalikan true jika input parameter berupa true/false, dan false bila bukan true/false
     */
    public static boolean isTrueFalse(String s) {
        return s.matches("true|false");
    }
}
