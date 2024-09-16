package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class MyListTest {

    @Test
    public void testListParameters() {
        MyList mockMyList = Mockito.mock(MyList.class);

        // TODO. 实参在匹配时能够推断具体的参数类型，无需显式地指定

        // https://stackoverflow.com/questions/46294693/mockito-anylistof-listliststring
        when(mockMyList.testListParameters(ArgumentMatchers.<List<String>>anyList())).thenReturn("AnyList");

        List<List<String>> listList = new ArrayList<>();
        List<List<String>> listList2 = new ArrayList<>();
        listList2.add(List.of("item 1", "item 2"));

        Assert.assertEquals("AnyList", mockMyList.testListParameters(listList));
        Assert.assertEquals("AnyList", mockMyList.testListParameters(listList2));
    }
}
