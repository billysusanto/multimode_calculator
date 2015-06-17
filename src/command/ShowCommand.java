package command;

import memento.CareTaker;
import memento.Originator;

public class ShowCommand {

    /**
     * Method untuk menampilkan isi dari memori
     * @param quantity Banyaknya memori yang akan ditampilkan dari input terakhir
     * @param originator objek originator untuk melakukan get memento
     * @param careTaker Objek caretaker untuk mendapatkan pointer memento
     * @return Mengembalikan array of string dari memori sesuai quantity
     */
    public String [] showMem(int quantity, Originator originator, CareTaker careTaker){
      String [] mem;
      mem = new String [quantity];
      int idxMax = careTaker.getPointer();
      
      for(int i=0; i< mem.length; i++){
          originator.getStateFromMemento(careTaker.get(idxMax-1));
          mem[i] = originator.getState();
          idxMax -= 1;
      }
      
      return mem;
    }
    
    /**
     * Method untuk menampilkan seluruh isi dari memori
     * @param originator objek originator untuk melakukan get memento
     * @param careTaker Objek caretaker untuk mendapatkan pointer memento
     * @return Mengembalikan array of string isi seluruh memori
     */
    public String [] showAll(Originator originator, CareTaker careTaker){
      String [] mem;
      int idxMax = careTaker.getPointer();
      mem = new String [idxMax];
      
      for(int i=0; i< mem.length; i++){
          originator.getStateFromMemento(careTaker.get(idxMax-1));
          mem[i] = originator.getState();
          idxMax -= 1;
      }
      return mem;
    }
}
