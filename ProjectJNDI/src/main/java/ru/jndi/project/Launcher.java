package ru.jndi.project;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Launcher {
    public static void main(String[] args) throws NamingException {

        Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        environment.put(Context.PROVIDER_URL, "file:\\D:\\GitHub\\repository\\test-repo\\ProjectJNDI");

        Context context = new InitialContext(environment);

        Monkey steven = new Monkey("Steven", "Banana", true);
        Monkey lola = new Monkey("Lola", "Orange", false);

        context.rebind("Lola", lola);
        context.unbind("Steven");

    }
}
