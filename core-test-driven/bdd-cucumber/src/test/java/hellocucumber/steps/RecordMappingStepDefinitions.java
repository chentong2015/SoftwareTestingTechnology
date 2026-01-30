package hellocucumber.steps;

import com.example.main.Record;
import com.example.main.RecordMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// TODO. 使用DataTable传递一组数据, 支持映射的类型如下
// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or Map<K, List<V>>.
// E,K,V must be a String, Integer, Float, Double, Byte, Short, Long, BigInteger or BigDecimal.
//
// TODO. 二维表数据(deader, records)结构被映射成List<Map<String, String>>
// | bad  | category | isEmbargo | type |
// | 0    | SI       | 0         | C    |
//
// TODO. 两列输入的结构映射成Map<Key,Value>
// | bad        | 0  |
// | category   | SI |
// | isEmbargo  | 0  |
// | type       | C  |
public class RecordMappingStepDefinitions {

    private Record record;

    @Given("init new record with default fields")
    public void init_new_record_with_default_fields(DataTable dataTable) {
        record = new Record();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> fieldValues = rows.get(0);

        for (String key: fieldValues.keySet()) {
            String value = fieldValues.get(key);
            if (key.equalsIgnoreCase("bad")) {
                record.setBad(Integer.parseInt(value));
            } else if (key.equalsIgnoreCase("category")) {
                record.setCategory(value);
            } else if (key.equalsIgnoreCase("isEmbargo")) {
                record.setEmbargo(!value.equals("0"));
            } else if (key.equalsIgnoreCase("type")) {
                record.setType(value);
            } else if (key.equalsIgnoreCase("gender")) {
                record.setGender(value);
            }
        }
    }

    @When("Record is mapped")
    public void record_is_mapped() {
        RecordMapper.transformRecord(record);
    }

    @Then("Record has expected category values")
    public void record_has_expected_category_values(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> fieldValues = rows.get(0);

        for (String key: fieldValues.keySet()) {
            String value = fieldValues.get(key);
            if (key.equalsIgnoreCase("bad")) {
                assertThat(record.getBad()).isEqualTo(Integer.parseInt(value));
            } else if (key.equalsIgnoreCase("category")) {
                assertThat(record.getCategory()).isEqualTo(value);
            } else if (key.equalsIgnoreCase("isEmbargo")) {
                boolean expectedValue = !value.equals("0");
                assertThat(record.isEmbargo()).isEqualTo(expectedValue);
            } else if (key.equalsIgnoreCase("type")) {
                assertThat(record.getType()).isEqualTo(value);
            } else if (key.equalsIgnoreCase("gender")) {
                assertThat(record.getGender()).isEqualTo(value);
            }
        }
    }
}
