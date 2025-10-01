package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//Імпортуємо бібліотеку exp4 для обрахування математичних виразів
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.Expression;


@Controller
public class CalculatorController {
    //Метод для відображення сторінки калькулятора
    @GetMapping("/calculator")
    public String index(){
        //Повертаємо назву шаблону HTML (calculator.html)
        //Spring Boot шукає його в папці src/main/resources/templates
        return "calculator";
    }

    //Метод для обробки відправки форми калькулятора
    @PostMapping("/calculate")
    public String calculate(@RequestParam("expression") String expression, Model model){
        try{
            //Створюємо об'єкт на основі введеного рядка
            Expression exp = new ExpressionBuilder(expression).build();

            //Прораховуємо результат
            double result = exp.evaluate();

            //Додаємо результат в модель, щоб відобразити на сторінці
            model.addAttribute("result", result);
        } catch(Exception ex){
            //Якщо виникла помилка (наприклад, некоректний вираз), показуємо повідомлення
            //про помилку
            model.addAttribute("result", "Помилка у виразі");
        }
        //Повертаємо шаблон calculator.html знову, щоб користувач побачив результат
        return "calculator";
    }
}
