package ru.jndi.project;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class Monkey implements Referenceable {
    private String name;
    private String favoriteFruit;
    private boolean likedBananas;

    public Monkey() {
    }

    public Monkey(String name, String favoriteFruit, boolean likedBananas) {
        this.name = name;
        this.favoriteFruit = favoriteFruit;
        this.likedBananas = likedBananas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    public boolean isLikedBananas() {
        return likedBananas;
    }

    public void setLikedBananas(boolean likedBananas) {
        this.likedBananas = likedBananas;
    }

    public Reference getReference() throws NamingException {
        Reference reference = new Reference(Monkey.class.getName());

        reference.add(new StringRefAddr("name", this.name));
        reference.add(new StringRefAddr("favoriteFruit", this.favoriteFruit));
        reference.add(new StringRefAddr("likedBananas", Boolean.toString(this.likedBananas)));

        return reference;
    }
}
