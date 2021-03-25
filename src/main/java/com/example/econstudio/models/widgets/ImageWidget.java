package com.example.econstudio.models.widgets;

/**
 * This class is an Image widget.
 */
public class ImageWidget extends AbstractWidget {

    private String source;
    private String text;
    private Integer width;
    private Integer height;

    public ImageWidget(String topicId, WidgetType type, Integer widgetOrder) {
        super(topicId, type, widgetOrder);
        this.width = 500;
    }

    @Override
    public AbstractWidget copyAttributes(GenericWidget gw) {
        this.source = gw.getSource();
        this.text = gw.getText();
        this.width = gw.getWidth();
//        this.height = gw.getHeight();
        return this;
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
}
