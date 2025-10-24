TCL COMMANDS(commit, rollback, savepoint, begin transaction)

BEGIN TRANSACTION;

UPDATE customer SET address = '111 Jalan Damai, Kuala Lumpur' WHERE customernumber = 103;

COMMIT;

ROLLBACK;

SAVEPOINT before_update;

UPDATE customer SET country = 'Singapore' WHERE customernumber = 102;

ROLLBACK TO before_update;

COMMIT;
