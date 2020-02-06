to convert privatekey.pem to pkcs8 format, execute the following openssl command:
openssl pkcs8 -topk8 -nocrypt -in privatekey.pem -out privatekey_pkcs8

after that, remove new lines (\n)