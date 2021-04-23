package Service;

import eLibrary.Email;
import java.util.LinkedList;

public class Queue extends LinkedList<Email>{
  //ma pune sa generez serialversionUID altfel am warning
	private static final long serialVersionUID = 1L;

    public void enqueue(Email email){
       if(email != null){
           super.add(email);
       }
   }

    public Email dequeue(){
       if(super.isEmpty()){
           System.out.println("There is nothing to dequeue.");
           return null;
       }else{
           try {
               Email firstEmail = super.getFirst();
               super.removeFirst();
               return firstEmail;
           } catch(ClassCastException e){
               System.out.println(e.getMessage() + ", returning null.");
               return null;
           }
       }
    }

    public boolean isEmpty() {
       return super.isEmpty();
    }
}

