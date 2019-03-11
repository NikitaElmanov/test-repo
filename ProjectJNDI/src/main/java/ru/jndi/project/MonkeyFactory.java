package ru.jndi.project;

import javax.naming.*;
import javax.naming.spi.ObjectFactory;
import java.util.Enumeration;
import java.util.Hashtable;

public class MonkeyFactory implements ObjectFactory {
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        if (!(obj instanceof Reference)){
            return null;
        }

        Reference reference = (Reference) obj;

        if (!Monkey.class.getName().equals(reference.getClassName())){
            return null;
        }

        Monkey monkey = new Monkey();

        Enumeration<RefAddr> addresses = reference.getAll();

        while(addresses.hasMoreElements()){
            RefAddr refAddr = addresses.nextElement();

            switch(refAddr.getType()){
                case Monkey.NAME:
                    monkey.setName((String) refAddr.getContent());
                    break;
                case Monkey.FAVORITE_FRUIT:
                    monkey.setFavoriteFruit((String) refAddr.getContent());
                    break;
                case Monkey.LIKED_BANANAS:
                    monkey.setLikedBananas(Boolean.valueOf((String) refAddr.getContent()));
                    break;
            }
        }
        return monkey;
    }
}
