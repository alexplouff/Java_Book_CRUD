/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package low_level;

import java.sql.SQLException;
import java.util.List;
import model.BookStrategy;

/**
 *
 * @author alex
 */
public interface Book_DAO_Strategy {

    public abstract void createBookRecord(BookStrategy book) throws SQLException, ClassNotFoundException, IllegalArgumentException;

    public abstract void deleteBookRecords(List primaryKeys) throws SQLException, ClassNotFoundException, IllegalArgumentException;

    public abstract List<BookStrategy> getAllBookRecords() throws SQLException, ClassNotFoundException;

    public abstract BookStrategy getBookByID(String id) throws SQLException, ClassNotFoundException, IllegalArgumentException;

    public abstract void updateBookRecord(BookStrategy book) throws SQLException, ClassNotFoundException, IllegalArgumentException;
    
}
