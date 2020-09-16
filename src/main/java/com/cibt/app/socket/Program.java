
import com.cibt.app.socket.DAO.UserDAO;
import com.cibt.app.socket.Entity.User;
import com.cibt.app.socket.Handler.Client;
import com.cibt.app.socket.Handler.ClientHandler;
import com.cibt.app.socket.Handler.ClientListner;
import com.cibt.app.socket.impl.UserDAOimpl;
import com.cibt.app.socket.loader.UserDataLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import sun.net.www.http.ChunkedOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Program {

    public static void main(String[] args) {

        try {
            int port = 8200;
            System.out.println("our server is running at" + port);
            ServerSocket server = new ServerSocket(port);
            UserDAO userDAO=new UserDAOimpl();
            ClientHandler handler=new ClientHandler();
            UserDataLoader.loadData(userDAO);
            while (true) {

                Socket socket = server.accept();
                
                ClientListner user = new ClientListner(socket);
                user.init(userDAO, handler);
               
                user.start();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
