# Before use, install $ pip3 install venmo-api --upgrade
from venmo_api import Client
import venmo_api
# Get your access token. You will need to complete the 2FA process
access_token = Client.get_access_token(
    username='X', password='X')
venmo = Client(access_token=access_token)

# Search for users. You get 50 results per page.
users = venmo.user.search_for_users(query="Dayton")
for user in users:
    print(user.username, " ", user.id, " ", user.phone)


# Request money
#venmo.payment.request_money(32.5, "house expenses", "1122334455667")
# Send money
#venmo.payment.send_money(.50, "py test", "2619882537484288040")


def callback(transactions_list):
    for transaction in transactions_list:
        print(transaction)


# callback is optional. Max number of transactions per request is 50.
# 44108397
transactions = venmo_api.user.get_user_transactions(
    user_id='2619882534288040')
for i in transactions:
    print(i)
