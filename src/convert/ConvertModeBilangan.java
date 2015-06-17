package convert;

import java.util.ArrayList;
import java.util.List;
import layout.console.MainConsole;

public class ConvertModeBilangan {
    List <Integer> modeAngka = new ArrayList <Integer>();
    int pointer = -1;

    /**
     * Method yang berfungsi untuk mengubah mode bilangan yang akan digunakan berdasarkan input pengguna [1: angka, 2:romawi]
     * @param mode int yang merepresntasikan mode bilangan yang akan digunakan
     */
    public void setModeAngka(int mode){
        modeAngka.add(mode);
        MainConsole.modeAngka = mode;
        pointer++;
    }
    
    /**
     * Method yang berfungsi untuk membatalkan mode bilangan yang telah diubah
     */
    public void undo(){
        pointer--;
        //modeAngka.remove(modeAngka.size()-1);
        MainConsole.modeAngka = modeAngka.get(pointer);
    }
    
    /**
     * Method yang berfungsi untuk memanggil kembali mode bilangan yang telah dibatalkan dengan command undo
     */
    public void redo(){
        pointer++;
        MainConsole.modeAngka = modeAngka.get(pointer);
    }
}
