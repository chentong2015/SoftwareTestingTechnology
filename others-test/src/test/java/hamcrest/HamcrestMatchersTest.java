package hamcrest;

import com.testing.others.hamcrest.MyHamcrestClass;
import com.testing.others.hamcrest.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// Hamcrest Test Examples 只介绍一些常用的matchers
public class HamcrestMatchersTest {

    // Asserting Boolean Values
    @Test
    @DisplayName("Should be true")
    void shouldBeTrue() {
        assertThat(true, is(true));
        assertThat(false, is(false));
    }

    // Asserting That an Object Is Null or Isn't Null
    @Test
    @DisplayName("Should be null")
    void shouldBeNull() {
        assertThat(null, nullValue());
        assertThat(new Object(), notNullValue());
    }

    // Asserting That Two Objects or Values Are Equal
    @Test
    @DisplayName("Should be equal")
    void shouldBeEqual() {
        MyHamcrestClass instance1 = new MyHamcrestClass("java");
        MyHamcrestClass instance2 = new MyHamcrestClass("java");
        MyHamcrestClass instance3 = new MyHamcrestClass("hamcrest");
        assertThat(instance1, equalTo(instance2));
        assertThat(instance1, not(instance3));
    }

    // Asserting Object References: ensure that two objects refer to the same object
    @Test
    @DisplayName("Should refer to the same object")
    void shouldReferToSameObject() {
        MyHamcrestClass instance1 = new MyHamcrestClass("java");
        MyHamcrestClass instance2 = instance1;
        assertThat(instance1, sameInstance(instance2));
    }

    // Asserting That Two Arrays Are Equal
    // 需要提供能够装箱的类型
    @Test
    public void testEmptyArray() {
        Integer[] array = new Integer[0];
        assertThat(array, emptyArray());
    }

    @Test
    @DisplayName("Should contain the same integers")
    public void shouldContainSameIntegers() {
        int[] actual = new int[]{2, 5, 7};
        int[] expected = new int[]{2, 5, 7};
        assertThat(actual, equalTo(expected));
    }

    // Asserting Lists
    @Test
    @DisplayName("Should contain the same elements")
    public void shouldContainSameElements() {
        final List<Integer> actual = Arrays.asList(1, 2, 3);
        final List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testListElements() {
        List<Object> list = new ArrayList<>();
        Object first = new Object();
        Object second = new Object();
        list.add(first);
        list.add(second);

        assertThat(list, hasSize(2));
        assertThat(list, hasItem(first));
        // contains(item...) 传递全局的参数
        assertThat(list, contains(first, second));
        assertThat(list, containsInAnyOrder(second, first));
        // not(matcher) 传递一个比较器参数
        assertThat(list, not(hasItem(new Object())));
    }

    // Asserting Maps
    @Test
    public void testMapElements() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        assertThat(map, hasKey("key"));
        assertThat(map, not(hasKey("key1")));
        assertThat(map, hasValue("value"));
        assertThat(map, hasEntry("key", "value"));
    }

    // Combining Hamcrest Matchers
    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        String firstname = "first name";
        String lastname = "last name";
        Person person = new Person(firstname, lastname);
        // allOf(matcher...) 这里可以传递多次比较器参数
        assertThat(person, allOf(
                hasProperty("firstName", equalTo(firstname)),
                hasProperty("lastName", equalTo(lastname))
        ));
    }

    // Anything - always matches 能够匹配任何数据和对象, 有助于写Mock Testing !!
    @Test
    public void testAnything() {
        String value = "java";
        assertThat(value, is(anything()));
        assertThat(null, anything());
    }
}
