package memento;

import java.util.ArrayList; 
import java.util.List;  

public class CareTaker { 
    private List<Memento> mementoList = new ArrayList<Memento>();  
    private int pointer = 0;
    
    /**
     * Method yang berfungsi untuk menambah state kedalam list memento
     * @param state Objek memento yang akan disimpan kedalam list
     */
    public void add(Memento state){ 
       mementoList.add(state); 
       pointer++;
    }  
   
    public Memento get(int index){ 
       Memento returnMemento = new Memento(null, null);
       try{
           returnMemento = mementoList.get(index);
       }
       catch(Exception ex){
           System.out.println("Exception Message : "+ex);
       }
        return returnMemento;
    } 
    
    public int getLength(){
        return mementoList.size();
    }
    
    public int getPointer(){
        return this.pointer;
    }
    
    /**
     * Method yang berfungsi untuk menghapus isi memento
     */
    public void remove(){
        mementoList.remove(mementoList.size()-1);
    }
    
    /**
     * Method yang mengembalikan isi memento bila sebelumnya pernah dipanggil perintah undo
     * @return mengembalikan input pengguna yang telah di-undo sebelumnya.
     */
    public boolean redo(){
        if(pointer < mementoList.size()){
            this.pointer++;
            return true;
        }
        return false;
    }
    
    /**
     * Method yang berfungsi untuk memanggil kembali ekpresi yang telah diinput dan menampilkan hasilnya, dan membatalkan perintah set yang telah diinput sebelumnya
     * @return mengembalikan ekpresi yang telah diinput sebelumnya
     */
    public boolean undo(){
        if(pointer > 0){
            this.pointer--;
            return true;
        }
        return false;
    }
    
    
}
