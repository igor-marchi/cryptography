package tech.igor.cryptography.controller.dto;

import tech.igor.cryptography.entity.TransactionEntity;

public record TransactionResponse(
    Long id,
    String userDocument,
    String creditCardToken,
    Long amount
) {
    public static TransactionResponse fromEntity(TransactionEntity entity) {
        return new TransactionResponse(
            entity.getId(),
            entity.getRawUserDocument(),
            entity.getRawCreditCardToken(),
            entity.getAmount()
        );
    }
}
