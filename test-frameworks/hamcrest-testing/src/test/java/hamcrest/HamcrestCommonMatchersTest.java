package hamcrest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

// Hamcrest Test Examples: some common matchers
public class HamcrestCommonMatchersTest {

    // Asserting Boolean Values
    @Test
    @DisplayName("Should be true")
    void shouldBeTrue() {
        MatcherAssert.assertThat(true, Matchers.is(true));
        MatcherAssert.assertThat(false, Matchers.is(false));
    }

    // Asserting That an Object Is Null or Isn't Null
    @Test
    @DisplayName("Should be null")
    void shouldBeNull() {
        MatcherAssert.assertThat(null, Matchers.nullValue());
        MatcherAssert.assertThat(new Object(), Matchers.notNullValue());
    }

    // Asserting That Two Objects or Values Are Equal
    @Test
    @DisplayName("Should be equal")
    void shouldBeEqual() {
        MyHamcrestClass instance1 = new MyHamcrestClass("java");
        MyHamcrestClass instance2 = new MyHamcrestClass("java");
        MyHamcrestClass instance3 = new MyHamcrestClass("hamcrest");
        // check two instances are equals
        MatcherAssert.assertThat(instance1, Matchers.equalTo(instance2));
        MatcherAssert.assertThat(instance1, Matchers.not(instance3));
    }

    // Asserting Object References: ensure that two objects refer to the same object
    @Test
    @DisplayName("Should refer to the same object")
    void shouldReferToSameObject() {
        MyHamcrestClass instance1 = new MyHamcrestClass("java");
        MyHamcrestClass instance2 = instance1;
        // check two instance are the same
        MatcherAssert.assertThat(instance1, Matchers.sameInstance(instance2));
    }

    // Asserting That Two Arrays Are Equal
    // 需要提供能够装箱的类型
    @Test
    public void testEmptyArray() {
        Integer[] array = new Integer[0];
        MatcherAssert.assertThat(array, Matchers.emptyArray());
    }

    @Test
    @DisplayName("Should contain the same integers")
    public void shouldContainSameIntegers() {
        int[] actual = new int[]{2, 5, 7};
        int[] expected = new int[]{2, 5, 7};
        MatcherAssert.assertThat(actual, Matchers.equalTo(expected));
    }

    // Asserting Lists
    @Test
    @DisplayName("Should contain the same elements")
    public void shouldContainSameElements() {
        final List<Integer> list1 = Arrays.asList(1, 2, 3);
        final List<Integer> list2 = Arrays.asList(1, 2, 3);
        MatcherAssert.assertThat(list1, Matchers.equalTo(list2));
    }

    @Test
    public void testListElements() {
        List<Object> list = new ArrayList<>();
        Object first = new Object();
        Object second = new Object();
        list.add(first);
        list.add(second);

        MatcherAssert.assertThat(list, Matchers.hasSize(2));
        MatcherAssert.assertThat(list, Matchers.hasItem(first));

        // contains(item...) 传递list中包含的所有元素
        MatcherAssert.assertThat(list, Matchers.contains(first, second));
        MatcherAssert.assertThat(list, Matchers.containsInAnyOrder(second, first));

        Object third = new Object();
        MatcherAssert.assertThat(list, Matchers.not(Matchers.hasItem(third)));
    }

    // Asserting Maps
    @Test
    public void testMapElements() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        MatcherAssert.assertThat(map, Matchers.hasKey("key"));
        MatcherAssert.assertThat(map, Matchers.not(Matchers.hasKey("key1")));
        MatcherAssert.assertThat(map, Matchers.hasValue("value"));
        MatcherAssert.assertThat(map, Matchers.hasEntry("key", "value"));
    }

    // Combining Hamcrest Matchers
    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        String firstname = "first name";
        String lastname = "last name";
        Person person = new Person(firstname, lastname);
        // allOf(matcher...) 这里可以传递多次比较器参数
        MatcherAssert.assertThat(person, Matchers.allOf(
                Matchers.hasProperty("firstName", Matchers.equalTo(firstname)),
                Matchers.hasProperty("lastName", Matchers.equalTo(lastname))
        ));
    }

    // Anything - always matches 能够匹配任何数据和对象, 有助于写Mock Testing !!
    @Test
    public void testAnything() {
        String value = "java";
        MatcherAssert.assertThat(value, Matchers.is(Matchers.anything()));
        MatcherAssert.assertThat(null, Matchers.anything());
    }
}
