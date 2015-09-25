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
public interface BookStrategy {

    public abstract String getAuthorFirstName();

    public abstract String getAuthorLastName();

    public abstract String getDatePublished();

    public abstract int getId();

    public abstract String getTitle();
    
}
