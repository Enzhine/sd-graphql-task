package ru.enzhine.sdgraphqltask.service;

import org.springframework.stereotype.Service;
import ru.enzhine.sdgraphqltask.dto.TaskRecordEntity;

import java.util.*;

@Service
public class RuntimeTaskRecordService implements TaskRecordService{
    private final List<TaskRecordEntity> database = new LinkedList<>();

    @Override
    public Iterable<TaskRecordEntity> getAll(int count, int offset) {
        return () -> database.stream().skip(offset).limit(count).iterator();
    }

    @Override
    public TaskRecordEntity getById(Integer id) throws NoSuchElementException {
        Optional<TaskRecordEntity> found = database.stream().filter((it) -> it.getId().equals(id)).findFirst();
        return found.orElseThrow();
    }

    @Override
    public TaskRecordEntity saveTaskRecord(String title, String description) {
        Optional<TaskRecordEntity> last = database.stream().max(Comparator.comparingInt(TaskRecordEntity::getId));
        Integer newId = last.map(taskRecordEntity -> taskRecordEntity.getId() + 1).orElse(0);
        TaskRecordEntity obj = new TaskRecordEntity(newId, title, description);
        database.add(obj);
        return obj;
    }
}
