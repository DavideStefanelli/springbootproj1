package sys.components;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sys.dtos.ProductDTO;
import sys.entities.ProductEntity;
import sys.services.ShopService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ShopService shopService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/{shopId}/products")
    public List<ProductDTO> getProducts(@PathVariable("shopId") Integer shopId){
        List<ProductEntity> shopProducts = shopService.getShopProducts(shopId);
        return shopProducts.stream()
                .map(product -> product.toDto(modelMapper, ProductDTO.class))
                .collect(Collectors.toList());
    }

}
