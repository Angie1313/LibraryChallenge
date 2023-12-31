import java.time.*;

public class Library {
	
	// this is a small library that can only have 10 books at a time 
	//will contain the different book names
	String [] titles= new String[10];
	//will contain the authors of the books
	String [] authors= new String[10];
	//keep count of the number of customers
	int count=0;
	//will have the name of the customer and card number of each consumer
	String [][]customerInfo=new String[10][10];
	//will have the date the book was checked out
	LocalDate todayDate;
	//declaring customer instance
	Person customer;
	
	
	//creates a customer and check out their book
	void createCustomer(String name, String book, String card) {
		customer = new Person();
		customer.setName(name);
		customer.setBook(book);
		customer.setLibrarycard(card);
		customer.setCheckoutdate();
		checkout(book,name,card, customer.checkoutDate);
		
		
	}
	//check out book from library
	void checkout(String book,String name, String card, LocalDate date) {
		Boolean available = false;
		for(int i  = 0;i < 10;i++) {
			//checks if the book is in the library
			if(titles[i]==book) {
				//if it is it will delete the book name and author from the system because it is no longer available
				titles[i]=null;
				authors[i]=null;
				count--;
				available= true;
				//adds customer to the library system for those who have checked out a book
				addCustomer(name, card);
				System.out.println(book+" has been checked out!");
				dueDate(date);
				break;
			}
		}
		if(available == false) {
			System.out.println("We don't have "+ book);
		}
		
	}
	//adds customer to library system for those who checked out a book
	void addCustomer(String name, String card) {
		for(int i = 0;i< 10;i++) {
			//checks to see which slot is empty
			if(customerInfo[0][i] == null) {
				//adds the name and library card number to the library system
				customerInfo[0][i] = name;
				customerInfo[1][i] = card;
				System.out.print(name+" was added to the system with library ID "+ card+". ");
				break;
			}
		}
	}
	//checks if we have books by title
	void checkTitle(String title){
		Boolean status=false;
		for(int i=0;i<10;i++) {
			if(title == this.titles[i]) {
				status = true;
				System.out.println("We do have " + title);
				
			}
		}
		if(status == false) {
			System.out.println("we don't have "+ title);
		}
		
	}
	//check if we have books by author
	void checkAuthor(String author){
		Boolean status=false;
		for(int i=0;i<10;i++) {
			if(author == this.authors[i]) {
				status = true;
				System.out.println("We do have book/s by "+ author);
				
			}
			
		}
		if(status == false) {
			System.out.println("We don't have book/s by "+ author);
		}
		
	}
	
	//adds book to the library system
	void addBook(String book, String author) {
		//checks if the library is already full
		if(count == 10){
			System.out.println("Sorry library is full");
			
		}
		for(int i  = 0;i < 10;i++) {
			//checks what slot is open
			if(titles[i] == null) {
				//adds book title and author to library system
				titles[i]=book;
				authors[i]=author;
				System.out.println("The book "+book+" has been added!");
				count++;
				break;}
			}
		}
		
	
	//gives you the due date of the book you checked out
	void dueDate(LocalDate date) {
		LocalDate dueDate = date.plusDays(28);
		System.out.println("The due date is: "+dueDate);
		
	}
	
	

	public static void main(String[] args) {
		//testing out methods
		Library l1 = new Library();
		//test date
		LocalDate date = LocalDate.now();
		
		l1.addBook("new world","Patrick");
		l1.addBook("chasers","cole");
		l1.checkout("new world", "lenny","SD987HJ", date);
		l1.checkout("cheese","sara","NH768T", date);
		l1.checkTitle("chasers");
		l1.checkTitle("zappers");
		l1.checkAuthor("Patrick");
		l1.createCustomer("christie","up","AS89777GH");
		l1.createCustomer("bob","chasers","GU89746HJ");
		l1.createCustomer("James Bond","suckers","GA33346HL");
		l1.addBook("Pony Princess","Caramel");
		l1.addBook("Blue Hue","Smurfs");
		l1.addBook("Farts","Big Bang Theory");
		l1.addBook("Halloween","October");
		l1.addBook("Chicken and","Rice");
		l1.addBook("High Five","Sam Smith");
		l1.addBook("Barney","Flora Door");
		l1.createCustomer("Tatiana Pink","Blue Hue","GPO1146CW");
		l1.createCustomer("Jennifer Lopez","Aqua Man","ZZ4567BR");
		l1.checkTitle("Halloween");
		l1.checkAuthor("Smurfs");
		l1.createCustomer("Jennifer Lopez","High Five","ZZ4567BR");
		l1.createCustomer("Rauw Alejandro","Farts","AA4497FR");
	}

	public class Person{
		String name;
		String book;
		String libraryCard;
		LocalDate checkoutDate;
		
		
		//sets the name of the customer
		void setName(String name) {
			this.name=name;
			System.out.println("Customer's name is: "+ this.name);
		}
		//sets the book the customer checked out
		void setBook(String book) {
			this.book=book;
			System.out.println("Customer's book is: "+ this.book);
		}
		//sets the day the book was checked out 
		void setCheckoutdate() {
			this.checkoutDate = LocalDate.now();
			//System.out.println("Customer's checkout date is: "+ this.checkoutDate);
		}
		//sets the customer's library card number
		void setLibrarycard(String number) {
			this.libraryCard= number;
			System.out.println("Customer's library ID is: "+ this.libraryCard);
		}
		
	}

}
