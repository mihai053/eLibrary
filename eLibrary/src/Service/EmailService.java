package Service;

import eLibrary.Email;
import eLibrary.Student;

public class EmailService {

    private static Queue queue = new Queue();
    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setName("EmailService Thread");
            Email email;
            while(!queue.isEmpty()) {
                do {
                    email = queue.dequeue();
                } while (email == null);
                email.sendEmail();
            }


        }
    });

    public static Queue getQueue() {
        return queue;
    }

    public EmailService(){
        thread.start();
    }

    public static void sendNotificationEmail (Student student){
        queue.enqueue(student.getEmail());
    }

    public void close(){
        System.out.println(Thread.currentThread().getName() + " interrupting the EmailService Thread...");
        thread.interrupt();
    }

}

