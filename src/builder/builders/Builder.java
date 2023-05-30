package builder.builders;

import builder.components.CarType;
import builder.components.EngineType;

public interface Builder {
    void setCarType (CarType type);
    void setSeats (int seats);
    void setEngin (EngineType engine);
}
