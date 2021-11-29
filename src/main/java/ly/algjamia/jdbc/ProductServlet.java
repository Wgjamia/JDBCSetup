package ly.algjamia.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class editProduct
 */
@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/view" :
				showEditForm(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			case "/delete":
				deleteProduct(request, response);
			case "/list":
				showProduct(request, response);
				break;
			case "/add":
				addProduct(request,response);
				break;
			default :
				showProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product pro = selectPro(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		request.setAttribute("pro", pro);
		dispatcher.forward(request, response);

	}
	public Product selectPro(int id) throws IOException {
		Product pro = new Product();
		String sqlselect = "select id,name,price,date_added from eproduct where id=? ";
		Properties properties = new Properties();
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		try(
				Connection connection = DBConn.getConnection(properties);
				PreparedStatement pstmt = connection.prepareStatement(sqlselect);
				) {
					pstmt.setInt(1, id);
			
				ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pro.setPrID(Integer.parseInt(rs.getString("id")));
				pro.setPrName(rs.getString("name"));
				pro.setPrPrice(Float.parseFloat(rs.getString("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
 	protected void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Product pro = new Product();
 		pro.setPrID(Integer.parseInt(request.getParameter("id")));
		pro.setPrName( request.getParameter("pname"));
		pro.setPrPrice(Float.parseFloat(request.getParameter("pprice")));
		String sqlUpdate = "update eproduct set name=? ,price=? where id=? ";
		Properties properties = new Properties();
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		try(
				Connection connection = DBConn.getConnection(properties);
				PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
				) {
					pstmt.setString(1, pro.getPrName());
					pstmt.setFloat(2, pro.getPrPrice());
					pstmt.setInt(3, pro.getPrID());
					pstmt.executeUpdate();
					response.sendRedirect("list");
			      	connection.close();
			      	pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
 	
 	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Product pro = new Product();
 		pro.setPrID(Integer.parseInt(request.getParameter("id")));
		String sqlDelete = "delete from eproduct where id=?";
		
		Properties properties = new Properties();
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		try(
				Connection connection = DBConn.getConnection(properties);
				PreparedStatement pstmt = connection.prepareStatement(sqlDelete);
				) {
					pstmt.setInt(1, pro.getPrID());
					pstmt.executeUpdate();
					
			      	connection.close();
			      	pstmt.close();
			      
			      	
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
 	
 	protected void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		List<Product> list =new ArrayList<Product>();
		String sqlselect = "select id,name,price,date_added from eproduct order by id";
		Properties properties = new Properties();
		Product pro = null;
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		try(
				Connection connection = DBConn.getConnection(properties);
				Statement st = connection.createStatement();
				) {
			ResultSet rs = st.executeQuery(sqlselect);
			while(rs.next()){
				pro = new Product();
				pro.setPrID(rs.getInt("id"));  
	            pro.setPrName(rs.getString("name"));  
	            pro.setPrPrice(rs.getFloat("price"));
	            pro.setPrDate(rs.getDate("date_added"));
				list.add(pro);
	            
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			request.setAttribute("list", list);
			dispatcher.forward(request, response);
			connection.close();
			st.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
 	protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product pro = new Product();
		pro.setPrName( request.getParameter("pname"));
		pro.setPrPrice(Float.parseFloat(request.getParameter("pprice")));
		String sqlInsert = "insert into eproduct(name,price) values(?,?)";
		Properties properties = new Properties();
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		try(
				Connection connection = DBConn.getConnection(properties);
				PreparedStatement pstmt = connection.prepareStatement(sqlInsert);
				) {
					pstmt.setString(1, pro.getPrName());
					pstmt.setFloat(2, pro.getPrPrice());
					pstmt.executeUpdate();
			      	
			      	connection.close();
			      	pstmt.close();
			      	response.sendRedirect("list");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
