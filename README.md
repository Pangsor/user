# user
RESTFull user-service

# Create a user
curl --location 'http://localhost:8087/api/v1/users' \
--header 'Content-Type: application/json' \
--data '{
"namalengkap": "Jhon Wick",
"username": "jhon",
"password": "123",
"status": "1"
}'

# Update a user
curl --location 'http://localhost:8087/api/v1/users' \
--header 'Content-Type: application/json' \
--data '{
"userid":5,
"namalengkap": "Jhon Wick Updated",
"username": "jhonupdated",
"password": "123updated",
"status": "2"
}'

# Get all data user
curl --location 'http://localhost:8087/api/v1/users/all'

# Get a user
curl --location 'http://localhost:8087/api/v1/users/5'

# Delete a user
curl --location --request DELETE 'http://localhost:8087/api/v1/users/2'
