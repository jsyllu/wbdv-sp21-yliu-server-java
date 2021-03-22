package com.example.econstudio.controllers;

import com.example.econstudio.models.widgets.AbstractWidget;
import com.example.econstudio.models.widgets.GenericWidget;
import com.example.econstudio.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService widgetService; //= new WidgetService();

    @PostMapping("/api/topics/{tid}/widgets")
    public AbstractWidget createWidget(
            @PathVariable("tid") String topicId,
            @RequestBody GenericWidget widget
    ) {
        widget.setTopicId(topicId);
        return widgetService.createWidget(topicId, widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<AbstractWidget> findWidgetsForTopic(
            @PathVariable("tid") String topicId
    ) {
        return widgetService.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets")
    public List<AbstractWidget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public AbstractWidget findWidgetById(
            @PathVariable("wid") Long id
    ) {
        return widgetService.findWidgetById(id);
    }

    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(
            @PathVariable("wid") Long id,
            @RequestBody GenericWidget widget2Update
    ) {
        return widgetService.updateWidget(id, widget2Update);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget(
            @PathVariable("wid") Long id
    ) {
        return widgetService.deleteWidget(id);
    }
}
