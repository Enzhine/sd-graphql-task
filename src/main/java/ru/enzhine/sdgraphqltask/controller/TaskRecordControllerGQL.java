package ru.enzhine.sdgraphqltask.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.enzhine.sdgraphqltask.dto.TaskRecordEntity;
import ru.enzhine.sdgraphqltask.service.TaskRecordService;

@Controller
@AllArgsConstructor
public class TaskRecordControllerGQL implements TaskRecordController {

    private final TaskRecordService taskRecordService;

    @QueryMapping
    @Override
    public Iterable<TaskRecordEntity> findAll(@Argument Integer count, @Argument Integer offset) {
        return taskRecordService.getAll(count, offset);
    }

    @MutationMapping
    @Override
    public TaskRecordEntity createTask(@Argument String title, @Argument String description) {
        return taskRecordService.saveTaskRecord(title, description);
    }
}
