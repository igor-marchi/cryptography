package tech.igor.cryptography.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.igor.cryptography.controller.dto.CreateTransactionRequest;
import tech.igor.cryptography.controller.dto.TransactionResponse;
import tech.igor.cryptography.controller.dto.UpdateTransactionRequest;
import tech.igor.cryptography.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateTransactionRequest request) {
        transactionService.create(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> list(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(transactionService.list(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.find(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateTransactionRequest request) {
        transactionService.update(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
