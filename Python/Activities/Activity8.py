numbers=list(input("enter number").split(","))

first=numbers[0]
last=numbers[-1]

if first==last:
    print(True)
else:
    print(False)