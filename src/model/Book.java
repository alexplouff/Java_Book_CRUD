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

    public Book(String id, String title, String authorFirstName, String authorLastName, String datePublished) {
        setId(id);
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setDatePublished(datePublished);
    }
    
    public Book(String title, String authorFirstName, String authorLastName, String datePublished) {
        setId(id);
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
    public String getDatePublished() {
        return datePublished;
    }

    public final void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
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
        
    }
    
    
}
