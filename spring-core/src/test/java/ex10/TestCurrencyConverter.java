package ex10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestCurrencyConverter {
    @Autowired
    private CurrencyConverter cc;

    @Test
    public void testUSD2INR() {
        double result = cc.convert("usd","inr",100);
        assertEquals(result, 8670.0);
    }
}
