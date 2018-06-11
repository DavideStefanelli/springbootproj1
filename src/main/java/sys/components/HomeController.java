package sys.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sys.dtos.ProductDTO;
import sys.services.IHomeService;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {

    @Autowired
    private IHomeService homeService;

    @RequestMapping(value = "/getFeaturedProducts", method = RequestMethod.GET)
    public List<ProductDTO> getFeaturedProducts(){
        return null;
    }

}
