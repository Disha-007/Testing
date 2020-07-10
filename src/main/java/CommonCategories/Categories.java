package CommonCategories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Categories {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
}
