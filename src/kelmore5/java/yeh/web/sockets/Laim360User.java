package kelmore5.java.yeh.web.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
public class Laim360User {

    private String name;
    private Socket connection;
    private Scanner in;
    private PrintWriter out;

    private Laim360User ( String _name , Socket _s) throws IOException {
        name = _name;
        connection = _s;

        out = new PrintWriter(connection.getOutputStream() , true);
        in = new Scanner(connection.getInputStream());

        out.println( name );
        //noinspection StatementWithEmptyBody
        while (!in.hasNextLine());
        String response = in.nextLine();
        if (response.equals("no")) {
            System.out.println( name + " has already connected.  Please re-connect with a new name." );
            throw new IOException();
        }
    }

    private void go () throws IOException {
        Thread t = new Thread(new Listener( ));
        t.start();

        String msg = "";
        while ( msg != null && !msg.equalsIgnoreCase("bye") ) {
            msg = JOptionPane.showInputDialog( name + ": send message" );
            out.println( msg );
        }
        if ( !connection.isClosed() ) {
            connection.close();
        }
    }

    private class Listener implements Runnable {

        public void run() {

            while ( true ) {
                while ( !in.hasNextLine() ) {
                    if ( connection == null || connection.isClosed() ) return;
                }
                System.out.println ( in.nextLine() );
            }
        }
    }

    // Command-line syntax java host username
    public static void main ( String[] args ) {
        if ( args.length < 2 ) {
            System.out.println( "please enter host and username at command line" );
            return;
        }
        try {
            Socket connection = new Socket ( args[0] , Laim360Server.PORT );
            Laim360User user = new Laim360User( args[1] , connection );
            user.go();
        }
        catch (IOException e) {
            System.out.println ("lost connection.  Goodbye.");
        }
    }
}