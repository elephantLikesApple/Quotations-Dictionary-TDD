package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        System.out.println("== 명언 앱 ==");
        long lastQuotationId = 0;
        List<Quotation> quotations = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            if (cmd.isEmpty()) continue;

            switch (cmd) {
                case "종료":
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();

                    long id = ++lastQuotationId;
                    quotations.add(new Quotation(id, content, author));
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(Quotation quotation : quotations.stream().sorted(Comparator.comparingLong(Quotation::getId).reversed()).toList()) {
                        System.out.println(quotation.getId() + " / " + quotation.getAuthor() + " / " + quotation.getContent());
                    }
                    break;
                default:
                    System.out.printf("`%s`(은)는 올바르지 않은 명령입니다.\n", cmd);
                    break;
            }
        }
    }
}
