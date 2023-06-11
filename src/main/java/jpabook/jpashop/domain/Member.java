package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(length = 20)
    private String name;
    private String city;
    private String street;
    private String zipcode;
    // 단방향 설계가 가장 좋음 단방향 설계를 먼저 진행하고 추후에 필요할때 양방향 설계할것
    // 왜냐하면 너무 복잡한 설계가 된다.
    // 멤버 객체에는 멤버 관련 필드만 있는게 좋음
    // 실무상 잘못된 코드 (예제니깐 쓰인것임)
    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    public Member() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
