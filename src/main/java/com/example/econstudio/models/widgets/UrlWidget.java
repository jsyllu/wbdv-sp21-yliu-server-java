package com.example.econstudio.models.widgets;

/**
 * This class is an URL widget.
 */
public class UrlWidget extends AbstractWidget {

    private String url; // url of an online resource

    public UrlWidget(String topicId, WidgetType type, Integer widgetOrder) {
        super(topicId, type, widgetOrder);
    }

    @Override
    public AbstractWidget copyAttributes(GenericWidget gw) {
        this.url = gw.getUrl();
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
