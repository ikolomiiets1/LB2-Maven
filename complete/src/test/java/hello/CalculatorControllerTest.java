package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {
    //Тест, який завжди має проходити
    @Test
    public void testValidExpression() {
        Expression exp = new ExpressionBuilder("1+1").build();
        double result = exp.evaluate();
        assertEquals(2, result); //тест пройдено, якщо результат = 2
    }

    //Тест, який завжди буде видавати помилку
//    @Test
//    public void testFailingExpression(){
//        Expression exp = new ExpressionBuilder("5-1").build();
//        double result = exp.evaluate();
//        assertEquals(2, result); //тест навмисно провалиться
//    }
}
