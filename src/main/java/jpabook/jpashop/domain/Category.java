package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    // category 내에서 부모와 자식관계를 설정해줄수있다. 부모는 많은 가지수, 자식은 부모의 한개를 가져온다.

    @ManyToMany
    @JoinTable(name = "CATEGORY_ID",
        joinColumns = @JoinColumn(name = "CATEGORY_ID"),
        inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> itemList = new ArrayList<>();
    // 아이템과 카테고리의 다대다 관계를 설정해준다.
    // 다대다는 실무에서 쓰이지 않는다.
    // why?
    // 관계형데이터베이스에서는 다대다 관계에 중간테이블이 필요한데 객체지향으로 활용하는 jpa의 경우 추가 entity 테이블을 만들지 않아도 가능하여
    // 다대다 관계를 다대일, 일대다 관계로 승격하여 사용한다.

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
