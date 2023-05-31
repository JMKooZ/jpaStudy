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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void deposit(int money){
        this.money += money;
    }
    public void withdraw(int money){
        this.money -= money;
    }
}
