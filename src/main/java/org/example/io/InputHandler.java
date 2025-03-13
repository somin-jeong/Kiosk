package org.example.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    // Scanner 선언
    private static final Scanner sc = new Scanner(System.in);

    public static int getIntInput() {
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
