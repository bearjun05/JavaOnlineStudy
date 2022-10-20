package grade;

import account.Account;

public interface GradePolicy {

    //추상메소드
    void setGrade(Account account);

    // 2가지 역할
    // 1) -> 클래스사용설명서
    // 2) -> 다형성
}
