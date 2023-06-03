package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// 편의상 클래스의 이름을 order로 했는데 db에 order라는 명령어가 있어서 테이블의 이름을 새로 지정해줘야댐
// 이것 때문에 테이블 생성 오류뜸
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDER_ID")
    private Long id;
    @Column(name = "MEMBER_ID")
    private Long memberId;
//    private Member member; 
//    사실은 이게 조금 더 객체 지향적인 사용법
//    위에 처럼 memberId를 가지고 오게 되면 관계형데이터베이스에 의존하는 설계법
    private LocalDateTime orderDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
