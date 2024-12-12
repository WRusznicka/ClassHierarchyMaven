package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BatteryPowerLevel {
    CRITICAL(0,5),
    LOW(5,20),
    NORMAL(20,80),
    HIGH(80,100);

    private final int minBatteryPower;
    private final int maxBatteryPower;

    public boolean correctLevel(int batteryPower){
        return (batteryPower>=getMinBatteryPower() && batteryPower<=getMaxBatteryPower());
    }

}
