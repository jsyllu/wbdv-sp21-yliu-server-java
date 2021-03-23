package com.example.econstudio.models.widgets;

import java.util.Date;

import static com.example.econstudio.models.widgets.AbstractWidget.idSeries;

public class GenericWidget {

    protected String topicId; // topic id to group the widget
    protected Long id; // unique identifier
    protected IWidget.WidgetType type; // type
    protected Integer widgetOrder; // order with respect to widgets in the same list
    private Date createdAt; // created date and time
    private Date updatedAt; // updated date and time
    protected String name; //optional name
    private String style; // optional css style applied to the widget
    private String value; // arbitrary initial value interpreted by the widget
    // heading
    private String heading;
    private Integer size;
    // image
    private String source;
    private String text; // same for paragraph & image
    private int width; // same for video & image
    private int height; // same for video & image
    // url
    private String url; // url of an online resource
    // youtube video
    private String videoId; // youtube 11 char video id
    private String title; // video title

    public GenericWidget() {
        this.id = idSeries++;
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public GenericWidget(String topicId, IWidget.WidgetType type, Integer widgetOrder) {
        this.topicId = topicId;
        this.type = type;
        this.widgetOrder = widgetOrder;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IWidget.WidgetType getType() {
        return type;
    }

    public void setType(IWidget.WidgetType type) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
