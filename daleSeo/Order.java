package daleSeo;

import java.util.Date;

public class Order {

    private final Long id;
    private final Date date;
    private final Member member;

    public Order() {
        this.id = null;
        this.date = null;
        this.member = null;
    }

    public Order(Long id, Date date, Member member) {
        this.id = id;
        this.date = date;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Member getMember() {
        return member;
    }
}
