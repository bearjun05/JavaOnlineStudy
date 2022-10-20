package grade;

import account.Account;
import account.Grade;

public class CountPolicy implements GradePolicy{
    @Override
    public void setGrade(Account account) {
        if(account.cnt >= 3){
            account.setGrade(Grade.gold);
        }else {
            account.setGrade(Grade.bronze);
        }
    }
}
