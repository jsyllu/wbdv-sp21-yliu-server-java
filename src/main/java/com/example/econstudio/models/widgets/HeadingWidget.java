package com.example.econstudio.models.widgets;

/**
 * This class is a Heading widget.
 */
public class HeadingWidget extends AbstractWidget {

    private String heading;
    private Integer size;

    public HeadingWidget(String topicId, WidgetType type, Integer widgetOrder) {
        super(topicId, type, widgetOrder);
        this.size = 1;
    }

    @Override
    public AbstractWidget copyAttributes(GenericWidget gw) {
        this.heading = gw.getHeading();
        this.size = gw.getSize();
        return this;
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
}
