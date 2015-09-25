/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.List;
import low_level.Book_DAO_Strategy;
import model.Book;
import model.BookStrategy;

/**
 *
 * @author alex
 */
public class BookService {
    
    private Book_DAO_Strategy dao;

    public BookService(Book_DAO_Strategy dao) {
        setDao(dao);
    }

    public Book_DAO_Strategy getDao() {
        return dao;
    }

    public final void setDao(Book_DAO_Strategy dao) {
        this.dao = dao;
    }
    
    public void createBookRecord(List<String> values) throws ClassNotFoundException, SQLException, IllegalArgumentException{
        String title = values.get(1);
        String firstName = values.get(2);
        String lastName = values.get(3);
        String datePublished = values.get(4);
        dao.createBookRecord(new Book(title,firstName,lastName,datePublished));
    }
    
    public void updateBookRecord(List<String> values) throws ClassNotFoundException, SQLException, IllegalArgumentException{ 
        String id = values.get(0);
        String title = values.get(1);
        String firstName = values.get(2);
        String lastName = values.get(3);
        String datePublished = values.get(4);
        dao.createBookRecord(new Book(id, title,firstName,lastName,datePublished));
    }
    
    public List<BookStrategy> getAllRecords() throws ClassNotFoundException, SQLException, IllegalArgumentException{
        return dao.getAllBookRecords();
    }
    
    public void deleteRecords(List values) throws ClassNotFoundException, SQLException, IllegalArgumentException{
        dao.deleteBookRecords(values);
    }
    
    public BookStrategy getRecordById(String id) throws ClassNotFoundException, SQLException, IllegalArgumentException{
        return dao.getBookByID(id);
    }
    
}
