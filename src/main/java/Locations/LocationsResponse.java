package Locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocationsResponse {

    @JsonProperty("location_suggestions")
    public List<LocationSuggestion> locationSuggestions = new ArrayList<>();
    @JsonProperty("status")
    public String status;
    @JsonProperty("has_more")
    public Integer hasMore;
    @JsonProperty("has_total")
    public Integer hasTotal;
    @JsonProperty("user_has_addresses")
    public Boolean userHasAddresses;
}
