package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DisplayType {
    LED(60),
    OLED(120),
    LCD(75);

    private final int refreshRate;

    public String checkPerformance(){
        if(getRefreshRate() < 75){
            return "Standard performance";
        }
        else if (getRefreshRate() > 100) {
            return "High performance";
        }
        else return "Medium performance";
    }

}
