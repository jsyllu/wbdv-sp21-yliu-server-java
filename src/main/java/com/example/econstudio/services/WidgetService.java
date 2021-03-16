package com.example.econstudio.services;

import com.example.econstudio.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * This is a Widget Service.
 */
@Service
public class WidgetService {

    private List<Widget> widgets = new ArrayList<>();

    {
        Widget w1 = new Widget("123abc", "W1", 1L, Widget.WidgetType.HEADING, "New Header 1");
        Widget w2 = new Widget("123abc", "W2", 2L, Widget.WidgetType.PARAGRAPH, "Some text here to form a sample paragraph.");
        Widget w3 = new Widget("123abc", "W3", 3L, Widget.WidgetType.URL, "url");
        w3.setUrl("www.google.com");
        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
    }

    /**
     * Construct a WidgetService object.
     */
    public WidgetService() {
        // empty by default
    }

    /**
     * Create a widget for a topic.
     *
     * @param tid id of the topic which contains this new widget
     * @param w a new widget to store in server
     * @return a new Widget object stored in server
     */
    public Widget createWidget(String tid, Widget w) {
        w.setTopicId(tid);
        Long id = (new Date()).getTime();
        w.setId(id);
        widgets.add(w);
        return w;
    }

    /**
     * Find all widgets.
     *
     * @return a list of all Widget objects in the server.
     */
    public List<Widget> findAllWidgets() {
        return widgets;
    }

    /**
     * Find all widgets for a topic.
     *
     * @param topicId topic id of widgets
     * @return a list of Widget objects under the {@param topicId}
     */
    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> widgetsForTopic = new ArrayList<>();
        for (Widget w : this.widgets) {
            if (w.getTopicId().equals(topicId)) {
                widgetsForTopic.add(w);
            }
        }
        return widgetsForTopic;
    }

    /**
     * Find a widget by its id.
     *
     * @param id id of the widget object
     * @return the matching widget object or null if not found
     */
    public Widget findWidgetById(Long id) {
        for (Widget w : this.widgets) {
            if (w.getId().equals(id)) {
                return w;
            }
        }
        return null;
    }

    /**
     * Update a widget.
     *
     * @param id            id of the widget to be updated
     * @param widget2Update the widget object to update
     * @return an integer indicating the status of the update operation, 1 successful and 0 otherwise
     */
    public Integer updateWidget(Long id, Widget widget2Update) {
        Widget widget;
        for (int i = 0; i < this.widgets.size(); i++) {
            widget = this.widgets.get(i);
            if (widget.getId().equals(id)) {
                widget2Update.setUpdatedAt(new Date());
                this.widgets.set(i, widget2Update);
                return 1;
            }
        }
        return 0;
    }

    /**
     * Delete a widget.
     *
     * @param id id of the widget to be deleted
     * @return an integer indicating the status of the delete operation, 1 successful and 0 otherwise
     */
    public Integer deleteWidget(Long id) {
        Iterator<Widget> widgetIterator = widgets.iterator();
        while (widgetIterator.hasNext()) {
            if (widgetIterator.next().getId().equals(id)) {
                widgetIterator.remove();
                return 1;
            }
        }
        return 0;
    }
}
