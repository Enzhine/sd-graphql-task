package ru.enzhine.sdgraphqltask.controller;

import ru.enzhine.sdgraphqltask.dto.TaskRecordEntity;

public interface TaskRecordController {
    Iterable<TaskRecordEntity> findAll(Integer count, Integer offset);
    TaskRecordEntity createTask(String title, String description);
}
