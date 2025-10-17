package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Expression expression = new Expression(Console.readLine());

        System.out.println("결과 : " + expression.makeSum());
    }

}
