package eLibrary;
import Service.LibraryService;
import Service.EmailService;
import Exceptions.*;
import eLibrary.Gender;
import eLibrary.SavingAccount;
import eLibrary.Account;


public class LibraryApplication  {
     
	
	 private static Library library;

	 public static void main(String[] args) throws InterruptedException
	 {
		 library = new Library();
		 modifyLibrary();
		 
		 EmailService emailService = new EmailService();
		 while (true) {
				Thread.sleep(10000);
				if (EmailService.getQueue().isEmpty()) {
					emailService.close();
					break;
				}
			}
		 
		 printStatus();
		 
	 }
	 
	 private static void modifyLibrary()
	 {
		 Student student1 = new Student("Ioan", Gender.Masculin);  //construcotrul a fost creat ulterior in clasa student
		 Student student2 = new Student("Maria", Gender.Feminin);
		 Account cont1 = new SavingAccount(123,3,"cumparate");
		 Account cont2 = new SavingAccount(154,2,"nereturnate");
		 
		 student1.addAccount(cont1);
		 student2.addAccount(cont2);
	 
	 try {
		   LibraryService.addStudent(library, student1);
		} catch(StudentExistsException e) {
			System.out.format("Nu se poate adauga un student existent: %s%n", student1.getName());
	    } 
	 
	 try {
		LibraryService.addStudent(library, student2);
		} catch(StudentExistsException e) {
		  System.out.format("Nu se poate adauga un student existent: %s%n", student1);
	    } 
	 
	 }
	 private static void printStatus() {
			System.out.format("%nPrint balance for all clients%n");
			for(Student student : library.getStudents()) {
				System.out.println("Student: " + student);
				for (Account account : student.getAccounts()) {
					System.out.format("Account %d : %d \n", account.getID(), account.getBooks());
				}
			}
		}
}
