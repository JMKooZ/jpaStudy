package test;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    public int id;
    public String name;

    public Member() {

    }
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
