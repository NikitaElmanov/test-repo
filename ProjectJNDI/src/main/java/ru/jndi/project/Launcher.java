package ru.jndi.project;

import javax.naming.*;
import java.io.File;
import java.util.Hashtable;

public class Launcher {
    public static void main(String[] args) throws NamingException {

        Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        environment.put(Context.PROVIDER_URL, "file:\\D:\\GitHub\\repository\\test-repo");

        Context context = new InitialContext(environment);

        Monkey steven = new Monkey("Steven", "Banana", true);
        Monkey lola = new Monkey("Lola", "Orange", false);

        context.rebind("steven", steven);
        context.rebind("lola", lola);

        NamingEnumeration<Binding> data = context.listBindings("ProjectJNDI");

        while(data.hasMore()){
            Binding binding = data.next();
            System.out.format("%s | %s ", binding.getName(), binding.getClassName());

            if (binding.getObject() instanceof File){
                System.out.format(" size %s bytes", ((File)binding.getObject()).length());
            }

            System.out.println();
        }

//        Object monkeySteven = context.lookup("steven");
////        Object monkeyLola = context.lookup("Lola");
//
//        System.out.println(monkeySteven);

    }
}
