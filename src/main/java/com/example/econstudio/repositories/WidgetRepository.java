package com.example.econstudio.repositories;

import com.example.econstudio.models.widgets.GenericWidget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<GenericWidget, Long> {

    @Query("SELECT widget FROM GenericWidget widget")
    List<GenericWidget> findAllWidgets();

    @Query(value="SELECT * FROM widgets WHERE id=:id", nativeQuery = true)
    GenericWidget findWidgetById(@Param("id") Long id);

    @Query(value="SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    List<GenericWidget> findWidgetForTopic(@Param("tid") String topicId);


}
