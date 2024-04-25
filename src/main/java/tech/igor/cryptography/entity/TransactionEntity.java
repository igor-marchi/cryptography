package tech.igor.cryptography.entity;

import jakarta.persistence.*;
import tech.igor.cryptography.service.CryptoService;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_document")
    private String encryptedUserDocument;
    @Transient
    private String rawUserDocument;

    @Column(name = "credit_card_token")
    private String encryptedCreditCardToken;
    @Transient
    private String rawCreditCardToken;

    private Long amount;

    public TransactionEntity() {}

    public TransactionEntity(String rawUserDocument, String rawCreditCardToken, Long amount) {
        this.rawUserDocument = rawUserDocument;
        this.rawCreditCardToken = rawCreditCardToken;
        this.amount = amount;
    }

    @PrePersist
    public void prePersist() {
        if (rawUserDocument != null) {
            encryptedUserDocument = CryptoService.encrypt(rawUserDocument);
        }
        if (rawCreditCardToken != null) {
            encryptedCreditCardToken = CryptoService.encrypt(rawCreditCardToken);
        }
    }

    @PostLoad
    public void postLoad() {
        if (encryptedUserDocument != null) {
            rawUserDocument = CryptoService.decrypt(encryptedUserDocument);
        }
        if (encryptedCreditCardToken != null) {
            rawCreditCardToken = CryptoService.decrypt(encryptedCreditCardToken);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEncryptedUserDocument() {
        return encryptedUserDocument;
    }

    public String getRawUserDocument() {
        return rawUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return encryptedCreditCardToken;
    }

    public String getRawCreditCardToken() {
        return rawCreditCardToken;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
