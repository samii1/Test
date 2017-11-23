package database;
import static dit042.SimpleIO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Main {
	
	
	static Database library;
	final String EOL = System.lineSeparator();
	public Main() throws SQLException {
		library = new Database();
	}
	public void menu() throws SQLException  {
		int choice;
		do {
			System.out.println(menuList());
			choice = readInt();

			switch (choice) {
			case 0:
				System.out.println("Exiting database program.");
				break;
				/*case 1:
				list_db_Choice();
				break; */
			case 2:
				searchBook();
				break;
			case 3:
				addBookInput();
				break;
				case 4: 
				addCustomerInput();
				break;
			case 5:
				listBorrowedBooks();
				break;
			case 6: 
				borrowBook();
				break;
			default:
				System.out.println("Invalid input.");
				menu();
			}
		} while (choice != 0);
	}
	public  String menuList() {
		String result = "======|| Welcome to the Library Database ||=====" + EOL +
				"1. List a databse" + EOL +
				"2. Search for a book" + EOL +
				"3. Add a book" + EOL +
				"4. Add a customer" + EOL +
				"5. View borrowed books" + EOL +
				"6. Borrow a book" + EOL +
				"================================================" + EOL +
				"Enter choice: ";
		return result;	
	}
	public void addBookInput() throws SQLException {
		int shelf, quantity, pages;
		String isbn, title, author, genre, publisher;
		System.out.println("Adding a book");
		System.out.println("ISBN: ");
		isbn = readString();
		System.out.println("Title: ");
		title = readLine();
		System.out.println("Author: ");
		author = readLine();
		System.out.println("Genre: ");
		genre = readLine();
		System.out.println("Shelf: ");
		shelf = readInt();
		System.out.println("Publisher: ");
		publisher = readLine();
		System.out.println("Quantity: ");
		quantity = readInt();
		System.out.println("Pages: ");
		pages = readInt();
		library.addBook(isbn, title, author, genre, shelf, publisher, quantity, pages);
	}
	public void addCustomerInput() throws SQLException {
		int card_id;
		String name, address, phone_nr;
		System.out.println("Adding a customer");
		System.out.println("Card id: ");
		card_id = readInt();
		System.out.println("Name: ");
		name = readLine();
		System.out.println("Address");
		address = readLine();
		System.out.println("Phone nr: ");
		phone_nr = readLine();
		library.addCustomer(card_id, name, address, phone_nr);
	}
	public void borrowBook() throws SQLException {
		int card_id, book_id;
		System.out.println("Input the ID of the chosen book: ");
		book_id = readInt();
		System.out.println("Input Card ID: ");
		card_id = readInt();
		library.addBorrowed(book_id, card_id);
	}
	public void listBorrowedBooks() throws SQLException {
		int card_id;
		System.out.println("Input your Library Card ID: ");
		card_id = readInt();
		String listOfBooks = "";
		BorrowedBook[] borrowedList = library.getBorrowedBooks(card_id);
		
		for(int i = 0; i < borrowedList.length; i++) {
			
			listOfBooks+= borrowedList[i].toString() + EOL;
		}
		System.out.println(listOfBooks);
	}
	public static void main(String[] args) throws SQLException {
		Main program = new Main();
		program.menu();
	}
	
	
	
public void searchBook() throws SQLException {
		
		
		System.out.println("Search by...");
		System.out.println("1) Title");
		System.out.println("2) Author");
		System.out.println("3) Genre");
		
		int option = readInt();
		String category;
		switch(option) {
		case 1 :
		category="title";
		searchInput(category);
		break;
		case 2: 
			category="author";
		searchInput(category);
		break;
		case 3: 
			category="Genre";
		searchInput(category);
		break;
		
		default: 
			System.out.println("Invalid input");
			searchBook();
		}
		}
	
	
	public void searchInput(String category) {
System.out.println("Search: ");
		
String search=readLine();

library.search(search, category);

	
	
	}
	

	}
