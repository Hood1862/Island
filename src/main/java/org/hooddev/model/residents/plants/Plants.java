package org.hooddev.model.residents.plants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plants {

    private double amount = 0;

    public boolean reduceAmount(double i) {
        amount = amount - i;
        if (amount < 0) {
            amount = 0;
            return false;
        }

        return true;
    }

    public void plantsGrewByFivePercent() {
        amount = amount + (amount / 100 * 5);
    }

}
