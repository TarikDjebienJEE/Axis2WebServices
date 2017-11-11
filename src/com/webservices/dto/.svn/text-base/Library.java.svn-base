package com.webservices.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Library {
	
	/**
	 * Singleton bibliotheque
	 */
	private static Library library = new Library();
	
	public static Library getInstance() {
		return library;
	}
	
	/**
	 * Les livres de notre bibliotheque
	 */
	public static ConcurrentHashMap<Long, Book> books;
	public static ConcurrentHashMap<Long, User> users;
	
	public Library(){
		books = new ConcurrentHashMap<Long, Book>();
		users = new ConcurrentHashMap<Long, User>();
	}
	
	/**
	 * Generateur d'ISBN aleatoire
	 * @return
	 */
	public Long generateIsbn(){
		return new Random().nextLong();
	}
	
	/**
	 * Generateur d'Identifiant utilisateur aleatoire
	 * @return
	 */
	public Long generateId(){
		return new Random().nextLong();
	}
	
	/**
	 * ajoute un livre dans la bibliotheque
	 * @param title
	 * @return
	 */
	public Book addBook(String author, String title, String editor, String borrower){
		
		if(author == null) author = "";
		if(title == null) title = "";
		if(editor == null) editor = "";
		if(borrower == null) borrower = "";
		
		Book newBook = new Book();
		newBook.setAuthor(author);
		newBook.setTitle(title);
		newBook.setEditor(editor);
		newBook.setBorrower(borrower);
		Long isbn = generateIsbn();
		newBook.setIsbn(isbn);
		
		books.put(isbn, newBook);
		
		Book bookAdded = books.get(isbn);
		
		return bookAdded;
	}
	
	/**
	 * supprime un livre dans la bibliotheque
	 * @param isbn
	 * @return
	 */
	public boolean removeBook(Long isbn){
		
		if(books.get(isbn) == null){
			return false;
		}
		
		books.remove(isbn);
		return true;
	}

	/**
	 * Consulter la liste des livres selon differents criteres
	 * @param author
	 * @param title
	 * @param editor
	 * @param borrower
	 * @return
	 */
	public List<Book> getBooksCriteria(String author, String title,
			String editor, String borrower) {
		
		List<Book> result = new ArrayList<Book>();
		
		for(Long isbn : books.keySet()){
			Book book = books.get(isbn);
			if(validBook(book) && (book.getAuthor().equals(author)
					||book.getTitle().equals(title)
					||book.getEditor().equals(editor)
					||book.getBorrower().equals(borrower))
					){
				result.add(book);
			}
		}
		
		return result;
	}
	
	/**
	 * Test si un livre a bien été renseigné au niveau de ses champs lors de sa création
	 * @param book
	 * @return
	 */
	private boolean validBook(Book book){
		boolean authorOK = book.getAuthor() != null || book.getAuthor() == "";
		boolean titleOK = book.getTitle() != null || book.getTitle() == "";
		boolean editorOK = book.getEditor() != null || book.getEditor() == "";
		boolean borrowerOK = book.getBorrower() != null || book.getBorrower() == "";
		return authorOK && titleOK && editorOK && borrowerOK;
	}

	/**
	 * Consulter les données associees a un livre a partir de son ISBN
	 * @param isbn l'identifiant d'un livre
	 * @return
	 */
	public String describreBook(Long isbn) {
		
		Book book = books.get(isbn);
		
		if ( book == null) {
			return "unknow book";
		}
		
		return book.toString();
	}

	/**
	 * ajoute un usager de la bibliotheque
	 * @param name
	 * @param age
	 * @param address
	 * @return
	 */
	public User addUser(String name, Integer age, String address) {
		
		if(name == null) name = "";
		if(age == null) age = 0;
		if(address == null) address = "";
		
		User newUser = new User();
		newUser.setName(name);
		newUser.setAge(age);
		newUser.setAddress(address);
		
		Long id = generateId();
		newUser.setId(id);
		
		users.put(id, newUser);
		
		User userAdded = users.get(id);
		
		return userAdded;
	}

	/**
	 * ajoute un usager de la bibliotheque
	 * @param id
	 * @return
	 */
	public Boolean removeUser(Long id) {
		
		if(users.get(id) == null){
			return false;
		}
		
		users.remove(id);
		return true;
	}

	/**
	 * Recupere tout les usagers de la bibliotheque
	 * @return
	 */
	public List<User> getAllUsers() {
		List<User> res = new LinkedList<User>();
		for(Long id : users.keySet()){
			res.add(users.get(id));
		}
		return res;
	}

	/**
	 * Recupere la description d'un usager a partir de son nom
	 * @param name
	 * @return
	 */
	public String describreUser(String name) {
		
		User userFoundByName = null;
		
		for(User user : getAllUsers()){
			if(user.getName() != null && user.getName().equals(name)){
				userFoundByName = user;
				break;
			}
		}
		
		if ( userFoundByName == null) {
			return "unknow user";
		}
		
		return userFoundByName.toString();
	}

}
