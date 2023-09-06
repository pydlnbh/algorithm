package class01;

/**
 * 给定一个非负整数 num, 如何不用循环语句, 返回 >= num, 并且离 num 最近的, 2 的某次方
 */
public class Code03_Near2Power {
    // 已知 n 是正数, 返回大于等于且最接近 n 的 2 的某次方的值
    public static int tableSizeFor(int n) {
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void main(String[] args) {
        int cap = 120;
        System.out.println(tableSizeFor(cap));
    }
}
