package com.example.econstudio.models;

import java.util.Date;

/**
 * This class represents a Widget data model, which belongs to a topic, connected by {topicId}.
 */
public class Widget {

    /**
     * Available widget types.
     */
    public enum WidgetType {
        HEADING,
        PARAGRAPH,
        LIST,
        URL,
        IMAGE,
        VIDEO_YOUTUBE
    }

    private String topicId; // topic id to group the widget
    private String name; //optional name
    private Long id; // unique identifier
    private WidgetType type; // type
    private Integer widgetOrder; // order with respect to widgets in the same list
    private String text; // plain text content
    private String url; // url of an online resource
    private Integer size; // represent size
    private Integer width; // width of image & video only
    private Integer height; // height of image & video only
    private String style; // css style applied to the widget
    private String value; // arbitrary initial value interpreted by the widget
    private Date createdAt; // created date and time
    private Date updatedAt; // updated date and time

    public Widget() {
        // empty by default
    }

    public Widget(String topicId, String name, Long id, WidgetType type, String text) {
        this.topicId = topicId;
        this.name = name;
        this.id = id;
        this.type = type;
        this.text = text;
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
        this.type = type;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
