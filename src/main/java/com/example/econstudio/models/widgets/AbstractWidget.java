package com.example.econstudio.models.widgets;

import java.util.Date;

/**
 * This abstract class represents an abstract Widget data model, which belongs to a topic, connected by {topicId}.
 */
public abstract class AbstractWidget implements IWidget {

    protected static Long idSeries = new Date().getTime(); // maintain unique id series

    protected String topicId; // topic id to group the widget
    protected Long id; // unique identifier
    protected WidgetType type; // type
    protected Integer widgetOrder; // order with respect to widgets in the same list
    protected Date createdAt; // created date and time
    protected Date updatedAt; // updated date and time
    protected String name; //optional name
    private String style; // optional css style applied to the widget
    private String value; // arbitrary initial value interpreted by the widget

    public AbstractWidget() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public AbstractWidget(String topicId, WidgetType type, Integer widgetOrder) {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
        this.id = idSeries++;
        this.topicId = topicId;
        this.type = type;
        this.widgetOrder = widgetOrder;
    }

    /**
     * Cast a GenericWidget object to a concrete object of AbstractWidget type.
     * @param gw a GenericWidget object with attributes
     * @return an AbstractWidget object with attributes of {@code gw}
     */
    public AbstractWidget castGenericWidget(GenericWidget gw) {
        this.topicId = gw.getTopicId();
        this.id = gw.getId();
        this.type = gw.getType();
        this.widgetOrder = gw.getWidgetOrder();
        this.createdAt = gw.getCreatedAt();
        this.updatedAt = gw.getUpdatedAt();
        this.name = gw.getName();
        this.style = gw.getStyle();
        this.value = gw.getValue();
        return this.copyAttributes(gw);
    }

    /**
     * Copy the attributes of the generic widget.
     * @param gw a generic widget object
     * @return an AbstractWidget object updated with attributes from {@code gw}
     */
    public AbstractWidget copyAttributes(GenericWidget gw){
        return this.copyAttributes(gw);
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
}
