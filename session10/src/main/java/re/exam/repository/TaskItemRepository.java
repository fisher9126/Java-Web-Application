package re.exam.repository;

import org.springframework.stereotype.Repository;
import re.exam.model.entity.TaskItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskItemRepository {
    private List<TaskItem> taskItems;

    public TaskItemRepository() {
        taskItems = new ArrayList<>();
        taskItems.add(new TaskItem("1","code", LocalDate.of(2026,04,19),"HIGH"));
        taskItems.add(new TaskItem("1","test",LocalDate.of(2026,04,20),"LOW"));
        taskItems.add(new TaskItem("1","phân tích",LocalDate.of(2026,04,18),"MEDIUM"));
        taskItems.add(new TaskItem("1","hoàn thiện",LocalDate.of(2026,04,21),"LOW"));
    }
    public List<TaskItem> getTaskItems() {
        return taskItems;
    }
    public TaskItem findById(String id) {
        for (TaskItem taskItem : taskItems) {
            if (taskItem.getId().equals(id)) {
                return taskItem;
            }
        }
        return null;
    }
    public void addTask(TaskItem taskItem) {
        taskItems.add(taskItem);
    }
}
