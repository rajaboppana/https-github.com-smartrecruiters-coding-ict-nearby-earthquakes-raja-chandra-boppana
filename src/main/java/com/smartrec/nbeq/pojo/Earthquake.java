package com.smartrec.nbeq.pojo;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RajaBoppana
 *
 */
@JsonPropertyOrder({"type","properties","geometry","id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Earthquake implements Serializable {

	private static final long serialVersionUID = -1796206669229181258L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("properties")
    private Properties properties;
	
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("geometry")
    private Geometry geometry;
    
    @JsonIgnore
    private Map<String, Object> moreProperties = new HashMap<>();
    

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getMoreProperties() {
        return this.moreProperties;
    }

    @JsonAnySetter
    public void setMoreProperty(String key, Object value) {
        this.moreProperties.put(key, value);
    }
}