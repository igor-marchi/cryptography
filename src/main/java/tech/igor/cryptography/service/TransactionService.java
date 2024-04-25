package tech.igor.cryptography.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.igor.cryptography.controller.dto.CreateTransactionRequest;
import tech.igor.cryptography.controller.dto.TransactionResponse;
import tech.igor.cryptography.controller.dto.UpdateTransactionRequest;
import tech.igor.cryptography.entity.TransactionEntity;
import tech.igor.cryptography.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void create(CreateTransactionRequest request) {
        var entity = new TransactionEntity(request.userDocument(), request.creditCardToken(), request.amount());
        transactionRepository.save(entity);
    }

    public Page<TransactionResponse> list(int page, int size) {
        return transactionRepository.findAll(PageRequest.of(page, size)).map(TransactionResponse::fromEntity);
    }

    public TransactionResponse find(Long id) {
        return transactionRepository.findById(id)
            .map(TransactionResponse::fromEntity)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
    }

    public void update(Long id, UpdateTransactionRequest request) {
        var entity = transactionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
        entity.setAmount(request.amount());
        transactionRepository.save(entity);
    }

    public void delete(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        }
        transactionRepository.deleteById(id);
    }
}
