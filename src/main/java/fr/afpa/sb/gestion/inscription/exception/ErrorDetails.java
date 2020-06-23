package fr.afpa.sb.gestion.inscription.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Classe fournissant les détails des erreurs.
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private Integer status;


    public ErrorDetails(Date timestamp, String message, String details,HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status=status.value();

    }

    /**
     * Retourne la date de l'erreur.
     *
     * @return Date
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Retourne le message d'erreur.
     *
     * @return String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retourne les détails de l'erreur.
     *
     * @return String
     */
    public String getDetails() {
        return details;
    }

    public Integer getStatus() {
        return status;
    }
}
