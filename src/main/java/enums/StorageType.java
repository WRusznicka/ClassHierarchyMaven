package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StorageType {
    SSD(100,10000 ),
    HDD(50, 300);

    private final int minSpeed;
    private final int maxSpeed;

    public boolean isFaster(int maxSpeed){
        return maxSpeed<this.getMaxSpeed();
    }
}
