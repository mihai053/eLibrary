package eLibrary;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {
	private String nume;
	private Gender gen;
	private Set<Account> cont = new HashSet<>();
	private String oras;
	private Email email;

	public Student(String nume, Gender gen, String oras, Email email) //constructor 1	
	{ 
		this.nume = nume;
		this.gen = gen;
		this.oras = oras;
		this.email = email;
	}
	public Student(String nume, Gender gender) // nu inteleg eroarea
	{
		this.nume = nume;
		this.gen = gender;
	}
	
	public Student(String nume, Gender gen, String oras) {
		this.nume = nume;
		this.gen = gen;
		this.oras = oras;
		this.email = getImplicitEmail(this);
	}
	
	
	
	public String getName()  //getteri si setteri generati parte in parte
	{
		return nume;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public Gender getGen() {
		return gen;
	}
	public void setGen(Gender gen) {
		this.gen = gen;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
    
// ceva gen implicit email ca spam
    private static Email getImplicitEmail(Student student)
	{
		Random r = new Random();
		return new Email(student, student.getName().toLowerCase()+ r.nextInt(96) + "@yahoo.com", " service@eLibrary.com");
	}
	

	
	public void addAccount(Account account) {  //metoda adaugare cont librarie + verificare daca exiista
		if (cont.contains(account)) {
			System.out.println("Account "+ account.getID() + " deja existent pentru:  "+ nume);
		}

		cont.add(account);
	}
	
	public Set<Account> getAccounts() {
		return Collections.unmodifiableSet(cont);
	}
	public String getClientGreeting()  //metoda de salutare a clientului 
        {
		  if (gen != null) {
			return gen.getGreeting() + " " + nume;
		} else {
			return nume;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cont == null) ? 0 : cont.hashCode());
		result = prime * result + ((gen == null) ? 0 : gen.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((oras == null) ? 0 : oras.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (cont == null) {
			if (other.cont != null)
				return false;
		} else if (!cont.equals(other.cont))
			return false;
		if (gen != other.gen)
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (oras == null) {
			if (other.oras != null)
				return false;
		} else if (!oras.equals(other.oras))
			return false;
		return true;
	}
	
	
}


