package com.tim.demo.flinkbootdemo.properties;

import java.io.Serializable;
import java.util.List;

/**
 * @author TimWong
 * @date 2020/11/16 17:26:06
 */
public class TestProperties implements Serializable {

    private String name;
    private String value;
    private List<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item implements Serializable{
        private String key;
        private Integer order;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }
}
