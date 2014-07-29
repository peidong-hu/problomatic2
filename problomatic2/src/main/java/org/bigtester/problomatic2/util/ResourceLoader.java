package org.bigtester.problomatic2.util;

/**
 * Created by IntelliJ IDEA.
 * User: danstieglitz
 * Date: Feb 17, 2004
 * Time: 9:11:21 PM
 * To change this template use File | Settings | File Templates.
 */

import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ResourceLoader {

    private static final boolean THROW_ON_LOAD_FAILURE = true;
    private static final boolean LOAD_AS_RESOURCE_BUNDLE = false;
    private static final String SUFFIX = ".properties";

    /*
    static public Properties loadProperties(String name) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        if (loader != null) {
            URL url = loader.getResource(name);
            if (url == null) {
                url = loader.getResource("/WEB-INF/classes" + name);
            }
            if (url == null) {
                ResourceBundle bundle = ResourceBundle.getBundle(name);
                     bundle.get
            }
            if (url != null) {
                try {
                    InputStream in = url.openStream();
                    Properties props = new Properties();
                    props.load(in);
                    return props;
                } catch (IOException ioe) {
                    log.error("Unable to load resource " + name);
                }
            }
        }

        return null;
    }
    */
    static public Image loadImage(String name) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        if (loader != null) {
            URL url = loader.getResource(name);
            if (url == null) {
                url = loader.getResource("/" + name);
            }
            if (url != null) {
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = tk.getImage(url);
                return img;
            }
        }

        return null;
    }

     public static Properties loadProperties (String name, ClassLoader loader)
     {
         if (name == null)
             throw new IllegalArgumentException ("null input: name");

         if (name.startsWith ("/"))
             name = name.substring (1);

         if (name.endsWith (SUFFIX))
             name = name.substring (0, name.length () - SUFFIX.length ());

         Properties result = null;

         InputStream in = null;
         try
         {
             if (loader == null) loader = ClassLoader.getSystemClassLoader ();

             if (LOAD_AS_RESOURCE_BUNDLE)
             {
                 name = name.replace ('/', '.');

                 final ResourceBundle rb = ResourceBundle.getBundle (name,
                     Locale.getDefault (), loader);

                 result = new Properties ();
                 for (Enumeration keys = rb.getKeys (); keys.hasMoreElements ();)
                 {
                     final String key = (String) keys.nextElement ();
                     final String value = rb.getString (key);

                     result.put (key, value);
                 }
             }
             else
             {
                 name = name.replace ('.', '/');

                 if (! name.endsWith (SUFFIX))
                     name = name.concat (SUFFIX);

                 // returns null on lookup failures:
                 in = loader.getResourceAsStream (name);
                 if (in != null)
                 {
                     result = new Properties ();
                     result.load (in); // can throw IOException
                 }
             }
         }
         catch (Exception e)
         {
             result = null;
         }
         finally
         {
             if (in != null) try { in.close (); } catch (Throwable ignore) {}
         }

         if (THROW_ON_LOAD_FAILURE && (result == null))
         {
             throw new IllegalArgumentException ("could not load [" + name + "]" +
                 " as " + (LOAD_AS_RESOURCE_BUNDLE
                 ? "a resource bundle"
                 : "a classloader resource"));
         }

         return result;
     }


     public static Properties loadProperties (final String name)
     {
         return loadProperties (name,
             Thread.currentThread ().getContextClassLoader ());
     }


}
