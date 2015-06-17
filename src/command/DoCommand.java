package command;

import calculator.Calculator;
import memento.CareTaker;
import memento.Originator;

public class DoCommand {
    Calculator calculator;
    
    /**
     * Method untuk memanggil input yang telah di-undo sebelumnya.
     * @param originator objek originator yang akan melakukan get state pada objek memento
     * @param careTaker objek caretaker yang akan melakukan get pointer pada objek caretaker
     * @return mengembalikan objek memento hasil redo
     */
    public String isRedo(Originator originator, CareTaker careTaker){
        String result;
        originator.getStateFromMemento(careTaker.get(careTaker.getPointer()));
        result = originator.getState();
        result = result + "_" +originator.getResult();
        
        if(careTaker.redo()){
            return result;
        }
        return "";
    }
    
    /**
     * Method untuk memanggil input yang sebelumnya diinput pengguna dengan perintah undo
     * @param originator objek originator yang akan melakukan get state pada objek memento
     * @param careTaker objek caretaker yang akan melakukan get pointer pada objek caretaker
     * @return mengembalikan objek memento hasil undo
     */
    public String isUndo(Originator originator, CareTaker careTaker){
        String result;
        if(careTaker.undo()){
            originator.getStateFromMemento(careTaker.get(careTaker.getPointer()));
            result = originator.getState();
            result = result + "_" +originator.getResult();
            return result;
        }
        return "";
    }
}
