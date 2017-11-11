/**
 * 
 */
package com.webservices;

import java.util.List;

import com.webservices.dto.Book;
import com.webservices.dto.Library;
import com.webservices.dto.User;

/**
 * @author tarik Djebien
 * WebService de gestion d'une bibliothèque
 * Le bibliothécaire peut :
 */
public class LibrarianWebService {
	
	/**
	 * dire bonjour
	 * @param name
	 * @return
	 */
	public String sayHello(String name){
		return "Hello "+name;
	}
	
	/*
	 * GESTION DES LIVRES
	 */
	
	/**
	 * ajouter un nouveau livre
	 * @param title
	 * @return
	 */
	public Book addBook(String author, String title, String editor, String borrower){
		return Library.getInstance().addBook(author, title, editor, borrower);
	}
	
	/**
	 * supprimer un livre
	 * @param isbn
	 * @return
	 */
	public Boolean deleteBook(Long isbn){
		return Library.getInstance().removeBook(isbn);
	}
	
	/**
	 * consulter la liste des livres selon differents criteres
	 * @param author auteur
	 * @param title titre
	 * @param editor editeur
	 * @param borrower emprunteur
	 * @return
	 */
	public List<Book> getBooks(String author, String title, String editor, String borrower){
		return Library.getInstance().getBooksCriteria(author,title,editor,borrower);
	}
	
	/**
	 * consulter les donnees associees a un livre a partir de son ISBN
	 * @param isbn
	 * @return
	 */
	public String getBookDescription(Long isbn){
		return Library.getInstance().describreBook(isbn);
	}
	
	/*
	 * GESTION DES USAGERS
	 */
	
	/**
	 * ajouter un nouvel usager
	 * @param name
	 * @param age
	 * @param address
	 * @return
	 */
	public User addUser(String name, Integer age, String address){
		return Library.getInstance().addUser(name, age, address);
	}
	
	/**
	 * supprimer un usager
	 * @param id
	 * @return
	 */
	public Boolean deleteUser(Long id){
		return Library.getInstance().removeUser(id);
	}
	
	/**
	 * consulter la liste des usagers
	 * @return
	 */
	public List<User> getUsers(){
		return Library.getInstance().getAllUsers();
	}
	
	/**
	 * consulter les donnees associees a un usager a partir de son nom
	 * @param isbn
	 * @return
	 */
	public String getUserDescription(String name){
		return Library.getInstance().describreUser(name);
	}
	

}
