package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
// 편의상 클래스의 이름을 order로 했는데 db에 order라는 명령어가 있어서 테이블의 이름을 새로 지정해줘야댐
// 이것 때문에 테이블 생성 오류뜸
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDER_ID")
    private Long id;
//    @Column(name = "MEMBER_ID")
//    private Long memberId;
    @ManyToOne
    @JoinColumn(name = "MEMEBER_ID")
    private Member member;
//    사실은 이게 조금 더 객체 지향적인 사용법
//    위에 처럼 memberId를 가지고 오게 되면 관계형데이터베이스에 의존하는 설계법
    private LocalDateTime orderDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    // 얘는 비즈니스 적으로 충분히 의미 있는 양방향 설계
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order() {
    }
    // 양방향 관계 편의 메서드
    public void addOrderItemList(OrderItem orderItem){
        orderItemList.add(orderItem);
        orderItem.setOrder(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
