package products;

import java.util.List;

public interface ProductService {

	public Product addProduct(Product product) throws Exception;

	public Product updateProduct(Long id, Product product) throws Exception;

	public void removeProduct(Long id) throws Exception;

	public Product getProduct(Long id) throws Exception;

	public List<Product> getAllProducts() throws Exception;

}
