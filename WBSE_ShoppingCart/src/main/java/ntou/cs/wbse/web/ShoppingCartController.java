package ntou.cs.wbse.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ntou.cs.wbse.model.*;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{

		// 取得Session，並設定儲存Product的ArrayList

		HttpSession session = request.getSession();
		ArrayList<Product> products;
		
		if (session.getAttribute("myProducts") == null)
		{
			System.out.println("Create shopping cart!");
			ArrayList<Product> emptyList = new ArrayList<Product>();
			session.setAttribute("myProducts", emptyList);
		}
		else
		{
			System.out.println("Continue to use the shopping cart!");
		}

		products = (ArrayList<Product>) session.getAttribute("myProducts");

		// 取得user parameters，並建立對應Product物件後，儲存至ArrayList中
		String productName = request.getParameter("name");
		int unitPrice = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Product newProduct = new Product(productName, unitPrice, quantity);
		products.add(newProduct);

		// 輸出目前存在Session中的Product
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Session ID: " + session.getId());
		out.println("<hr>");
		out.println(products);	
				
	}
}