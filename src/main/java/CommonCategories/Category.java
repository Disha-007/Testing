package CommonCategories;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Category {

    @JsonProperty("categories")
    public Categories categories;
}
