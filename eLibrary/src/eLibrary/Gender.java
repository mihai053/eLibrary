package eLibrary;
//finalizat
// genul persoanei care imprumuta cartea
// am avut nevoie de o enumeratie
public enum Gender {
	Masculin("D-nul"), Feminin("D-na");
	
	private String greeting;
    
	private Gender (String greeting)  //constructor
	{
		this.greeting = greeting;
	}
	public String getGreeting() //getter cand o sa am nevoie de genul persoanei  
	{
		return greeting;
	}
}
