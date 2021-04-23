package Service;

import eLibrary.*;
import Exceptions.*;
public class LibraryService {

	public static void addStudent(Library library, Student student) throws StudentExistsException 
	{
        library.addStudent(student);
    }
}
