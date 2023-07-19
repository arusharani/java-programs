package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductsController {
	@Autowired
	private ProductRepo ProRepo;

	@GetMapping("/prod")
	public List<Products> getAll() {
		return ProRepo.findAll();
	}

	@DeleteMapping("/prod/{id}")
	public void deleteProductsByCode(@PathVariable("id") int id) {
		var pro = ProRepo.findById(id);
		if (pro != null) {

			ProRepo.deleteById(id);

		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");

	}

	@PutMapping("/prd/{id}/{price}/{name}")
	public Products updateProducts(@PathVariable("id") int id, @PathVariable("price") double price,
			@PathVariable("name") String name) {
		var p = ProRepo.findById(id);
		if (p.isPresent()) {
			var prod = p.get();
			prod.setProdname(name);
			prod.setPrice(price);
			ProRepo.save(prod);
			return prod;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");

	}

	@PostMapping("/addprd")
	public Products addProduct(@RequestBody Products product) {
		try {
			ProRepo.save(product);
			return product;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data!");
		}
	}
		
		//1
		@PostMapping("/addprod")
		public Products addProducts(@RequestBody Products product) {
			var p = ProRepo.findById(product.getProdid());
			if(p.isPresent()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "prodid already present");
				
			}
			else {
				ProRepo.save(product);
				return product;
			}
		}

}
