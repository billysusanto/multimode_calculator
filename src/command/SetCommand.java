package command;

import convert.ConvertModeAritmatika;
import convert.ConvertModeBilangan;
import convert.ConvertOperator;
import layout.console.MainConsole;

public class SetCommand {
    
    ConvertOperator convertOperator;
    ConvertModeAritmatika convertModeAritmatika;
    ConvertModeBilangan convertModeBilangan;
    
    /**
     * Konstaktor kelas SetCommand
     * @param convertOperator objek convertOperator yang akan digunakan untuk mengkonvert operator yang akan digunakan untuk operasi perhitungan
     * @param convertModeAritmatika objek convertModeAritmatika yang digunakan untuk mengkonvert mode aritmatika (prefix, postfix, infix)
     * @param convertModeBilangan objek convertModeBilangan yang digunakan untuk mengkonvert mode bilangan/romawi
     */
    public SetCommand(ConvertOperator convertOperator, ConvertModeAritmatika convertModeAritmatika, ConvertModeBilangan convertModeBilangan){
        this.convertOperator = convertOperator;
        this.convertModeAritmatika = convertModeAritmatika;
        this.convertModeBilangan = convertModeBilangan;
    }
    
    /**
     * Method untuk mengubah mode operasi aritmatika
     * @param s input pengguna berupa string command set
     * @return mengembalikan true bila proses set mode aritmatika berhasil, false bila proses set mode gagal
     */
    public boolean isModeCommand(String s){
        String split [] = s.split(" ");
        if(split[1].equalsIgnoreCase("mode")){
            if(split[2].equalsIgnoreCase("prefix")){
                convertModeAritmatika.setModeAritmatika(1);
                return true;
            }
            else if(split[2].equalsIgnoreCase("postfix")){
                convertModeAritmatika.setModeAritmatika(2);
                return true;
            }
            else if(split[2].equalsIgnoreCase("Infix")){
                convertModeAritmatika.setModeAritmatika(3);
                return true;
            }   
        }
        
        else{
            return false;
        }
        return false;
    }
    
    /**
     * Method untuk mengubah mode bilangan [angka / romawi]
     * @param s input pengguna berupa string command set
     * @return mengembalikan true bila proses set bilangan berhasil, false bila proses set bilangan gagal
     */
    public boolean isModeBilangan(String s){
        String split[] = s.split(" ");
        if(split[1].equalsIgnoreCase("BILANGAN")){
            if(split[2].equalsIgnoreCase("ANGKA")){
                convertModeBilangan.setModeAngka(1);
                return true;
            }
            else if(split[2].equalsIgnoreCase("ROMAWI")){
                convertModeBilangan.setModeAngka(2);
                return true;
            }   
        }
        
        else{
            return false;
        }
        return false;
    }
    
    /**
     * Method untuk mengubah input operator untuk perhitungan
     * @param s input pengguna berupa string command set
     * @return mengembalikan true bila proses set operator berhasil, false bila proses set operator gagal
     */
    public boolean isOperator(String s){
        String split[] = s.split(" ");
        if(split[1].equalsIgnoreCase("kali")){
            convertOperator.setOperator("kali", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("bagi")){
            convertOperator.setOperator("bagi", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("tambah")){
            convertOperator.setOperator("tambah", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("kurang")){
            convertOperator.setOperator("kurang", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("div")){
            convertOperator.setOperator("div", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("mod")){
            convertOperator.setOperator("mod", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("and")){
            convertOperator.setOperator("and", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("or")){
            convertOperator.setOperator("or", split[2]);
            return true;
        }
        else if(split[1].equalsIgnoreCase("not")){
            convertOperator.setOperator("not", split[2]);
            return true;
        }
        
        return false;
    }
}
