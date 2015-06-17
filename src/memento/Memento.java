package memento;

public class Memento {
    String state;
    String result;
    
    /**
     * Kontraktor kelas Memento
     * @param state string state, input dari pengguna
     * @param result string result, hasil perhitungan ekpresi yang dimasukkan juga kedalam memento
     */
    public Memento(String state, String result){ 
      this.state = state; 
      this.result = result;
    }  
    
    public String getState(){ 
       return state; 
    }  
    
    public String getResult(){
        return result;
    }
}
