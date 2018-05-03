package def;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		
		User user=new User();
		user.setmUsername(u);
		user.setmPassword(p);
		int i=new RegisterImp().registerUser(user);
		if(i>0) {
			System.out.println("registered successfully");
			try {
				JSONObject obj=new JSONObject();
				obj.put("Register", "Success");
				PrintWriter pw=resp.getWriter();
				pw.write(obj.toString());
				pw.println(obj.toString());
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			System.out.println("registered unsuccessfull");
			try {
				JSONObject obj=new JSONObject();
				obj.put("Register", "Failure");
				PrintWriter pw=resp.getWriter();
				pw.write(obj.toString());
				pw.println(obj.toString());
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
