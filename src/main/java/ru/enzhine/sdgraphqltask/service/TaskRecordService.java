package ru.enzhine.sdgraphqltask.service;

import ru.enzhine.sdgraphqltask.dto.TaskRecordEntity;

public interface TaskRecordService {
    Iterable<TaskRecordEntity> getAll(int count, int offset);
    TaskRecordEntity getById(Integer id);
    TaskRecordEntity saveTaskRecord(String title, String description);
}
