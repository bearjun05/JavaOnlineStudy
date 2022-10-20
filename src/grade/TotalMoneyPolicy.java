package grade;

import account.Account;
import account.Grade;

public class TotalMoneyPolicy implements GradePolicy {

    public void setGrade(Account account) {
        if (account.getMoney() >= 100000) {
            account.setGrade(Grade.gold);
        }else{
            account.setGrade(Grade.bronze);
        }
    }
}
