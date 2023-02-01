package com.iu.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private ProductService productService;
	private ProductDTO productDTO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productDAO = new ProductDAO();
        productService = new ProductService();
        productDTO = new ProductDTO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Product page");
		
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1);
		System.out.println("URI : " + uri);
		
		if(uri.equals("list.do")) {
			try {
				List<ProductDTO> ar = productService.getProductList();
				request.setAttribute("list", ar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			uri = "productList.jsp";
			System.out.println("list");
		} else if(uri.equals("add.do")) {
			uri = "productAdd.jsp";
			System.out.println("add");
		} else if(uri.equals("update.do")) {
			uri = "productUpdate.jsp";
			System.out.println("update");
		} else if(uri.equals("delete.do")) {
			System.out.println("delete");
		} else if(uri.equals("detail.do")) {
			
			Long ProductNum = Long.parseLong(request.getParameter("productNum"));
			
			productDTO.setProductNum(ProductNum);
			
			try {
				productDTO = productService.getProductDetail(productDTO);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			uri = "productDetail.jsp";
			System.out.println("detail");
		} else {
			System.out.println("X");
		}
		
//		switch(uri) {
//		case "list.do":
//			break;
//		}
		
//		String name = request.getParameter("name");
//		String detail = request.getParameter("detail");
////		int p = 0;
////		if(price != null) {
////			p = Integer.parseInt(price);
////		}
//		
//		System.out.println("Name : " + name);
//		System.out.println("Detail : " + detail);
////		System.out.println("Price : " + p);
//		
//		productDTO.setProductName(name);
//		productDTO.setProductDetail(detail);
//		
//		// ------------------------------
//		try {
//			int result = productService.setAddProduct(productDTO, new ArrayList<ProductOptionDTO>());
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// ------------------------------
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/" + uri);
		view.forward(request, response);
		
//		try {
//			List<ProductDTO> ar = productDAO.getProductList();
//			
//			PrintWriter out = response.getWriter();
//			
//			for(int i = 0; i < ar.size(); i++) {
//				out.println("<h1>" + ar.get(i).getProductName() + "</h1>");
//			}
//			
//			out.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
