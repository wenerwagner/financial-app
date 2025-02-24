### Tasks

- [x] Create User CRUD.
- [x] Create Login for the User. Endpoints and all that.
- [x] Create a Role System.
- [x] Create a ADMIN User when the application starts.
- [x] Create Spreadsheet CRUD associated with logged User.
- [ ] Create Accounts CRUD.
- [ ] Create Credit Cards CRUD.
- [ ] Create Budgets CRUD.
- [ ] Create Debts CRUD.
- [ ] Adicionar conexão com um banco de dados persistente.

### Endpoints

#### Users

POST    /users\
GET	    /users\
GET	    /users/{user-id}\
PUT	    /users/{user-id}\
DELETE	/users/{user-id}

#### Spreadsheets
POST	/users/{user-id}/spreadsheets\
GET	/users/{user-id}/spreadsheets\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}\
PUT	/users/{user-id}/spreadsheets/{spreadsheet-id}\
DELETE	/users/{user-id}/spreadsheets/{spreadsheet-id}

#### Accounts
POST	/users/{user-id}/spreadsheets/{spreadsheet-id}/accounts\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/accounts\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/accounts/{account-id}\
PUT	/users/{user-id}/spreadsheets/{spreadsheet-id}/accounts/{account-id}\
DELETE	/users/{user-id}/spreadsheets/{spreadsheet-id}/accounts/{account-id}

#### Credit Cards
POST	/users/{user-id}/spreadsheets/{spreadsheet-id}/credit-cards\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/credit-cards\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/credit-cards/{credit-card-id}\
PUT	/users/{user-id}/spreadsheets/{spreadsheet-id}/credit-cards/{credit-card-id}\
DELETE	/users/{user-id}/spreadsheets/{spreadsheet-id}/credit-cards/{credit-card-id}

#### Budgets
POST	/users/{user-id}/spreadsheets/{spreadsheet-id}/budgets\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/budgets\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/budgets/{budgets-id}\
PUT	/users/{user-id}/spreadsheets/{spreadsheet-id}/budgets/{budgets-id}\
DELETE	/users/{user-id}/spreadsheets/{spreadsheet-id}/budgets/{budgets-id}

#### Debts
POST	/users/{user-id}/spreadsheets/{spreadsheet-id}/debts\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/debts\
GET	/users/{user-id}/spreadsheets/{spreadsheet-id}/debts/{debts-id}\
PUT	/users/{user-id}/spreadsheets/{spreadsheet-id}/debts/{debts-id}\
DELETE	/users/{user-id}/spreadsheets/{spreadsheet-id}/debts/{debts-id}