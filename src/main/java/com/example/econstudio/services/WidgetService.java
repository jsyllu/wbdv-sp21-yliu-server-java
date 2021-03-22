package com.example.econstudio.services;

import com.example.econstudio.models.widgets.*;
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

    private final List<AbstractWidget> widgets = new ArrayList<>();

    {
        String topicId = "60579aea2f9bc6001783c3ef";
        HeadingWidget hw = new HeadingWidget(topicId, IWidget.WidgetType.HEADING, 1);
        hw.setHeading("New Header 1");
        ParagraphWidget pw = new ParagraphWidget(topicId, IWidget.WidgetType.PARAGRAPH, 2);
        pw.setText("Some text here to form a sample paragraph.");
        ImageWidget iw = new ImageWidget(topicId, IWidget.WidgetType.IMAGE, 3);
        iw.setSource("https://www.sapphirewebsolutions.com/wp-content/uploads/2019/09/Web-Development-Trends.jpg");
        iw.setText("This is a sample image.");
        UrlWidget uw = new UrlWidget(topicId, IWidget.WidgetType.URL, 4);
        uw.setUrl("www.google.com");
        VideoYoutubeWidget vw = new VideoYoutubeWidget(topicId, IWidget.WidgetType.VIDEO_YOUTUBE, 5);
        vw.setTitle("Project Prototype");
        vw.setVideoId("rMFHE_E-GFc");

        widgets.add(hw);
        widgets.add(pw);
        widgets.add(iw);
        widgets.add(uw);
        widgets.add(vw);
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
     * @param gw a new GenericWidget to be cast in to an AbstractWidget first and then store in server
     * @return a new Widget object stored in server
     */
    public AbstractWidget createWidget(String tid, GenericWidget gw) {
        gw.setTopicId(tid);
        gw.setWidgetOrder(this.widgets.size()+1); // add to last
        AbstractWidget widget = castGenericWidgetToAbstract(gw); // cast to a type of AbstractWidget
        assert widget != null;
        widget.castGenericWidget(gw); // copy all attribute of GenericWidget to AbstractWidget
        widgets.add(widget);
        return widget;
    }

    /**
     * Find all widgets.
     *
     * @return a list of all Widget objects in the server.
     */
    public List<AbstractWidget> findAllWidgets() {
        return widgets;
    }

    /**
     * Find all widgets for a topic.
     *
     * @param topicId topic id of widgets
     * @return a list of Widget objects under the {@param topicId}
     */
    public List<AbstractWidget> findWidgetsForTopic(String topicId) {
        List<AbstractWidget> widgetsForTopic = new ArrayList<>();
        for (AbstractWidget w : this.widgets) {
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
    public AbstractWidget findWidgetById(Long id) {
        for (AbstractWidget w : this.widgets) {
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
    public Integer updateWidget(Long id, GenericWidget widget2Update) {
        AbstractWidget widget = null;
        int i = 0;
        // locate the old widget's index and object
        while (i < this.widgets.size()) {
            widget = this.widgets.get(i);
            if (widget.getId().equals(id)) {
                break;
            }
            i++;
        }
        // update the widget with the new object, change object class if type differs
        if (widget != null) {
            IWidget.WidgetType type = widget2Update.getType();
            widget2Update.setUpdatedAt(new Date()); // update the updatedAt attribute
            if (type.equals(widget.getType())) { // same type
                widget.copyAttributes(widget2Update); // copy attributes from param obj
            } else { // different type
                widget = castGenericWidgetToAbstract(widget2Update); // cast to a type of AbstractWidget
                assert widget != null;
                widget.castGenericWidget(widget2Update); // copy all attribute of GenericWidget to AbstractWidget
            }
            this.widgets.set(i, widget); // insert the updated widget back to list
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
        Iterator<AbstractWidget> widgetIterator = widgets.iterator();
        while (widgetIterator.hasNext()) {
            if (widgetIterator.next().getId().equals(id)) {
                widgetIterator.remove();
                return 1;
            }
        }
        return 0;
    }

    /**
     * Cast a GenericWidget to AbstractWidget.
     * @param gw a GenericWidget object
     * @return an AbstractWidget which has the same type as {@code gw}
     */
    private AbstractWidget castGenericWidgetToAbstract(GenericWidget gw) {
//        AbstractWidget widget = null;
        IWidget.WidgetType type = gw.getType();
//        System.out.println(type);
        switch (type) {
            case HEADING:
                return new HeadingWidget(gw.getTopicId(), type, gw.getWidgetOrder());
            case PARAGRAPH:
                return new ParagraphWidget(gw.getTopicId(), type, gw.getWidgetOrder());
            case URL:
                return new UrlWidget(gw.getTopicId(), type, gw.getWidgetOrder());
            case IMAGE:
                return new ImageWidget(gw.getTopicId(), type, gw.getWidgetOrder());
            case VIDEO_YOUTUBE:
                return new VideoYoutubeWidget(gw.getTopicId(), type, gw.getWidgetOrder());
            default:
                return null;
        }
//        return widget;
    }
}
