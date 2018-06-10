package sys.entities;

import org.modelmapper.ModelMapper;
import sys.dtos.BasicDTO;

public abstract class BasicEntity {

    public <T extends BasicDTO> T toDto(ModelMapper modelmapper, Class<T> outType) {
        return modelmapper.map(this, outType);
    }

}
