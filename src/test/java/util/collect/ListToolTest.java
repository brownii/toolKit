package util.collect;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListToolTest {

    @Test
    public void findIndex() {
    }

    @Test
    public void findIndex1() {
        System.out.println(ListTool.findIndex(Lists.newArrayList(1, 2, 5, 7), 2));
    }
}