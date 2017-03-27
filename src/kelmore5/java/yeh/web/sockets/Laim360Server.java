package kelmore5.java.yeh.web.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
public class Laim360Server {

    static final int PORT = 2007;
    private Map<String,PrintWriter> ostreams;
    private Map<String,Socket> sockets;

    private Laim360Server () throws IOException {
        ostreams = new HashMap<>();
        sockets = new HashMap<>();
        ServerSocket ss = new ServerSocket( PORT );


        //noinspection InfiniteLoopStatement
        while ( true ) {
            Socket connection = ss.accept();
            Scanner in = new Scanner(connection.getInputStream());
            PrintWriter pw = new PrintWriter( connection.getOutputStream() , true);

            //noinspection StatementWithEmptyBody
            while (!in.hasNextLine());
            String user = in.nextLine();

            if ( sockets.get( user ) != null ) {
                pw.println( "no" );
            }
            else {
                pw.println( "yes" );
                sockets.put( user , connection );
                ostreams.put( user , pw );
                Thread t = new Thread( new Listener( user , in , pw ) );
                t.start();
            }
        }
    }



    private class Listener implements Runnable {

        private String id;
        private Scanner in;
        private PrintWriter out;
        Listener ( String _id , Scanner _in , PrintWriter _out ) {
            id = _id;
            in = _in;
            out = _out;
        }

        private void broadcast ( String msg ) throws IOException {
            for (PrintWriter printWriter : ostreams.values()) {
                printWriter.println(msg);
            }
        }

        public void run() {

            try {
                String msg = "";
                while ( !msg.equalsIgnoreCase ( "bye" ) ) {
                    //noinspection StatementWithEmptyBody
                    while ( !in.hasNextLine() );
                    msg = in.nextLine();
                    broadcast ( id + ": " + msg );
                }
                out.println ( "goodbye, " + id );
                Socket connection = sockets.get( id );
                if ( !connection.isClosed() ) {
                    connection.close();
                }
            }
            catch (IOException e) {
                System.out.println(e.toString());
            }
            ostreams.remove( id );
            sockets.remove( id );

        }
    }

    public static void main (String[] args) {


        try {
            new Laim360Server( );
        }
        catch (IOException e) {
            System.out.println ( "lost connection.  Goodbye." );
        }
    }
}