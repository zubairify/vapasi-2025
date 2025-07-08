package ex10;

import org.springframework.stereotype.Component;

@Component("usd")
public class USD implements Currency {
    @Override
    public double dollarValue() {
        return 1.0;
    }
}
