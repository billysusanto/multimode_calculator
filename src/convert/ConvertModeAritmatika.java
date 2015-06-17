package convert;

import java.util.ArrayList;
import java.util.List;
import layout.console.MainConsole;

public class ConvertModeAritmatika {
    List <Integer> modeAritmatika = new ArrayList <Integer>();
    int pointer = -1;
    
    /**
     * Method yang berfungsi untuk mengubah mode aritmatika [prefix, postfix, infix]
     * @param mode int yang merepresentasikan mode yang akan digunakan [1: prefix, 2: postfix, 3: infix]
     */
    public void setModeAritmatika(Integer mode){
        MainConsole.modeEkspresi=mode;
        modeAritmatika.add(mode);
        pointer++;
        
    }
    
    /**
     * Method yang berfungsi untuk menghapus set mode yang telah dipanggil dengan perintah undo
     */
    public void undo(){
        //modeAritmatika.remove(modeAritmatika.size()-1);
        if(pointer > 0){
            pointer--;
            MainConsole.modeEkspresi = modeAritmatika.get(pointer);
        }
    }
    
    /**
     * Method yang berfungsi untuk memanggil kembali set mode yang telah di-undo sebelumnya
     */
    public void redo(){
        if(pointer < modeAritmatika.size()){
            pointer++;
            MainConsole.modeEkspresi = modeAritmatika.get(pointer);
        }
    }
}
