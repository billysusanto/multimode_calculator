package calculator;

import checker.StringChecker;
import convert.ConvertOperator;
import java.util.List;
import java.util.Stack;

public class Calculator {
    
    Stack <Double> st = new Stack <Double> ();
    StringChecker stringChecker;
    ConvertOperator convertOperator;
    boolean hasBoolean = false;
    
    /**
     * Konstraktor Operator
     * @param convertOperator 
     */
    public Calculator(ConvertOperator convertOperator){
        stringChecker = new StringChecker();
        this.convertOperator = convertOperator;
    }
    
    /**
     * Method untuk mengecek input pengguna berupa ekpresi logika atau aritmatika
     * @return mengembalikan true bila input berupa ekspresi logika
     */
    public boolean hasBoolean() {
        return hasBoolean;
    }
    
    /**
     * Method untuk menghitung ekspresi hasil input dan mengembalikan hasil perhitungan
     * @param input String hasil input pengguna
     * @return Mengembalikan nilai hasil perhitungan ekspresi 
     */
    public Double calculate(String input){
        String split [] = input.split(" ");
        double result = 0;
        hasBoolean = false;
        List <String> checkKali = convertOperator.getOperatorKali();
        List <String> checkBagi = convertOperator.getOperatorBagi();
        List <String> checkTambah = convertOperator.getOperatorTambah();
        List <String> checkKurang = convertOperator.getOperatorKurang();
        List <String> checkDiv = convertOperator.getOperatorDiv();
        List <String> checkMod = convertOperator.getOperatorMod();
        List <String> checkAnd = convertOperator.getOperatorAnd();
        List <String> checkOr = convertOperator.getOperatorOr();
        List <String> checkNot = convertOperator.getOperatorNot();
        
        for(int i=split.length-1; i>=0; i--){
            if(stringChecker.isNumeric(split[i])){
                st.push(Double.parseDouble(split[i]));
            } 
            else if (stringChecker.isTrueFalse(split[i])) {
                hasBoolean = true;
                st.push(split[i].equals("true") ? 1.0 : 0.0);
            }
            else{
                for(int x=0; x<checkKali.size(); x++){
                    if(split[i].equalsIgnoreCase(checkKali.get(checkKali.size()-1))){
                        result = st.pop() * st.pop();
                        break;
                    }
                }
                for(int x=0; x<checkBagi.size(); x++){
                    if(split[i].equalsIgnoreCase(checkBagi.get(checkBagi.size()-1))){
                        result = st.pop() / st.pop();
                        break;
                    }
                }
                for(int x=0; x<checkTambah.size(); x++){
                    if(split[i].equalsIgnoreCase(checkTambah.get(checkTambah.size()-1))){
                        result = st.pop() + st.pop();
                        break;
                    }
                }
                for(int x=0; x<checkKurang.size(); x++){
                    if(split[i].equalsIgnoreCase(checkKurang.get(checkKurang.size()-1))){
                        result = st.pop() - st.pop();
                        break;
                    }
                }
                for(int x=0; x<checkMod.size(); x++){
                    if(split[i].equalsIgnoreCase(checkMod.get(checkMod.size()-1))){
                        result = st.pop() % st.pop();
                        break;
                    }
                }
                for(int x=0; x<checkDiv.size(); x++){
                    if(split[i].equalsIgnoreCase(checkDiv.get(checkDiv.size()-1))){
                        result = st.pop() / st.pop();
                        break;
                    }
                }
                for (int x = 0; x < checkAnd.size(); x++) {
                    if (split[i].equalsIgnoreCase(checkAnd.get(checkAnd.size() - 1))) {
                        result = st.pop() * st.pop();
                        break;
                    }
                }
                for (int x = 0; x < checkOr.size(); x++) {
                    if (split[i].equalsIgnoreCase(checkOr.get(checkOr.size() - 1))) {
                        result = st.pop() + st.pop() > 0.0 ? 1.0 : 0.0;
                        break;
                    }
                }
                for (int x = 0; x < checkNot.size(); x++) {
                    if (split[i].equalsIgnoreCase(checkNot.get(checkNot.size() - 1))) {
                        result = st.pop() > 0.0 ? 0.0 : 1.0;
                        break;
                    }
                }
                st.push(result);
            }
        }
        return st.pop();
    }
   
}
