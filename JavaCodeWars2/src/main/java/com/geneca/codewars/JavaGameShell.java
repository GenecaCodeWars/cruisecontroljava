package com.geneca.codewars;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.geneca.codewars.data.Command;
import com.geneca.codewars.data.BoardStatus;

/**
 * Servlet to receive request to "take a turn" in the game
 */
@WebServlet(name = "JavaGameShell", urlPatterns = { "/javaGameShell" })
public class JavaGameShell extends HttpServlet {
    
    private Commander _commander; 
    
    public JavaGameShell() {
		_commander = new Commander();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// prepare response
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// get input
		String statusJson = request.getReader().readLine();
    	BoardStatus gameStatus = JsonConverter.convertFromJson(statusJson);
        
    	if (gameStatus.RoundNumber == 0)
			_commander.Reset();
    	
		// give commander status
		_commander.GetBoardStatus(gameStatus);

    	// call commander to "take a turn"
		List<Command> commands = _commander.GiveCommands();
		String gameCommandJsonResult = JsonConverter.convertToJson(commands);

		// write response
		out.print(commands);

		// close up everything
		out.flush();
		out.close();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			doPost(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new JavaGameShell()), "/*");
		server.start();
		server.join();
	}

}
