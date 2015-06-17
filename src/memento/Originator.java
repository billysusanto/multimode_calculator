package memento;

public class Originator { 
   private String state; 
   private String result;
   
   /**
    * Method yang berfungsi untuk mengeset state dan result hasil perhitungan kedalam memento
    * @param state string state dalam bentuk ekspresi aritmatika, logika, atau set command
    * @param result string result, hasil input pengguna
    */
   public void setState(String state, String result){ 
      this.state = state;
      this.result = result;
   }  
   
   public String getState(){ 
      return state; 
   }  
   
   public String getResult(){
       return result;
   }
   
   /**
    * Method yang berfungsi untuk menyimpan state dan result kedalam memento
    * @return mengembalikan objek memento yang disimpan kedalam list
    */
   public Memento saveStateToMemento(){ 
      return new Memento(state, result); 
   }  
   
   public void getStateFromMemento(Memento Memento){ 
      state = Memento.getState(); 
   } 
   
   public void getResultFromMemento(Memento Memento){
       result = Memento.getResult();
   }
}
