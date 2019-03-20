package products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product product) throws Exception {
		Product addedProduct = productService.addProduct(product);
		return addedProduct;
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
		Product productFound = productService.updateProduct(id, product);
		return productFound;
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void removeProduct(@PathVariable Long id) throws Exception {
		productService.removeProduct(id);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable Long id) throws Exception {
		Product productFound = productService.getProduct(id);
		return productFound;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts() throws Exception {
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}

}
