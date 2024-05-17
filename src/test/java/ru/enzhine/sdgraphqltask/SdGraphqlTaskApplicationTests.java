package ru.enzhine.sdgraphqltask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.context.junit4.SpringRunner;
import ru.enzhine.sdgraphqltask.dto.TaskRecordEntity;

import java.util.List;

@SpringBootTest
@Import(SdGraphqlTaskTestConfiguration.class)
class SdGraphqlTaskApplicationTests {

	@Autowired
	private HttpGraphQlTester tester;

	@Test
	void emptyTaskRecords() {
		tester.documentName("findAll").execute().path("findAll").entityList(TaskRecordEntity.class).hasSize(0);
	}

	@Test
	void existingTaskRecord() {
		tester.documentName("createTask").variable("title", "New").execute();
		List<TaskRecordEntity> result = tester.documentName("findAll").execute().path("findAll").entityList(TaskRecordEntity.class).hasSize(1).get();

		Assertions.assertEquals("New", result.get(0).getTitle(), "Created task should have exact title");
	}
}