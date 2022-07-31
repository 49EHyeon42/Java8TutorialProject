package daleSeo;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // 예시 확인 용 메인
        // reference 1 : https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
        // reference 2 : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html
    }

    // 예시 1 : NullPointerException
    private static void example1() {
        // given
        Order order = new Order();

        // when, then
        try {
            String city = getCityOfMemberFromOrder(order);
            System.out.println(city.length());
        } catch (Exception e) {
            System.out.println("1번 예시 에러 발생");
            System.out.println(e);
        }
    }

    // 예시 2 : 자바 8 전 NullPointerException 방어 패턴
    private static String example2() {
        Order order = new Order();

        // Bubble Style_최악
        if (order != null) {
            Member member = order.getMember();
            if (member != null) {
                Address address = member.getAddress();
                if (address != null) {
                    String city = address.getCity();
                    if (city != null) {
                        return city;
                    }
                }
            }
        }
        return "Seoul"; // default
    }

    // 예시 3 : 자바 8 전 NullPointerException 방어 패턴
    private static String example3() {
        Order order = new Order();

        // Gateway Style
        if (order == null) {
            return "Seoul";
        }
        Member member = order.getMember();
        if (member == null) {
            return "Seoul";
        }
        Address address = member.getAddress();
        if (address == null) {
            return "Seoul";
        }
        String city = address.getCity();
        if (city == null) {
            return "Seoul";
        }
        return city;
    }

    // 예시 4: Optional 변수 사용
    private static void example4() {
        // 컴파일 통과용 aMember
        Member aMember = new Member();

        // Optional.empty()
        // 빈 객체
        Optional<Member> maybeMember = Optional.empty();

        // Optional.of(value)
        // 객체를 담고 생성
        // null 발생 시 exception 발생
        Optional<Member> maybeMember2 = Optional.of(aMember);

        // Optional.ofNullable(value)
        // 확실할 수 없는 객체 생성
        // 권장
        Optional<Member> maybeMember3 = Optional.ofNullable(aMember);
        Optional<Member> maybeNotMember = Optional.ofNullable(null);

        // Optional 객체 접근 (설명 생략, reference 참고)
        // Optional.get()
        // Optional.orElse(T other)
        // Optional.orElseGet(Supplier<? extends T> other)
        // Optional.Optional.get()
        // Optional.orElseThrow(Supplier<? extends X> exceptionSupplier)
    }

    private static String getCityOfMemberFromOrder(Order order) {
        return order.getMember().getAddress().getCity();
    }
}
