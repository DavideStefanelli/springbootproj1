package sys.components;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sys.dtos.ProductDetailDTO;
import sys.entities.ProductEntity;
import sys.services.IProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{id}/detail")
    public ProductDetailDTO getProductDetail(@PathVariable("id") Integer id){
        ProductEntity productEntity = productService.getProductById(id);
        return modelMapper.map(productEntity, ProductDetailDTO.class);
    }

}
