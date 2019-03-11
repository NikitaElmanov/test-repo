package ru.jndi.project;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class Monkey implements Referenceable {
    public static final String NAME = "name";
    public static final String FAVORITE_FRUIT = "favoriteFruit";
    public static final String LIKED_BANANAS = "likedBananas";

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
        Reference reference = new Reference(Monkey.class.getName(), MonkeyFactory.class.getName(), null);

        reference.add(new StringRefAddr(NAME, this.name));
        reference.add(new StringRefAddr(FAVORITE_FRUIT , this.favoriteFruit));
        reference.add(new StringRefAddr(LIKED_BANANAS , Boolean.toString(this.likedBananas)));

        return reference;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", favoriteFruit='" + favoriteFruit + '\'' +
                ", likedBananas=" + likedBananas +
                '}';
    }
}
