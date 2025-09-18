import java.util.*;

class TaskPriority {
    int userId;
    int taskId;
    int priority;
    public TaskPriority(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}

class TaskManager {
    private Map<Integer, TaskPriority> taskMap;
    private PriorityQueue<int[]> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new TaskPriority(userId, taskId, priority));
        pq.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        TaskPriority tp = taskMap.get(taskId);
        if (tp != null) {
            tp.priority = newPriority;
            pq.offer(new int[]{newPriority, taskId});
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int pri = top[0];
            int taskId = top[1];
            TaskPriority tp = taskMap.get(taskId);
            if (tp != null && tp.priority == pri) {
                pq.poll();
                taskMap.remove(taskId);
                return tp.userId;
            } else {
                pq.poll();
            }
        }
        return -1;
    }
}