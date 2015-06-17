package convert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Converter {
    ConvertOperator convertOperator;
    
    List <String> checkKali = new ArrayList <> ();
    List <String> checkBagi = new ArrayList <> ();
    List <String> checkTambah = new ArrayList <> ();
    List <String> checkKurang = new ArrayList <> ();
    List <String> checkDiv = new ArrayList <> ();
    List <String> checkMod = new ArrayList <> ();
    List <String> checkAnd = new ArrayList <> ();
    List <String> checkOr = new ArrayList <> ();
    List <String> checkNot = new ArrayList <> ();
    
    /**
     * Konstraktor kelas Converter
     * @param convertOperator 
     */
    public Converter(ConvertOperator convertOperator){
        this.convertOperator = convertOperator;
        checkKali = convertOperator.getOperatorKali();
        checkBagi = convertOperator.getOperatorBagi();
        checkTambah = convertOperator.getOperatorTambah();
        checkKurang = convertOperator.getOperatorKurang();
        checkDiv = convertOperator.getOperatorDiv();
        checkMod = convertOperator.getOperatorMod();
        checkAnd = convertOperator.getOperatorAnd();
        checkOr = convertOperator.getOperatorOr();
        checkNot = convertOperator.getOperatorNot();
    }
    
    /**
     * Method yang berfungsi untuk mengubah ekspresi infix menjadi prefix
     * @param str string input dengan format infix yang akan diubah menjadi bentuk prefix
     * @return mengembalikan ekspresi dalam bentuk prefix
     */
    public static String InfixToPreFix(String str){
        Stack stack = new Stack();
        String prefix = "";
        int counter = 0;
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                prefix = ((Character)c).toString() + prefix;  
                counter = 0;
            }
            else if(c == '('){
                if(counter == 0 && !prefix.equals("")){
                    prefix = " " + prefix;
                    counter = 1;
                }
                counter = 0;
                prefix = ((Character)stack.pop()).toString() + prefix;
                
            }
            else if(c == ')'){
                if(counter == 0 && !prefix.equals("")){
                    prefix = " " + prefix;
                    counter = 1;
                }
                //counter = 0;
                //continue;
            }
            else{
                if(c != ' '){
                    if(counter == 0 && !prefix.equals("")){
                        prefix = " " + prefix;
                        counter = 1;
                    }
                    stack.push(c);
                }
            }
        }
        return prefix;
    }
    
    /**
     * Method yang berfungsi untuk mengubah ekspresi dalam bentuk format postfix menjadi bentuk infix
     * @param strInfixExp string dalam format postfix yang akan diubah menjadi format infix
     * @return Mengembalikan string hasil perubahan dalam bentuk infix
     */
    public String PostfixToInfix(String strInfixExp) 
    { 
        Stack<String> _stack = new Stack<String>();
        String[] strArgs = strInfixExp.split(" "); 
        for (int i = 0; i < strArgs.length; i++) { 
            String str = strArgs[i]; 
            if (!IsOperator(str)){ 
                _stack.push(str);
            }
            else 
            { 
                String arg2 = _stack.pop(); 
                String arg1 = _stack.pop(); 
                _stack.push("("+arg1 + str + arg2+")");
            } 
        }

        String strInfix = ""; 
        for (int i = 0; i < _stack.size(); i++) { 
            strInfix = strInfix + _stack.pop(); 
            
        } 
        return strInfix; 
    } 

    /**
     * Method yang berfungsi untuk mengecek input berupa operator
     * @param str string yang akan dicek
     * @return mengembalikan true bila string input berupa operator aritmatika, dan false bila bukan operator aritmatika
     */
    private boolean IsOperator(String str) {
        if(str.equalsIgnoreCase(checkKali.get(checkKali.size()-1))){
            str = "*";
        }
        else if(str.equalsIgnoreCase(checkBagi.get(checkBagi.size()-1))){
            str = "/";
        }
        else if(str.equalsIgnoreCase(checkTambah.get(checkTambah.size()-1))){
            str = "+";
        }
        else if(str.equalsIgnoreCase(checkKurang.get(checkKurang.size()-1))){
            str = "-";
        }
        else if(str.equalsIgnoreCase(checkDiv.get(checkDiv.size()-1))){
            str = "/";
        }
        else if(str.equalsIgnoreCase(checkMod.get(checkMod.size()-1))){
            str = "%";
        }
        else if(str.equalsIgnoreCase(checkAnd.get(checkAnd.size()-1))){
            str = "AND";
        }
        
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("x") || str.equals(":"); 
    }
}
