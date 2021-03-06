/*
 * Swagger Fruitvice
 * This is a server for the public FruityVice API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.example.fruitapp.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.example.fruitapp.io.swagger.client.model.Nutrition;
import java.io.IOException;

/**
 * Fruit
 */
public class Fruit {
  @SerializedName("genus")
  private String genus = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("family")
  private String family = null;

  @SerializedName("order")
  private String order = null;

  @SerializedName("nutritions")
  private Nutrition nutritions = null;

  public Fruit genus(String genus) {
    this.genus = genus;
    return this;
  }

   /**
   * Get genus
   * @return genus
  **/
  @ApiModelProperty(value = "")
  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  public Fruit name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Fruit id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Fruit family(String family) {
    this.family = family;
    return this;
  }

   /**
   * Get family
   * @return family
  **/
  @ApiModelProperty(value = "")
  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public Fruit order(String order) {
    this.order = order;
    return this;
  }

   /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(value = "")
  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public Fruit nutritions(Nutrition nutritions) {
    this.nutritions = nutritions;
    return this;
  }

   /**
   * Get nutritions
   * @return nutritions
  **/
  @ApiModelProperty(value = "")
  public Nutrition getNutritions() {
    return nutritions;
  }

  public void setNutritions(Nutrition nutritions) {
    this.nutritions = nutritions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fruit fruit = (Fruit) o;
    return Objects.equals(this.genus, fruit.genus) &&
        Objects.equals(this.name, fruit.name) &&
        Objects.equals(this.id, fruit.id) &&
        Objects.equals(this.family, fruit.family) &&
        Objects.equals(this.order, fruit.order) &&
        Objects.equals(this.nutritions, fruit.nutritions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genus, name, id, family, order, nutritions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fruit {\n");
    
    sb.append("    genus: ").append(toIndentedString(genus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    nutritions: ").append(toIndentedString(nutritions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

