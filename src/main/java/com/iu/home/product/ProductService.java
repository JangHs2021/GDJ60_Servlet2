package com.iu.home.product;

import java.util.List;

public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService() {
		this.productDAO = new ProductDAO();
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option 
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setAddProduct(productDTO);
		
		for(ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);			
		}
		
		return result; 
	}
	

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOptionName("optionName1");
		productOptionDTO.setOptionPrice(100);
		productOptionDTO.setOptionStock(10);
		productOptionDTO.setProductNum(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOptionName("optionName2");
		productOptionDTO2.setOptionPrice(200);
		productOptionDTO2.setOptionStock(20);
		productOptionDTO2.setProductNum(null);
		
		try {
			Long num = productDAO.getProductNum();
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);

			productOptionDTO.setProductNum(num);
			
			if(result > 0) {
				productDAO.setAddProductOption(productOptionDTO2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
