package eLibrary;

//mai am de facut la metode. Acum sunt doar pentru a nu da eroare facute

public class AbstractAccount implements Account {

	 private int id;
	 protected int cantitate;
	 protected String status;
	 
     public int getID()
     {
    	 return id;  //returneaza id-ul cumparatorului
     }
     @Override
     public void StatusStudent()
     {   
    	  if(this.cantitate==0)  this.status = "Student-ul nu mai are carti de returnat";
    	  
    	  else this.status = "Student-ul mai are carti de returnat";
     }
     public int getBooks()
     {
    	 return 0;  //la metoda asta mai am de lucrat
     }
   
      @Override
	  public void Booksbuyed(int numb)
	  {
		    if (numb < 0) throw new IllegalArgumentException("Nu poti cumpara carti.");
		    else
		    	if (numb > 5) throw new IllegalArgumentException("Prea multe carti cumparate");
		    else 
		    	this.cantitate += numb;
	  }
	  
	  @Override
	  public void BooksReturnetd(int nr)
	  {
		 if( nr < 0)  throw new IllegalArgumentException("Nimic de returnat");
		 else 
			 this.cantitate = this.cantitate - nr;
	  }
	  @Override    //suprascriere toStrings
	  public String toString()
	  {
		  return "Cont{" + "id=" + id + "status: " + status + "}\n";
	  }
	  public AbstractAccount(int id, int cantitate, String status)  //constructorul clasei
	  {
		  this.id = id;
		  this.cantitate = cantitate;
		  this.status = status;
	  }
	  
	 
	 
}

