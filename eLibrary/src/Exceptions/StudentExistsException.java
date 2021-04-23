package Exceptions;
// finalizat
public class StudentExistsException extends LibraryException {
     
	private static final long serialVersionUID = -8368249553360028667L;

	public StudentExistsException(String mesaj) {
		super(mesaj);
	}
}
