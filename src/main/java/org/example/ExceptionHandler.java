package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {
    public static int handleInputMismatch(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine(); // 입력 버퍼 비우기
            }
        }
    }
}
