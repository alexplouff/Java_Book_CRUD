/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alex
 */
public class Book implements BookStrategy{
    
    private String title, authorFirstName, authorLastName;
    private Date datePublished;
    private int id;

    public Book(String id, String title, String authorFirstName, String authorLastName, String datePublished) throws ParseException{
        setId(id);
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setDatePublished(datePublished);
    }
    
    public Book(String title, String authorFirstName, String authorLastName, String datePublished) throws ParseException {
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setDatePublished(datePublished);
    }
    
    

    @Override
    public String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public final void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    @Override
    public String getAuthorLastName() {
        return authorLastName;
    }

    public final void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    @Override
    public Date getDatePublished() {
        return datePublished;
    }

    public final void setDatePublished(String datePublished) throws IllegalArgumentException, ParseException {
        if(datePublished != null){
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(datePublished);
            this.datePublished = date;
        } else {
            throw new IllegalArgumentException("Date Could Not Be Parsed");
        }
        
    }

    @Override
    public int getId() {
        return id;
    }

    public final void setId(String id) {
        if(id.matches("\\d+")){ this.id = Integer.valueOf(id);}
        else{
            throw new IllegalArgumentException("String Id Was Not Converted");
        }
    }
    
    public final void setId(int id){
        this.id=id;
    }
    
    public String toString(){
        return "Book ID: " + id + 
                "\nTitle: " + title +
                "\nAuthor First Name: " + authorFirstName + 
                "\nAuthor Last Name: " + authorLastName + 
                "\nDate Published: " + datePublished;
    }
    
}
