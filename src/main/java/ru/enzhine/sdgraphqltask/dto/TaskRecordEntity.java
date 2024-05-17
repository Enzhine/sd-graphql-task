package ru.enzhine.sdgraphqltask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRecordEntity {
    private Integer id;
    private String title;
    private String description;
}
