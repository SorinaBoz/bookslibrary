package ro.digitalnation.bookslibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.bookslibrary.model.Loan;
import ro.digitalnation.bookslibrary.model.User;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
