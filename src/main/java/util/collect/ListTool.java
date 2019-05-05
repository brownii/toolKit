package util.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: toolKit
 * @description: 队列工具类
 * @author: brownii
 * @create: 2019-05-05 21:56
 */
public class ListTool {
    /**
     * 有序队列二分查询
     *
     * @param arrayList 有序数组
     * @param start start index
     * @param end end start
     * @param equalPredicate 匹配条件
     * @param lessPredicate 向前匹配条件
     * @param returnNext 不在队列中是否返回下一位index
     * @param <T>
     * @return 默认不在数组中返回-1
     */
    private static <T> int findIndex(List<T> arrayList, int start, int end, Predicate<T> equalPredicate, Predicate<T> lessPredicate,
                                     boolean returnNext) {
        if (end < start) {
            return returnNext ? start : -1;
        }
        int index = (end + start) >> 1;
        if (index >= arrayList.size()) {
            return returnNext ? index : -1;
        }
        T target = arrayList.get(index);

        if (equalPredicate.test(target)) {
            return index;
        } else if (lessPredicate.test(target)) {
            return findIndex(arrayList, start, index - 1, equalPredicate, lessPredicate, returnNext);
        } else {
            return findIndex(arrayList, index + 1, end, equalPredicate, lessPredicate, returnNext);
        }
    }

    public static <T> int findIndex(ArrayList<T> arrayList, Predicate<T> equalPredicate, Predicate<T> lessPredicate, boolean returnNext) {
        return findIndex(arrayList, 0, arrayList.size(), equalPredicate, lessPredicate, returnNext);
    }

    public static int findIndex(ArrayList<Integer> arrayList, int target) {
        return findIndex(arrayList, 0, arrayList.size(), v -> v == target, v -> v > target, false);
    }
}
