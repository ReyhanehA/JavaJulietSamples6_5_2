/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Servlet_console_readLine_15.java
Label Definition File: CWE90_LDAP_Injection__Servlet.label.xml
Template File: sources-sink-15.tmpl.java
*/
/*
* @description
* CWE: 90 LDAP Injection
* BadSource: console_readLine Read data from the console using readLine
* GoodSource: A hardcoded string
* BadSink:  unchecked data leads to LDAP injection
* Flow Variant: 15 Control flow: switch(6)
*
* */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.http.*;

import java.util.Hashtable;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE90_LDAP_Injection__Servlet_console_readLine_15 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* read user input from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        String search = "(cn=" + data + ")"; /* POTENTIAL FLAW: unsanitized data from untrusted source */

        NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    response.getWriter().println(" Value: " + values.next().toString());
                }
            }
        }

    }

    /* goodG2B1() - use goodsource and badsink by changing the  switch to switch(5) */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* read user input from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }
            }
        }
        break;
        default:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        String search = "(cn=" + data + ")"; /* POTENTIAL FLAW: unsanitized data from untrusted source */

        NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    response.getWriter().println(" Value: " + values.next().toString());
                }
            }
        }

    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the switch  */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* read user input from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }
            }
        }
        break;
        }

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        String search = "(cn=" + data + ")"; /* POTENTIAL FLAW: unsanitized data from untrusted source */

        NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    response.getWriter().println(" Value: " + values.next().toString());
                }
            }
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}