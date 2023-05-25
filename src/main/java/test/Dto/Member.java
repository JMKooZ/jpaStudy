package test.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    public int id;
    public String name;
    public int money;

    public Member() {
    }
    public Member(int id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
    public void deposit(int money){
        this.money += money;
    }
    public void withdraw(int money){
        this.money -= money;
    }
}
