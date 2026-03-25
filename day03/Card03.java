package day03;
import java.util.Comparator;

/**
 * // 返回值:
 * // < 0: 表示 o1 指向的对象小于 o2 指向的对象
 * // == 0: 表示 o1 指向的对象等于 o2 指向的对象
 * // > 0: 表示 o1 指向的对象等于 o2 指向的对象
 */
class Card03 {
    public int rank; // 数值
    public String suit; // 花色
    public Card03(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}

class CardComparator implements Comparator<Card03> {
    // 根据数值比较，不管花色
// 这里我们认为 null 是最小的
    @Override
    public int compare(Card03 o1, Card03 o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.rank - o2.rank;
    }
    public static void main(String[] args){
        Card03 p = new Card03(1, "♠");
        Card03 q = new Card03(2, "♠");
        Card03 o = new Card03(1, "♠");
// 定义比较器对象
        CardComparator cmptor = new CardComparator();
// 使用比较器对象进行比较
        System.out.println(cmptor.compare(p, o)); // == 0，表示牌相等
        System.out.println(cmptor.compare(p, q)); // < 0，表示 p 比较小
        System.out.println(cmptor.compare(q, p)); // > 0，表示 q 比较大
    }
}
/**
 *
 */