package test.Dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Test",uniqueConstraints = {
    @UniqueConstraint(
        name = "contstraintName",
        columnNames = {"name", "id"}
    )
})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    autoIncrement 설정 mysql IDENTITY oracle SEQUENCE
    private Long mno;
    @Column(name = "id", nullable = false)
    private String userId;
    // 객체에는 userName 을 쓰고 싶은데 db컬럼에는 name으로 하고싶을때
    // nullable 의 default 값은 true false 일경우 not null 제약조건
    // columnDefinition 컬럼의 기본을 정의해줌
    @Column(name = "name", nullable = false, columnDefinition = "varchar(20) default 'noName'")
    private String userName;
    //insertable updatable -> default 값 true false 값하면 절대 변경되지않음(수정불가)
    // length 는 길이 정해줌
    @Column(updatable = true, length = 20)
    private Integer money;
    // enumType 은 ORDINAL or STRING 이 있는데 default 값은 oridinal 인데 숫자로 표현됨 나중에 enum 이 추가되거나 순서가 바뀔수도 있으니 꼭 String 형으로 지정하자.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    //Temporal은 value 가 3 가지 DATE(날짜만) TIME(시간만) TIMESTAMP(날짜 시간 같이)
    //@Temporal(TemporalType.TIMESTAMP) <- 구버전 java.util.Date or Calendar 에서 사용
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime modifiedTime;
    // 큰 값의 무엇인가를 삽입할때 default 값 blob 형태가 string 이면 clob
    @Lob
    private String lob;
    // transient 는 db컬럼으로 저장되지않고 메모리 내에서 연산으로 사용할때만 씀.( 매핑을 하지 않음 )
    @Transient
    private String temp;

    public Member() {
    }

    public Long getMno() {
        return mno;
    }

    public void setMno(Long mno) {
        this.mno = mno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void deposit(int money) {
        this.money += money;
    }

    public void withdraw(int money) {
        this.money -= money;
    }
}
