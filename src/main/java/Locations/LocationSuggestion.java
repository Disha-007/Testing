package Locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationSuggestion {
    @JsonProperty("entity_type")
    public String entityType;
    @JsonProperty("entity_id")
    public Integer entityId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("latitude")
    public Double latitude;
    @JsonProperty("longitude")
    public Double longitude;
    @JsonProperty("city_id")
    public Integer cityId;
    @JsonProperty("city_name")
    public String cityName;
    @JsonProperty("country_id")
    public Integer countryId;
    @JsonProperty("country_name")
    public String countryName;
}
