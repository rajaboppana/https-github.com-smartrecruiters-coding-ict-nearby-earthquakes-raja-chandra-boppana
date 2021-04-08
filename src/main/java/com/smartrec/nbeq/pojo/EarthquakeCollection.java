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
@JsonPropertyOrder({"type","metadata","features"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EarthquakeCollection implements Serializable {

	private static final long serialVersionUID = -3193627333597390606L;

	@JsonProperty("type")
    private String type;
    
    @JsonProperty("metadata")
    private Metadata metadata;
    
    @JsonProperty("features")
    private List<Earthquake> earthquakes = null;
    
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

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("earthquakes")
    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    @JsonProperty("features")
    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
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