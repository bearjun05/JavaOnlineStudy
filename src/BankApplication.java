import account.Account;
import account.Grade;
import grade.CountPolicy;
import grade.GradePolicy;
import grade.TotalMoneyPolicy;

import java.util.Scanner;

public class BankApplication {
    private static Account[] account = new Account[100];
    private static Scanner scanner = new Scanner(System.in);
    public static int cnt = -1;

    public static GradePolicy gradePolicy;



    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 | 6.관리자");
            System.out.println("---------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                accountList();
            } else if (selectNo == 3) {
                deposit();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            } else if (selectNo == 6) {
                config();
            }
        }
        System.out.println("프로그램 종료");
    }

    private static void config() {

        Scanner sc = new Scanner(System.in);
        System.out.println("등급 정책을 선택하세요.");
        System.out.println("1) 거래 횟수제");
        System.out.println("2) 총액제");
        int num = sc.nextInt();


        if(num == 1){
            gradePolicy = new CountPolicy();
            System.out.println("1번 선택이 완료 되었습니다.");
        } else if (num == 2) {
            gradePolicy = new TotalMoneyPolicy();
            System.out.println("2번 선택이 완료 되었습니다.");
        }
    }

    //계좌생성하기
    private static void createAccount() {
        // 작성 위치
        cnt++;
        System.out.print("계좌번호 : ");
        String accountNumber = scanner.next();
        System.out.print("계좌주 : ");
        String name = scanner.next();
        System.out.print("초기입금액 : ");
        int money = scanner.nextInt();

        account[cnt] = new Account(accountNumber, name, money);
        gradePolicy.setGrade(account[cnt]);
    }


    //계좌목록보기
    private static void accountList() {
        // 작성 위치
        for (int i = 0; i <= cnt; i++) {
            System.out.println("계좌번호: " + account[i].getAccountNumber()+"\n"
                                +"성함: " + account[i].getName()+"\n"
                                +"잔액: " + account[i].getMoney()+"\n"
                                +"등급: " + account[i].getGrade());
            System.out.println();
        }
    }

    //예금하기
    private static void deposit() {
      // 작성 위치
        System.out.print("계좌번호 : ");
        String accountNumber = scanner.next();
        System.out.print("예금액 : ");
        int money = scanner.nextInt();
        for (int i = 0; i <= cnt; i++) {
            if(account[i].getAccountNumber().equals(accountNumber)){
                account[i].setMoney(account[i].getMoney()+money);
                account[i].cnt++;
                gradePolicy.setGrade(account[i]);
               // System.out.println(" 정상적으로 반영 = " + account[i].getGrade());
            }
        }
    }

    //출금하기
    private static void withdraw() {
      // 작성 위치
        System.out.print("계좌번호 : ");
        String accountNumber = scanner.next();
        System.out.print("출금액 : ");
        int money = scanner.nextInt();

        for (int i = 0; i <= cnt; i++) {
            if(account[i].getAccountNumber().equals(accountNumber)){
                if(account[i].getMoney()<money){
                    System.out.println("계좌 잔액이 부족합니다.");
                    return;
                }
                account[i].setMoney(account[i].getMoney()-money);
                account[i].cnt++;
                gradePolicy.setGrade(account[i]);
              //  System.out.println(" 정상적으로 반영 = " + account[i].getGrade());
            }
        }


    }
}
