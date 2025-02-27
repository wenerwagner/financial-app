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

## Endpoints - Admin

### Users

- POST		/admin/users
- GET		/admin/users
- GET		/admin/users/{user-id}
- PUT		/admin/users/{user-id}
- DELETE	/admin/users/{user-id}

## Endpoints

### Spreadsheets

- POST		/spreadsheets
- GET		/spreadsheets
- GET		/spreadsheets/{spreadsheet-id}
- PUT		/spreadsheets/{spreadsheet-id}
- DELETE	/spreadsheets/{spreadsheet-id} 

### Budgets

- POST		/spreadsheets/{spreadsheet-id}/budgets
- GET		/spreadsheets/{spreadsheet-id}/budgets
- GET		/spreadsheets/{spreadsheet-id}/budgets/{budget-id}
- PUT		/spreadsheets/{spreadsheet-id}/budgets/{budget-id}
- DELETE	/spreadsheets/{spreadsheet-id}/budgets/{budget-id}

### Debts

- POST		/spreadsheets/{spreadsheet-id}/debts
- GET		/spreadsheets/{spreadsheet-id}/debts
- GET		/spreadsheets/{spreadsheet-id}/debts/{debt-id}
- PUT		/spreadsheets/{spreadsheet-id}/debts/{debt-id}
- DELETE	/spreadsheets/{spreadsheet-id}/debts/{debt-id}

### Transactions

- POST		/spreadsheets/{spreadsheet-id}/transactions
- GET		/spreadsheets/{spreadsheet-id}/transactions
- GET		/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}
- PUT		/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}
- DELETE	/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}

### Transactions

- POST		/spreadsheets/{spreadsheet-id}/transactions
- GET		/spreadsheets/{spreadsheet-id}/transactions
- GET		/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}
- PUT		/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}
- DELETE	/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}

### Accounts

- POST        /accounts
- GET         /accounts
- GET         /accounts/{account-id}
- PUT         /accounts/{account-id}
- DELETE      /accounts/{account-id}

### Credit Cards

- POST        /credit-cards
- GET         /credit-cards
- GET         /credit-cards/{credit-card-id}
- PUT         /credit-cards/{credit-card-id}
- DELETE      /credit-cards/{credit-card-id}