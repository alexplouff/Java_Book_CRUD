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
public class Book_DAO {
    
    private DatabaseAccessorStrategy accessor;
    private static final String DATABASE_TABLE = "Book.bookInfo";
    private static final String PRIMARY_KEY_COLUMN = "bookID";
    private static final String NULL_REPLACEMENT_VALUE = "Not Entered";
    
    public Book_DAO(SQL_Accessor accessor){
        setAccessor(accessor);
    }

    public DatabaseAccessorStrategy getAccessor() {
        return accessor;
    }

    public final void setAccessor(DatabaseAccessorStrategy accessor) {
        this.accessor = accessor;
    }
    
    public BookStrategy getBookByID(String id) throws SQLException, ClassNotFoundException{
        BookStrategy book = null;
        if (id != null && id.matches("\\d+")) {
            List<Map<String, Object>> recordValues;

            String whereClause = " WHERE " + PRIMARY_KEY_COLUMN + " = " + id;
            recordValues
                    = new ArrayList(
                            accessor.getRecords(DATABASE_TABLE.concat(whereClause)));

            for (Map<String, Object> value : recordValues) {
                Object o = value.get("bookID");
                int bookID = (o == null) ? 0 : Integer.valueOf(o.toString());
                o = value.get("title");
                String bookTitle = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
                o = value.get("authorFirstName");
                String firstName = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
                o = value.get("authorLastName");
                String lastName = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();
                o = value.get("datePublished");
                String datePublished = (o == null) ? NULL_REPLACEMENT_VALUE : o.toString();

                book= new Book(bookID, bookTitle, firstName, lastName, datePublished);
            }
            } else {
            throw new IllegalArgumentException("Bad Input, Numbers Only");
        }

        return book;
    }
}
