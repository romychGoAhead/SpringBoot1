package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.Сalculation;

@RestController
public class Calculator {

    private final Сalculation service;

    public Calculator(Сalculation service) {
        this.service = service;
    }

    @GetMapping("/calculator")
    public String calculator() {
        return "<b>Добро пожаловать в калькулятор!</b> ";

    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {

        return String.format("%s + %s = %s", a, b, service.Plus(a, b));

    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {

        return String.format("%s - %s = %s", a, b, service.Minus(a, b));

    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {

        return String.format("%s * %s = %s", a, b, service.Multiply(a, b));

    }

    @GetMapping("/calculator/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        if (b == 0) {
            return "На 0 делить нельзя!";
        }

        return String.format("%s / %s = %s", a, b, service.Divide(a, b));

    }
}


//  @GetMapping(path ="/hello")
//  public String answerCalculator(@RequestParam("name") String userName) {   //возвращает имя юзера
//    return "Привет" + userName;
//   }




