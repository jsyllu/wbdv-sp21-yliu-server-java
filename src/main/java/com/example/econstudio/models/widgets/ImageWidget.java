package com.example.econstudio.models.widgets;

/**
 * This class is an Image widget.
 */
public class ImageWidget extends AbstractWidget {

    private String source;
    private String text;
    private int width;
    private int height;

    public ImageWidget(String topicId, WidgetType type, Integer widgetOrder) {
        super(topicId, type, widgetOrder);
        this.width = 500;
    }

    @Override
    public AbstractWidget copyAttributes(GenericWidget gw) {
        this.source = gw.getSource();
        this.text = gw.getText();
        this.width = gw.getWidth();
        this.height = gw.getHeight();
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
}
