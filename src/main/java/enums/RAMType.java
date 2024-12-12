package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RAMType {
    DDR(4),
    DDR2(8),
    DDR3(32),
    DDR4(64),
    DDR5(128),
    LPDDR4(32),
    LPDDR5(64);

    private final int maxCapacity;

    public boolean check(int capacity){
        return capacity<=getMaxCapacity();
    }

}
