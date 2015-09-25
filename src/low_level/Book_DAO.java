/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package low_level;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Book;
import model.BookStrategy;

/**
 *
 * @author alex
 */
public class Book_DAO implements Book_DAO_Strategy {

    private DatabaseAccessorStrategy accessor;
    private static final String DATABASE_TABLE = "Book.bookInfo";
    private static final String PRIMARY_KEY_COLUMN = "bookID";
    private static final String TITLE_COLUMN = "title";
    private static final String FIRST_NAME_COLUMN = "authorFirstName";
    private static final String LAST_NAME_COLUMN = "authorLastName";
    private static final String DATE_PUBLISHED_COLUMN = "datePublished";
    private static final String NULL_REPLACEMENT_VALUE = "Not Entered";
    private List listOfColumns;

    public Book_DAO(SQL_Accessor accessor) {
        setAccessor(accessor);
        listOfColumns = new ArrayList();
        listOfColumns.add(PRIMARY_KEY_COLUMN);
        listOfColumns.add(TITLE_COLUMN);
        listOfColumns.add(FIRST_NAME_COLUMN);
        listOfColumns.add(LAST_NAME_COLUMN);
        listOfColumns.add(DATE_PUBLISHED_COLUMN);
    }

    public DatabaseAccessorStrategy getAccessor() {
        return accessor;
    }

    public final void setAccessor(DatabaseAccessorStrategy accessor) {
        this.accessor = accessor;
    }

    @Override
    public BookStrategy getBookByID(String id) throws SQLException, ClassNotFoundException,IllegalArgumentException {
        BookStrategy book = null;
        if (id != null && id.matches("\\d+")) {
             
            List<Map<String, Object>> recordValues;

            String whereClause = " WHERE " + PRIMARY_KEY_COLUMN + " = " + id;
            recordValues
                    = new ArrayList(
                            accessor.getRecords(DATABASE_TABLE.concat(whereClause)));

            for (Map<String, Object> value : recordValues) {
                Object o = value.get("bookID");
                String bookID = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString(); //Integer Conversion Done in Model
                o = value.get("title");
                String bookTitle = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
                o = value.get("authorFirstName");
                String firstName = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
                o = value.get("authorLastName");
                String lastName = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
                o = value.get("datePublished");
                String datePublished = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();

                book = new Book(bookID, bookTitle, firstName, lastName, datePublished);
            }
        } else {
            throw new IllegalArgumentException("Bad Input, Numbers Only");
        }

        return book;
    }

    @Override
    public List<BookStrategy> getAllBookRecords() throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> bookRecords = new ArrayList(accessor.getRecords(DATABASE_TABLE));
        List<BookStrategy> listOfBooks = new ArrayList<>();
        for (Map<String, Object> value : bookRecords) {
            Object o = value.get(PRIMARY_KEY_COLUMN);
            String bookID = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
            o = value.get(TITLE_COLUMN);
            String title = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
            o = value.get(FIRST_NAME_COLUMN);
            String firstName = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
            o = value.get(LAST_NAME_COLUMN);
            String lastName = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
            o = value.get(DATE_PUBLISHED_COLUMN);
            String date = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString(); // Conversion happens in model

            listOfBooks.add(new Book(bookID, title, firstName, lastName, date));

        }
        return listOfBooks;
    }

    /* 
        Pass in List of Strings or book object
    */
    
    @Override
    public void createBookRecord(BookStrategy book) throws SQLException, ClassNotFoundException,IllegalArgumentException {
        List values = new ArrayList<>();
        if (book != null) {
            values.remove(PRIMARY_KEY_COLUMN);
            values.add(book.getTitle());
            values.add(book.getAuthorFirstName());
            values.add(book.getAuthorLastName());
            values.add(book.getDatePublished());
            accessor.createRecord(DATABASE_TABLE, listOfColumns, values);
        } else {
            throw new IllegalArgumentException("Record Was Not Created");
        }

    }
    
    @Override
    public void updateBookRecord(BookStrategy book) throws SQLException, ClassNotFoundException,IllegalArgumentException{
        if(book != null){
            List values = new ArrayList<>();
            values.add(book.getId());
            values.add(book.getTitle());
            values.add(book.getAuthorFirstName());
            values.add(book.getAuthorLastName());
            values.add(book.getDatePublished());
            
            accessor.updateRecord(DATABASE_TABLE, listOfColumns, values, PRIMARY_KEY_COLUMN, book.getId());
            
        } else {
            throw new IllegalArgumentException("Record Was Not Updated");
        }
    }
    
    @Override
    public void deleteBookRecords(List primaryKeys) throws SQLException, ClassNotFoundException,IllegalArgumentException{
        if( primaryKeys.size() > 0 ){
            accessor.deleteRecords(DATABASE_TABLE, PRIMARY_KEY_COLUMN, primaryKeys);
        } else {
            throw new IllegalArgumentException("Record(s) Were Not Deleted");
        }
                
    }
}
