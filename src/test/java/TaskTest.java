import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldSearchQueryInSimpleTaskWhenMatches() {
        SimpleTask task = new SimpleTask(7, "Позвонить родителям");

        boolean expected = true;
        boolean actual = task.matches("родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInSimpleTaskNegative() {
        SimpleTask task = new SimpleTask(7, "Позвонить родителям");


        boolean expected = false;
        boolean actual = task.matches("семья");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInEpicSubtasksWhenMatches() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);


        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInEpicSubtasksNegative() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);


        boolean expected = false;
        boolean actual = epic.matches("Колбаса");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInMeetingWhenTopicTrue() {

        Meeting meeting = new Meeting(98, "Проблемы детско-родительских отношений", "Методы заимодействия школы и семьи", "5 апреля в 14");

        boolean expected = true;
        boolean actual = meeting.matches("отношений");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInMeetingWhenProjectTrue() {

        Meeting meeting = new Meeting(98, "Проблемы детско-родительских отношений", "Методы заимодействия школы и семьи", "5 апреля в 14");

        boolean expected = true;
        boolean actual = meeting.matches("Методы");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInMeetingNegative() {

        Meeting meeting = new Meeting(98, "Проблемы детско-родительских отношений", "Методы заимодействия школы и семьи", "5 апреля в 14");

        boolean expected = false;
        boolean actual = meeting.matches("грамотность");

        Assertions.assertEquals(expected, actual);
    }
}
