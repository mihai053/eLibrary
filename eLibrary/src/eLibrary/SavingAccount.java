package eLibrary;
// terminat aici de adaugat dupa
public class SavingAccount extends AbstractAccount {
	public SavingAccount(int id, int cantitate, String status)
	{
		super(id,cantitate,status);
	}
	 
    public int retrageriMaxime()
    {
    	return getBooks();
    }
}

