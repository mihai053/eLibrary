package eLibrary;

import java.text.DateFormat;
import java.util.*;

import Exceptions.StudentExistsException;
import Service.EmailService;

public class Library {
   
	private Set<Student> studenti = new LinkedHashSet<>();
	private final List<StudentRegistration> listeners = new ArrayList<>();
	
	private int printedStudents = 0;
    private int emailedStudents = 0;
    private int debuggedStudents = 0;
  
   public Library()
    {
	    listeners.add(new PrintedStudentListener());
		listeners.add(new EmailNotificationListener());
		listeners.add(new DebugListener());
    }
  
 
    // mai tarziu facem constructorul
    public int getPrintedStudents() {    //getteri pentru cele doua variabile declarate private
		return printedStudents;
	}
    public int getEmailedStudents() {
    	return emailedStudents;
    }
    
    public void addStudent(final Student student) throws StudentExistsException {
    	if (studenti.contains(student)) {
    		throw new StudentExistsException("Studentul este inregistrat in librarie");
    	}

    	studenti.add(student);
         notify(student);      //  trebuie facuta metoda asta
	}
    
    private void notify(Student student) {
        for (StudentRegistration listener: listeners) {
            listener.onStudentAdded(student);
        }
    }
    
    
    public Set<Student> getStudents() {
    	
		return Collections.unmodifiableSet(studenti);
	}
	
	class PrintedStudentListener implements StudentRegistration { //metoda
		@Override 
		public void onStudentAdded(Student student) {
	        System.out.println("Student added: " + student.getName());
	        printedStudents++;
	    }

	}
	class EmailNotificationListener implements StudentRegistration  {
		@Override 
		public void onStudentAdded (Student student) {
	        System.out.println("Notification email for student " + student.getName() + " to be sent");
			EmailService.sendNotificationEmail(student);
			emailedStudents++;

			new Thread(new Runnable() {
				@Override
				public void run() {
					Thread.currentThread().setName(student.getName() + "'s thread");
					student.getEmail().waitForEmail();
					System.out.println("\u001B[32m" + student.getName() + " received the email successfully." +"\u001B[0m");
				}
			}).start();
	    }
	}
	class DebugListener implements StudentRegistration {
        @Override 
        public void onStudentAdded(Student student) {
            System.out.println("Student " + student.getName() + " added on: " + DateFormat.getDateInstance(DateFormat.FULL).format(new Date()));
            debuggedStudents++;
        }
    }
	
	
    
}
