/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alex
 */
public class Book implements BookStrategy{
    
    private String title, authorFirstName, authorLastName, datePublished;
    private int id;

    public Book(int id, String title, String authorFirstName, String authorLastName, String datePublished) {
        setId(id);
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setDatePublished(datePublished);
    }
    
    

    public String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public final void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public final void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public final void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }
    
    
}
