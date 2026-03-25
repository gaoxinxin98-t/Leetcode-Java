package day03;

/**
 * 对用用户自定义类型，如果要想按照大小与方式进行比较时：在定义类时，实现Comparble接口即可，然后在类
 * 中重写compareTo方法。
 */
public class Card02 implements Comparable<Card02> {
    public int rank; // 数值
    public String suit; // 花色
    public Card02(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    // 根据数值比较，不管花色
// 这里我们认为 null 是最小的
    @Override
    public int compareTo(Card02 o) {
        if (o == null) {
            return 1;
        }
        return rank - o.rank;
    }

    public static void main(String[] args){
        Card02 p = new Card02(1, "♠");
        Card02 q = new Card02(2, "♠");
        Card02 o = new Card02(1, "♠");
        System.out.println(p.compareTo(o)); // == 0，表示牌相等
        System.out.println(p.compareTo(q)); // < 0，表示 p 比较小
        System.out.println(q.compareTo(p)); // > 0，表示 q 比较大
    }
}