package CommonCategories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommonCategoriesResponse {
    @JsonProperty("categories")
    public List<Category> categories = new ArrayList<>();

}
