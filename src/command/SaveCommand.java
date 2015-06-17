package command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import memento.*;

public class SaveCommand {
    
    /**
     * Method untuk menyimpan isi dari memento (input pengguna) kedalam file dengan ekstensi .txt
     * @param originator objek originator yang akan melakukan get state pada objek memento
     * @param careTaker objek caretaker yang akan melakukan get pointer pada objek caretaker
     * @return mengembalikan true bila proses save pada file berhasil, dan false bila proses save gagal
     */
    public boolean isSaveCommand(Originator originator, CareTaker careTaker){
        File file = new File("save.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file); 
            for(int i=0; i<careTaker.getPointer(); i++){
                originator.getStateFromMemento(careTaker.get(i)); 
                writer.write(""+originator.getState()+"\n");
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
