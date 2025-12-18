# Conflict Tracker API

API REST per al seguiment de conflictes bèl·lics a nivell mundial desenvolupada amb Spring Boot 3.

## 📋 Descripció del projecte

Sistema d'informació sobre conflictes bèl·lics a nivell mundial anomenat "Conflict Tracker API".
El projecte implementa una API REST completa que permet gestionar informació sobre conflictes,
països involucrats, faccions i esdeveniments clau.

**Objectius principals:**
- Dissenyar i implementar un model de dades relacional amb Spring Data JPA
- Construir una API REST ben estructurada seguint convencions i millors pràctiques
- Aplicar una arquitectura per capes separant responsabilitats
- Implementar la lògica de negoci a la capa de servei
- Utilitzar Data Transfer Objects (DTOs) per desacoblar el model de dades de l'API


### Requisits previs
- **Java 17** o superior
- **Maven 3.6** o superior

### Passos per compilar i executar

1. **Descarregar el projecte**
# https://github.com/Tutoterrero7/conflict-tracker-api

# Obtenir tots els conflictes:
curl http://localhost:8080/api/v1/conflicts
# Obtenir conflictes per estat:
curl "http://localhost:8080/api/v1/conflicts?status=ACTIVE"
curl "http://localhost:8080/api/v1/conflicts?status=FROZEN"
curl "http://localhost:8080/api/v1/conflicts?status=ENDED"

# Obtenir un conflicte específic:
curl http://localhost:8080/api/v1/conflicts/1

# Crear un nou conflicte:
curl -X POST http://localhost:8080/api/v1/conflicts \
-H "Content-Type: application/json" \
-d '{
"name": "Conflicte de prova",
"startDate": "2023-01-01",
"status": "ACTIVE",
"description": "Descripció del conflicte de prova"
}'
# Actualitzar un conflicte:
curl -X PUT http://localhost:8080/api/v1/conflicts/1 \
-H "Content-Type: application/json" \
-d '{
"name": "Conflicte actualitzat",
"startDate": "2023-01-01",
"status": "FROZEN",
"description": "Descripció actualitzada"
}'

# Eliminar un conflicte:
curl -X DELETE http://localhost:8080/api/v1/conflicts/1

# Obtenir conflictes per codi de país:
curl http://localhost:8080/api/v1/countries/UKR/conflicts
# Obtenir tots els països:
curl http://localhost:8080/api/v1/countries
# Obtenir esdeveniments d'un conflicte:
curl http://localhost:8080/api/v1/events/conflict/1