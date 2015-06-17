package convert;

import java.util.ArrayList;
import java.util.List;

public class ConvertOperator {
    List <String> kali = new ArrayList <String>();
    List <String> bagi = new ArrayList <String>();
    List <String> tambah = new ArrayList <String>();
    List <String> kurang = new ArrayList <String>();
    List <String> div = new ArrayList <String>();
    List <String> mod = new ArrayList <String>();
    List <String> and = new ArrayList <String>();
    List <String> or = new ArrayList <String>();
    List <String> not = new ArrayList <String>();

    /**
     * Method yang berfungsi untuk mengubah operator yang akan digunakan untuk perhitungan
     * @param operator string operator yang akan diubah
     * @param sintaks string operator yang akan digunakan untuk perhitungan
     */
    public void setOperator(String operator, String sintaks){
        if(operator.equalsIgnoreCase("kali")){
            //kali.clear();
            kali.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("bagi")){
            //bagi.clear();
            bagi.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("tambah")){
            //tambah.clear();
            tambah.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("kurang")){
            //kurang.clear();
            kurang.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("div")){
            //div.clear();
            div.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("mod")){
            //mod.clear();
            mod.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("and")){
            //and.clear();
            and.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("or")){
            //or.clear();
            or.add(sintaks);
        }
        else if(operator.equalsIgnoreCase("not")){
            //not.clear();
            not.add(sintaks);
        }
    }
    
    /**
     * Method yang berfungsi untuk membatalkan set operator
     * @param operator string berupa input hasil undo yang akan dibatalkan
     */
    public void undoOperator(String operator){
        if(operator.equalsIgnoreCase("kali")){
            //kali.clear();
            kali.remove(kali.size()-1);
        }
        else if(operator.equalsIgnoreCase("bagi")){
            //bagi.clear();
            bagi.remove(bagi.size()-1);
        }
        else if(operator.equalsIgnoreCase("tambah")){
            //tambah.clear();
            tambah.remove(tambah.size()-1);
        }
        else if(operator.equalsIgnoreCase("kurang")){
            //kurang.clear();
            kurang.remove(kurang.size()-1);
        }
        else if(operator.equalsIgnoreCase("div")){
            //div.clear();
            div.remove(div.size()-1);
        }
        else if(operator.equalsIgnoreCase("mod")){
            //mod.clear();
            mod.remove(mod.size()-1);
        }
        else if(operator.equalsIgnoreCase("and")){
            //and.clear();
            and.remove(and.size()-1);
        }
        else if(operator.equalsIgnoreCase("or")){
            //or.clear();
            or.remove(or.size()-1);
        }
        else if(operator.equalsIgnoreCase("not")){
            //not.clear();
            not.remove(not.size()-1);
        }
    }
    
    public List getOperatorKali(){
        return kali;
    }
    public List getOperatorBagi(){
        return bagi;
    }
    public List getOperatorTambah(){
        return tambah;
    }
    public List getOperatorKurang(){
        return kurang;
    }
    public List getOperatorDiv(){
        return div;
    }
    public List getOperatorMod(){
        return mod;
    }
    public List getOperatorAnd(){
        return and;
    }
    public List getOperatorOr(){
        return or;
    }
    public List getOperatorNot(){
        return not;
    }
}
