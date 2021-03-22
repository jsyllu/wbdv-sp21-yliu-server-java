package com.example.econstudio.models.widgets;

/**
 * This class is a Paragraph widget.
 */
public class ParagraphWidget extends AbstractWidget {

    private String text;

    public ParagraphWidget(String topicId, WidgetType type, Integer widgetOrder) {
        super(topicId, type, widgetOrder);
    }

    @Override
    public AbstractWidget copyAttributes(GenericWidget gw) {
        this.text = gw.getText();
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
