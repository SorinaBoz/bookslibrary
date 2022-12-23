package ro.digitalnation.bookslibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.bookslibrary.model.Book;
import ro.digitalnation.bookslibrary.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
