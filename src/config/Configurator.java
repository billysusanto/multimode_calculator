package config;

import checker.StringChecker;
import convert.ConvertOperator;
import convert.Converter;
import format.roman.Roman;
import jdk.nashorn.internal.objects.NativeString;
import static layout.console.MainConsole.modeAngka;
import static layout.console.MainConsole.modeEkspresi;
import memento.CareTaker;
import memento.Originator;

public class Configurator {
    Roman roman;
    
    public Configurator(){
        roman = new Roman();
    }
    
    /**
     * Method untuk mengkonvert input pengguna menjadi bentuk yang diinginkan [prefix, postfix, infix]
     * @param input String input yang akan diubah bentuknya
     * @param converter objek converter yang memiliki method untuk mengubah input menjadi bentuk yang diinginkan
     */
    public String changeExpressionFormat(String input, Converter converter) {
        if (modeEkspresi == 2) {
            input = converter.PostfixToInfix(input);
            input = converter.InfixToPreFix(input);
        } else if (modeEkspresi == 3) {
            input = converter.InfixToPreFix(input);
        }
        return input;
    }

    /**
     * Method untuk menimpa memori dengan input pengguna yang baru, bila pernah melakukan undo
     * @param careTaker objek yang berfungsi untuk mendapatkan pointer dari memento
     */
    public void checkReplaceDo(CareTaker careTaker) {
        if (careTaker.getPointer() < careTaker.getLength()) {
            for (int i = 0; i <= careTaker.getLength() - careTaker.getPointer(); i++) {
                careTaker.remove();
            }
        }
    }

    /**
     * Method untuk mengubah hasil perhitungan ekpresi kedalam bentuk bilangan angka
     * @param input string hasil perhitungan
     */
    public String changeNumberFormat(String input) {
        
        int kurungBuka = 0, kurungTutup = 0;
        
        if (modeAngka == 2) {
            String split[] = input.split(" ");
            for (int a = 0; a < split.length; a++) {
                for(int b = 0, c = 0; b < split[a].length(); b++){
                    if(split[a].charAt(c) == '('){
                        kurungBuka++;
                        split[a] = split[a].substring(1);
                    }
                    else if(split[a].charAt(b) == ')'){
                        kurungTutup++;
                        split[a] = split[a].substring(0, split[a].length()-1);
                    }
                }

                if (roman.RomanToArabic(split[a]) != 0 && !StringChecker.isNumeric(split[a])) {
                    split[a] = roman.RomanToArabic(split[a]) + "";
                    for(int i=0; i<kurungBuka; i++){
                        split[a] = "(" + split[a];
                    }
                    for(int i=0; i<kurungTutup; i++){
                        split[a] = split[a] + ")";
                    }
                }
                kurungBuka =0; kurungTutup =0;
                
//                if(split[a].charAt(0) == '('){
//                    kurungBuka = true;
//                    split[a] = split[a].substring(1);
//                }
//                else if(split[a].charAt(split[a].length()-1) == ')'){
//                    kurungTutup = true;
//                    split[a] = split[a].substring(0, split[a].length()-1);
//                }
//                if (roman.RomanToArabic(split[a]) != 0 && !StringChecker.isNumeric(split[a])) {
//                    split[a] = roman.RomanToArabic(split[a]) + "";
//                    if(kurungBuka){
//                        split[a] = "(" + split[a];
//                        kurungBuka = false;
//                    }
//                    if(kurungTutup){
//                        split[a] = split[a] + ")";
//                        kurungTutup = false;
//                    }
//                }
            }
            input = RebuildRomanResult(split);
            //System.out.println(input);
        }
        return input;
    }

    public boolean commandLoad() {
        return false;
    }

    /**
     * Method untuk menyusun kembali hasil convert romawi ke angka
     * @param s string yang akan disusun kembali untuk ditampilkan
     * @return string hasil susunan hasil convert yang akan ditampilkan ke layar
     */
    public String RebuildRomanResult(String[] s) {
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += s[i] + " ";
        }
        return result;
    }
    
    /**
     * Methpd untuk menginisialisasi operator awal yang akan digunakan saat program pertama kali dijalankan
     * @param convertOperator objek convertOperator yang akan menyimpan operator awal
     */
    public void initialOperator(ConvertOperator convertOperator){
        String operator[] = {"kali", "bagi", "kurang", "tambah", "div", "mod", "and", "or", "not",};
        String sintaks[] = {"*", "/", "-", "+", "/", "%", "AND", "OR", "NOT",};
        for (int i = 0; i < 9; i++) {
            convertOperator.setOperator(operator[i], sintaks[i]);
        }
    }
    
    /**
     * Method yang berfungsi untuk menyimpan input pengguna kedalam memento
     * @param inputMemento input pengguna
     * @param resultMemento hasil perhitungan ekspresi yang akan disimpan pada memento
     * @param originator objek originator untuk melakukan penyimpanan input dan hasil perhitungan kedalam memento
     * @param careTaker objek caraTeker untuk menyimpan status pointer
     */
    public void addMemento(String inputMemento, String resultMemento, Originator originator, CareTaker careTaker) {
        originator.setState(inputMemento, resultMemento);
        careTaker.add(originator.saveStateToMemento());
    }
}
