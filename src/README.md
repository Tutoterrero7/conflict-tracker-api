# Conflict Tracker - Desplegament Fullstack

## 🌐 Enllaços públics
- Frontend: https://conflict-monitor-hznkdmgye-tutoterrero7s-projects.vercel.app 
- Backend API: https://conflict-tracker-api-production-0e30.up.railway.app/api/v1/conflicts

## 🏗️ Esquema de l'arquitectura
L'aplicació està fragmentada en tres capes independents i interconnectades:

- **Frontend (Client)**: Aplicació Vue 3 + Vite, allotjada a **Vercel**. S'encarrega de la interfície d'usuari i es comunica amb el backend mitjançant peticions HTTP.
- **Backend (API Rest)**: Servidor Spring Boot, allotjat a **Railway**. Proporciona els endpoints REST per gestionar conflictes, països, faccions i esdeveniments.
- **Base de dades (Persistence)**: PostgreSQL gestionat per **Supabase**. Emmagatzema totes les dades de l'aplicació.

La comunicació és completament remota i segura: el frontend crida al backend a través d'HTTPS, i el backend es connecta a Supabase mitjançant JDBC amb SSL (`?sslmode=require`). El CORS està configurat per permetre únicament les peticions des del domini de Vercel.

## ⚙️ Variables d'entorn
### Backend (Railway)
- `DB_URL`: JDBC URL de Supabase amb `?sslmode=require` (i paràmetres addicionals `prepareThreshold=0&preparedStatementCacheQueries=0` per evitar errors de prepared statements).
- `DB_USER`: usuari de Supabase (p. ex., `postgres.kuedaokvzxtzfgguxzbw`).
- `DB_PASSWORD`: contrasenya de la base de dades.
- `SPRING_PROFILES_ACTIVE`: `prod` (activa la configuració de producció).
- `FRONTEND_URL`: URL pública del frontend a Vercel (sense barra final).

### Frontend (Vercel)
- `VITE_API_URL`: URL completa del backend + `/api/v1`.

## 🐞 Modificacions realitzades i errors resolts

### Backend (Spring Boot)
1. **Error**: Credencials fixes a `application-prod.yaml` → **Solució**: Usar variables d'entorn `${DB_URL}`, `${DB_USER}`, `${DB_PASSWORD}`.
2. **Error**: `data.sql` s'executava abans de crear les taules → **Solució**: Afegir `defer-datasource-initialization: true`.
3. **Error**: CORS amb `*` no acceptat en producció → **Solució**: Configurar `CorsConfig` amb `@Value("${FRONTEND_URL}")` i origen específic.
4. **Error**: `prepared statement already exists` amb Supabase → **Solució**: Afegir `?prepareThreshold=0&preparedStatementCacheQueries=0` a la JDBC URL.

### Frontend (Vue 3)
1. **Error**: Peticions a `localhost:8080` en producció → **Solució**: Configurar `VITE_API_URL` a Vercel i usar `import.meta.env.VITE_API_URL` a `api.js`.
2. **Error**: Error 404 en refrescar rutes internes → **Solució**: Afegir `vercel.json` amb rewrites.

## 📦 Instruccions per a un nou desplegament
1. Crear base de dades a Supabase, obtenir credencials i JDBC URL (afegir `?sslmode=require`).
2. Desplegar backend a Railway, configurar les variables d'entorn.
3. Desplegar frontend a Vercel, configurar `VITE_API_URL` i `vercel.json`.
4. Actualitzar `FRONTEND_URL` a Railway amb la URL de Vercel.
5. Verificar que l'API retorna dades i que el frontend les mostra correctament.