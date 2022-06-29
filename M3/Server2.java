/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer;

/**
 *
 * @author HP
 */
// Server2 class that
// receives data and sends data
import java.io.*;
import java.net.*;

class Server2 {

    public static void main(String args[])
            throws Exception {

        // Create server Socket
        ServerSocket ss = new ServerSocket(888);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connected Sucessfully");

        PrintStream ps
                = new PrintStream(s.getOutputStream());

        BufferedReader br
                = new BufferedReader(
                        new InputStreamReader(
                                s.getInputStream()));

        BufferedReader kb
                = new BufferedReader(
                        new InputStreamReader(System.in));

       
        while (true) {

            String str, str1;
        System.out.println("This Is Server SIde Side");

           
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                str1 = kb.readLine();

                ps.println(str1);
            }

            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }
}
