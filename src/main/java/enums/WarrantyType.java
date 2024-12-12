package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WarrantyType {

    LIMITED(6,"Only technical failure", 0),
    STANDARD(12,"Standard service, technical failure or damage while shipping", 50),
    EXTENDED(24,"Standard service, technical failure or damage while shipping", 80),
    GOLD(36,"Technical failure, damage while shipping or damages caused by purchaser", 100);

    private final int duration;
    private final String coverage;
    private final float extraPrice;

    public boolean coversDamagesByUser(){
        return coverage.contains("damages caused by purchaser");
    }
}
