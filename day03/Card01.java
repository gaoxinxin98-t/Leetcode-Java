package day03;

public class Card01 {
    public int rank; // 数值
    public String suit; // 花色

    public Card01(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
// 自己和自己比较
        if (this == o) {
            return true;
        }
// o如果是null对象，或者o不是Card的子类
        if (o == null || !(o instanceof Card01)) {
            return false;
        }
// 注意基本类型可以直接比较，但引用类型最好调用其equal方法
        Card01 c = (Card01)o;
        return rank == c.rank
                && suit.equals(c.suit);
    }

    public interface Comparable<E> {
        // 返回值:
// < 0: 表示 this 指向的对象小于 o 指向的对象
// == 0: 表示 this 指向的对象等于 o 指向的对象
// > 0: 表示 this 指向的对象大于 o 指向的对象
        int compareTo(E o);
    }

}
/**
 * 注意： 一般覆写 equals 的套路就是上面演示的
 * 1. 如果指向同一个对象，返回 true
 * 2. 如果传入的为 null，返回 false
 * 3. 如果传入的对象类型不是 Card，返回 false
 * 4. 按照类的实现目标完成比较，例如这里只要花色和数值一样，就认为是相同的牌
 * 5. 注意下调用其他引用类型的比较也需要 equals，例如这里的 suit 的比较
 * 覆写基类equal的方式虽然可以比较，但缺陷是：equal只能按照相等进行比较，不能按照大于、小于的方式进行
 * 比较。
 */