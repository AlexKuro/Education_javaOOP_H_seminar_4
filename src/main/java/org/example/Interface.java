package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;


public class Interface {
    Scanner iScanner = new Scanner(System.in);
    Calculator calculator = new Calculator();


    public void interface_1() {
        System.out.println("\n- ------ К А Л Ь К У Л Я Т О Р ------ -");
    }

    public Integer interface_2() {
        calculator.setFlag(true);
        Integer n;
        System.out.println("\n\tСложение  - - - - - - нажмите '1'");
        System.out.println("\tВычитание - - - - - - нажмите '2'");
        System.out.println("\tУмножение - - - - - - нажмите '3'");
        System.out.println("\tДеление - - - - - - - нажмите '4'");
        System.out.println("\tБинарный перевод  - - нажмите '5'");
        System.out.println("\tВыход из программы  - нажмите '9'");
        System.out.print("\nВведите число -> ");
        n = iScanner.nextInt();
        return n;
    }

    public void choice(Integer n) {
        switch (n) {
            case 1:
                System.out.print("- Сложение -\n");
                System.out.print("Введите первое число -> ");
                Double a = iScanner.nextDouble();
                calculator.setNum1(a);
                System.out.print("Введите второе число -> ");
                Double b = iScanner.nextDouble();
                calculator.setNum2(b);
                System.out.printf("\nСложение чисел: "
                        + " " + a + " " + " + " + b + " = " + calculator.sum());
                System.out.println();
                break;
            case 2:
                System.out.print("- Вычитание -\n");
                System.out.print("Введите первое число -> ");
                a = iScanner.nextDouble();
                calculator.setNum1(a);
                System.out.print("Введите второе число -> ");
                b = iScanner.nextDouble();
                calculator.setNum2(b);
                System.out.printf("\nСложение чисел: "
                        + " " + a + " " + " - " + b + " = " + calculator.subtraction());
                System.out.println();
                break;
            case 3:
                System.out.print("- Умножение -\n");
                System.out.print("Введите первое число -> ");
                a = iScanner.nextDouble();
                calculator.setNum1(a);
                System.out.print("Введите второе число -> ");
                b = iScanner.nextDouble();
                calculator.setNum2(b);
                System.out.printf("\nСложение чисел: "
                        + " " + a + " " + " * " + b + " = " + calculator.multiplications());
                System.out.println();
                break;
            case 4:
                System.out.print("- Деление -\n");
                System.out.print("Введите первое число -> ");
                a = iScanner.nextDouble();
                calculator.setNum1(a);
                System.out.print("Введите второе число -> ");
                b = iScanner.nextDouble();
                calculator.setNum2(b);
                System.out.printf("\nСложение чисел: "
                        + " " + a + " " + " / " + b + " = " + calculator.division());
                System.out.println();
                break;

            case 5:
                System.out.print("- Бинарный перевод -\n");
                System.out.println("\tЧИСЛО тип Integer  - - - - - нажмите '1'");
                System.out.println("\tЧИСЛО тип Double - - - - - - нажмите '2'");
                System.out.println("\tСИМВОЛ тип String  - - - - - нажмите '3'");
                System.out.print("Введите число -> ");
                n = iScanner.nextInt();
                switch (n) {
                    case 1:
                        System.out.print("Введите ЧИСЛО тип Integer -> ");
                        Object q = iScanner.nextInt();
                        System.out.println("Бинарный перевод: " + q + " --> " + calculator.binObg(q));
                        break;
                    case 2:
                        System.out.print("Введите ЧИСЛО тип Double -> ");
                        q = iScanner.nextDouble();
                        System.out.println("Бинарный перевод: " + q + " --> " + calculator.binObg(q));
                        break;
                    case 3:
                        System.out.print("Введите СИМВОЛ тип String -> ");
                        q = iScanner.next();
                        System.out.println("Бинарный перевод: " + q + " --> " + calculator.binObg(q));
                        break;
                    default:
                        System.out.print("Формат ввода неверный!\n");
                        break;
                }
                break;
            case 9:
                System.out.print("Завершение программы 'КАЛЬКУЛЯТОР'.\n\n");
                iScanner.close();
                calculator.setFlag(false);
                break;

            default:
                System.out.print("Формат ввода неверный!\n");
                break;
        }
    }

    public Boolean end() {
        return calculator.getFlag();
    }


}
