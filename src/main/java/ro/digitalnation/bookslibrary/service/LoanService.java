package ro.digitalnation.bookslibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.digitalnation.bookslibrary.model.Loan;
import ro.digitalnation.bookslibrary.repository.LoanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        List<Loan> loans = new ArrayList<>();
        loanRepository.findAll().forEach(loans::add);
        return loans;
    }

    public Loan getLoan(int id) {
        return loanRepository.findById(id).get();
    }

    public void addLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public void updateLoan(int id, Loan loan) {
        loanRepository.save(loan);
    }

    public void deleteLoan(int id) {
        loanRepository.deleteById(id);
    }
}
