package com.smartrec.nbeq.pojo;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RajaBoppana
 *
 */
@JsonPropertyOrder({"type","coordinates"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Geometry implements Serializable {

	private static final long serialVersionUID = 7615750806372295240L;

	@JsonProperty("type")
    private String type;
    
    @JsonProperty("coordinates")
    private List<Double> coordinates = null;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("coordinates")
    public List<Double> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}