package daleSeo;

public class Member {

    private final Long id;
    private final String name;
    private final Address address;

    public Member() {
        this.id = null;
        this.name = null;
        this.address = null;
    }

    public Member(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
