package datesandduties.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	Task findByTitle(String title);

}
