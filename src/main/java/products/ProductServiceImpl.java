package products;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	@Override
	public Product addProduct(Product product) throws Exception {
		if (product.getId() != null) {
			throw new Exception("Product already exists !");
		}
		Product newProduct = productRepository.save(product);
		System.err.println("Product: " + newProduct.toString() + "Added");
		return newProduct;
	}

	@Transactional
	@Override
	public Product updateProduct(Long id, Product product) throws Exception {
		Product originProduct = getProduct(id);
		if (originProduct == null) {
			throw new Exception("Product with ID: " + id + "Not Found");
		}
		product.setId(id);
		Product updatedProduct = productRepository.save(product);
		System.err.println("Product Updated to: " + updatedProduct.toString());
		return updatedProduct;
	}

	@Transactional
	@Override
	public void removeProduct(Long id) throws Exception {
		Product originProduct = getProduct(id);
		if (originProduct == null) {
			throw new Exception("Product with ID: " + id + "Not Found");
		}
		productRepository.deleteById(id);
		System.err.println("Product Removed");
	}

	@Transactional
	@Override
	public Product getProduct(Long id) throws Exception {
		Product product = productRepository.findProductById(id);
//		System.err.println("Product: " + product.toString());
//		return product;
		if (product == null) {
			throw new Exception("Product with ID: " + id + "Not Found");
		} else {
			System.err.println("Product: " + product.toString());
			return product;
		}
	}

	@Transactional
	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> allProducts = productRepository.findAll();
		System.err.println("All Products: " + allProducts.toString());
		return allProducts;
	}

}
