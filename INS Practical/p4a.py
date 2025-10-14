import hashlib

result1=hashlib.md5(b'hello')
result2=hashlib.md5(b'world')

print("The byte equivalent of hash is: ",result1.digest())
print("The hexadecimal equivalent of hash1 is: ",result1.hexdigest())


st=input("Enter the value to encode: ")
result=hashlib.sha1(st.encode())
print(result.hexdigest())
print(result.digest())
