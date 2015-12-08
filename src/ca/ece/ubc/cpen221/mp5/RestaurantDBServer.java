package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

// TODO: Implement a server that will instantiate a database, 
// process queries concurrently, etc.

public class RestaurantDBServer {
    private ServerSocket serverSocket;
    private RestaurantDB database;
    
    /**
     * Constructor
     * 
     * @param port
     * @param restaurantsJSONfilename
     * @param reviewsJSONfilename
     * @param usersJSONfilename
     * @throws IOException
     */
    public RestaurantDBServer(int port, String restaurantsJSONfilename, String reviewsJSONfilename,
            String usersJSONfilename) throws IOException {
       database = new RestaurantDB(restaurantsJSONfilename, reviewsJSONfilename, usersJSONfilename);
       
       
    }
    public static void main(String[] args){
        int port = Integer.parseInt(args[0]);
        RestaurantDBServer server;
        try {
            server = new RestaurantDBServer(port, args[1], args[2], args[3]);
            try {
                server.serve();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    /**
     * Run the server, listening for connections and handling them.
     * 
     * @throws IOException
     *             if the main server socket is broken
     */
    public void serve() throws IOException {
        while (true) {
            // block until a client connects
            final Socket socket = serverSocket.accept();
            // create a new thread to handle that client
            Thread handler = new Thread(new Runnable() {
                public void run() {
                    try {
                        try {
                            handle(socket);
                        } finally {
                            socket.close();
                        }
                    } catch (IOException ioe) {
                        // this exception wouldn't terminate serve(),
                        // since we're now on a different thread, but
                        // we still need to handle it
                        ioe.printStackTrace();
                    }
                }
            });
            // start the thread
            handler.start();
        }
    }

    /**
     * Handle one client connection. Returns when client disconnects.
     * 
     * @param socket
     *            socket where client is connected
     * @throws IOException
     *             if connection encounters an error
     */
    private void handle(Socket socket) throws IOException {
        System.err.println("client connected");

        // get the socket's input stream, and wrap converters around it
        // that convert it from a byte stream to a character stream,
        // and that buffer it so that we can read a line at a time
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // similarly, wrap character=>bytestream converter around the
        // socket output stream, and wrap a PrintWriter around that so
        // that we have more convenient ways to write Java primitive
        // types to it.
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        try {
            // each request could be a query or a request
            for (String query = in.readLine(); query != null; query = in.readLine()) {
                System.err.println("request: " + query);
                try {
                    if (query.contains("randomReview")) {
                        int first = query.indexOf("\"");
                        int last = query.lastIndexOf("\"");
                        String restaurantName = query.substring(first +1, last);
                        String response = database.randomReview(restaurantName);
                        System.err.println("reply: " + response);
                        out.println(response);
                    }
                    if (query.contains("getRestaurant")) {
                        int first = query.indexOf("\"");
                        int last = query.lastIndexOf("\"");
                        String businessID = query.substring(first +1, last);
                        String response = database.getRestaurant(businessID);
                        System.err.println("reply: " + response);
                        out.println(response);

                    }
                    if (query.contains("addRestaurant")) {
                        int first = query.indexOf("\"");
                        int last = query.lastIndexOf("\"");
                        String JSONrestaurant = query.substring(first +1, last);
                        String response = database.getRestaurant(JSONrestaurant);
                        System.err.println("reply: " + response);
                        out.println(response);

                    }
                    if (query.contains("addUser")) {
                        int first = query.indexOf("\"");
                        int last = query.lastIndexOf("\"");
                        String JSONuser = query.substring(first +1, last);
                        String response = database.getRestaurant(JSONuser);
                        System.err.println("reply: " + response);
                        out.println(response);
                    }
                    if (query.contains("addReview")) {
                        int first = query.indexOf("\"");
                        int last = query.lastIndexOf("\"");
                        String JSONreview = query.substring(first +1, last);
                        String response = database.getRestaurant(JSONreview);
                        System.err.println("reply: " + response);
                        out.println(response);
                    } else {
                        Set<Restaurant> response = database.query(query);
                    }
                    
                } catch (NumberFormatException e) {
                    // complain about ill-formatted request
                    System.err.println("reply: err");
                    out.print("err\n");
                }
                // important! our PrintWriter is auto-flushing, but if it were
                // not:
                // out.flush();
            }
        } finally {
            out.close();
            in.close();
        }
    }

    public static Query parse(String string) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(string);
        GrammarLexer lexer = new GrammarLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);

        // Feed the tokens into the parser.
        GrammarParser parser = new GrammarParser(tokens);
        parser.reportErrorsAsExceptions();

        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.grammar(); // "root" is the starter rule.

        // debugging option #1: print the tree to the console
        System.err.println(tree.toStringTree(parser));

        // debugging option #2: show the tree in a window
        ((RuleContext) tree).inspect(parser);

        // debugging option #3: walk the tree with a listener
        new ParseTreeWalker().walk(new GrammarListener_PrintEverything(), tree);

        // Finally, construct a Document value by walking over the parse tree.
        ParseTreeWalker walker = new ParseTreeWalker();
        GrammarListener_GrammarCreator listener = new GrammarListener_GrammarCreator();
        walker.walk(listener, tree);

        // return the Document value that the listener created
        return listener.getGrammar();
    }
}