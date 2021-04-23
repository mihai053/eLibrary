package eLibrary;
// finalizat 
public class Email {

	    private Student student;
	    private String catre;
	    private String from;
	    private boolean isSent = false;  //variabila necesara mai tarziu pentru metoda waitforemail
	    
	   public Email(Student student, String catre, String from)  //constructor 
	    {
	        this.student = student;
	        this.catre = catre;
	        this.from = from;
	    }
	   public Student getClient() //getter pentru client
	   {
		   return student;
	   }
	   public String getCatre() //getter pentru catre
	   {
		   return catre;
	   }
	   public String getFrom() //getter pentru from
	   {
		   return from;
	   }
	   
	      // mai am doua metode de pus waitEmail si sendEmail
	       // sendEmail method catre "cumparator"
	    public synchronized void sendEmail(){
	        System.out.println("Sending an email to " + this.getCatre() + "( " + this.getClient().getName()+ ") from " + this.getFrom());
	        try{
	            Thread.sleep(3000);
	            isSent = true;
	            notify();
	        }catch (InterruptedException e){
	            System.out.println("ERROR sending email: " + e.getMessage());
	        }
	        
	    }
	    public synchronized void waitForEmail(){
//	        System.out.println(Thread.currentThread().getName() + " asteapta ca e-mail-ul sa fie trimis.");
	        while(!isSent){
	            try{
	                wait();
	            }catch (InterruptedException e){
	                System.out.println("ERROR waiting for Email:" + e.getMessage());
	            }
	            isSent = true;
	        }
	    }
	   
}
