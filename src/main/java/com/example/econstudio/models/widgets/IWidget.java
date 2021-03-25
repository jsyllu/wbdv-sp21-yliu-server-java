package com.example.econstudio.models.widgets;

import java.util.Date;

public interface IWidget {
    /**
     * Available widget types.
     */
    enum WidgetType {
        HEADING,
        PARAGRAPH,
        URL,
        IMAGE,
        VIDEO_YOUTUBE,
        LIST
    }

    String getTopicId();

    Long getId();

    String getName();

    WidgetType getType();

    Integer getWidgetOrder();

    Date getCreatedAt();

    Date getUpdatedAt();

    String getStyle();

    String getValue();
}
