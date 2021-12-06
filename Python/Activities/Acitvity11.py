shop = {
    "kiwi": 25,
    "pineapple": 10,
    "orange": 18,
    "apple": 20
}

check = input("type fruit name").lower()

if(check in shop):
    print("available")
else:
    print("not available")