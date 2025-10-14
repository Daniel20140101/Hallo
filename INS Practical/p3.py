p=23
G=9

a=4
b=6

x=pow(G,a,p)
y=pow(G,b,p)

ka=pow(y,a,p)
kb=pow(x,b,p)

print("Secret Key for Alice is: ", ka)
print("Secret Key for Bob is: ", kb)
    
