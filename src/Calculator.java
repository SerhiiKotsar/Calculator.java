import javax.swing.*;
import java.util.Scanner; // подключаем Scanner
public class Calculator {

    static Scanner scanner = new Scanner(System.in); // объявляем Scanner

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static int getInt() {
        System.out.println("Введите число: "); // просим пользователя ввести первое число
        int num; // введенное пользователем число записываем в переменную num типа int
        if (scanner.hasNextInt()) { // если Scanner принял число,
            num = scanner.nextInt(); // то наша переменная num равнется Scanner
        } else {
            System.out.println("Вы совершили ошибку! Попробуйте ещё раз."); // если пользователь вводит не число
            scanner.next(); // рекурсия, чтобы метод не останавливался
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите желаемую операцию (+,-,*,/): ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0); // делается для того, чтобы распознать знак который устраивает нас
        } else {
            System.out.println("Вы совершили ошибку! Попробуйте ещё раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не прошла. Проверьте корректность ввода!");
                result = calc(num1, num2, getOperation()); // рекурсия
        }
        return result;
    }

}