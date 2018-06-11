package sys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService implements IHomeService {

    private ShopService shopService;

    @Autowired
    public void setHomeService(ShopService shopService){
        this.shopService = shopService;
    }



}
