# Esercizio3-laboratorio-ingegneria-informatica

# 🏠 Gestionale Catasto

Un'applicazione desktop per la gestione e la consultazione di dati catastali, che permette di navigare le relazioni tra proprietari, città e beni immobiliari attraverso un'interfaccia a menu gerarchici.

## 📋 Descrizione

Questo progetto è un sistema di gestione catastale (Catasto) che organizza i dati in due macro-categorie principali: **Proprietari** e **Città**. L'applicazione permette una consultazione rapida e intuitiva delle proprietà immobiliari, visualizzando dettagli come codici fiscali, codici catastali, tipologia dell'immobile e valore.

## ✨ Funzionalità Principali

L'interfaccia è divisa in due sezioni principali accessibili dalla barra dei menu:

### 1. Sezione Proprietari
Permette di visualizzare l'elenco di tutti i proprietari registrati nel sistema.
* **Lista Proprietari:** Visualizza Nome, Cognome e Codice Fiscale (es. *Luca Bianchi BNCLCU...*).
* **Dettaglio Codici:** Passando il mouse su un proprietario, è possibile visualizzare i codici catastali o gli ID degli immobili associati a quella persona.

### 2. Sezione Città
Permette una navigazione gerarchica basata sulla località dell'immobile.
* **Lista Città:** Elenco dei comuni presenti (es. Roma, Milano, Torino, Napoli).
* **Codice Catastale:** Visualizzazione del codice identificativo del comune (es. *H501* per Roma).
* **ID Immobile:** Lista degli immobili registrati sotto quel comune.
* **Dettagli Immobile:** Visualizzazione della tipologia (es. *Immobile urbano*, *residenziale*, *agricolo*) e del valore/rendita in Euro.
* **Proprietario:** Collegamento finale che mostra chi possiede lo specifico immobile selezionato.
