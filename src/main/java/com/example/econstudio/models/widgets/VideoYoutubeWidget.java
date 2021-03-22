package com.example.econstudio.models.widgets;

/**
 * This class is a Video widget.
 */
public class VideoYoutubeWidget extends AbstractWidget {

    private String videoId; // youtube 11 char video id
    private Integer width; // width of image & video only
    private Integer height; // height of image & video only
    private String title; // video title

    public VideoYoutubeWidget(String topicId, WidgetType type, Integer widgetOrder) {
        super(topicId, type, widgetOrder);
        this.width = 640;
        this.height = 390;
    }

    @Override
    public AbstractWidget copyAttributes(GenericWidget gw) {
        this.videoId = gw.getVideoId();
        this.width = gw.getWidth();
        this.height = gw.getHeight();
        this.title = gw.getTitle();
        return this;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
