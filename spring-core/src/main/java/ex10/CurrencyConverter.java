package ex10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import static ex10.Currency.*;

@Repository
public class CurrencyConverter {
    @Autowired
    private ApplicationContext appCtx;

    public double convert(String source, String target, double amount) {
        Currency src = appCtx.getBean(source, Currency.class);
        Currency tgt = appCtx.getBean(target, Currency.class);
        return (tgt.dollarValue() / src.dollarValue()) * amount;
    }

}
