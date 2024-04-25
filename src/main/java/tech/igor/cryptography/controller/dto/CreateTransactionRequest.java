package tech.igor.cryptography.controller.dto;

public record CreateTransactionRequest (
    String userDocument,
    String creditCardToken,
    Long amount
) {}
