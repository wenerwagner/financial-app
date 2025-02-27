### Tasks

- [x] Create User CRUD.
- [x] Create Login for the User. Endpoints and all that.
- [x] Create a Role System.
- [x] Create a ADMIN User when the application starts.
- [x] Create Spreadsheet CRUD associated with logged User.
- [x] Create Accounts CRUD.
- [ ] Create Credit Cards CRUD.
- [ ] Create Budgets CRUD.
- [ ] Create Debts CRUD.
- [ ] Adicionar conexão com um banco de dados persistente.
- [ ] Create autoformatter to remove unused imports. Reassure this behaviour in the pipeline, not only in the IDE.
- [ ] Look for a strategy to sort the imports. Remove wildcard import. Add to autoformatter. Reassure in the pipeline.

### Ideas

- Create a way to fast prototype this basic setup of CRUD for the defined entities. Just a yaml or something like that setup and hit create, and have full functional application.

## Endpoints - Admin

### Users

- POST&nbsp;/admin/users&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/admin/users&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/admin/users/{user-id}&nbsp;:white_check_mark:
- PUT&nbsp;&nbsp;/admin/users/{user-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/admin/users/{user-id}&nbsp;:white_check_mark:

## Endpoints

### Spreadsheets

- POST&nbsp;&nbsp;/spreadsheets&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/spreadsheets&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}&nbsp;:white_check_mark:
- PUT&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/spreadsheets/{spreadsheet-id} &nbsp;:white_check_mark:

### Budgets

- POST&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/budgets&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/budgets&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/budgets/{budget-id}&nbsp;:hourglass_flowing_sand:
- PUT&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/budgets/{budget-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/spreadsheets/{spreadsheet-id}/budgets/{budget-id}&nbsp;:hourglass_flowing_sand:

### Debts

- POST&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/debts&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/debts&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/debts/{debt-id}&nbsp;:hourglass_flowing_sand:
- PUT&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/debts/{debt-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/spreadsheets/{spreadsheet-id}/debts/{debt-id}&nbsp;:hourglass_flowing_sand:

### Transactions

- POST&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/transactions&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/transactions&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}&nbsp;:hourglass_flowing_sand:
- PUT&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/spreadsheets/{spreadsheet-id}/transactions/{transaction-id}&nbsp;:hourglass_flowing_sand:

### Rules

- POST&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/rules&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/rules&nbsp;:hourglass_flowing_sand:
- GET&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/rules/{rule-id}&nbsp;:hourglass_flowing_sand:
- PUT&nbsp;&nbsp;/spreadsheets/{spreadsheet-id}/rules/{rule-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/spreadsheets/{spreadsheet-id}/rules/{rule-id}&nbsp;:hourglass_flowing_sand:

### Accounts

- POST&nbsp;&nbsp;/accounts&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/accounts&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/accounts/{account-id}&nbsp;:white_check_mark:
- PUT&nbsp;&nbsp;/accounts/{account-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/accounts/{account-id}&nbsp;:white_check_mark:

### Credit Cards

- POST&nbsp;&nbsp;/credit-cards&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/credit-cards&nbsp;:white_check_mark:
- GET&nbsp;&nbsp;/credit-cards/{credit-card-id}&nbsp;:white_check_mark:
- PUT&nbsp;&nbsp;/credit-cards/{credit-card-id}&nbsp;:hourglass_flowing_sand:
- DELETE&nbsp;/credit-cards/{credit-card-id}&nbsp;:white_check_mark: