from Crypto import Random
from Crypto.PublicKey import RSA
from Crypto.Hash import SHA256
from Crypto.Signature import pkcs1_15
from Crypto.Cipher import PKCS1_OAEP
random_number=Random.new().read
key_pair=RSA.generate(1024, random_number)
public_key=key_pair.publickey().export_key()
print(public_key.decode('ascii'))
private_key=key_pair.export_key()
print(private_key.decode('ascii'))
print(f"Private key: (d={hex(key_pair.d)})")

def generate_signature(private_key, message):
    key=RSA.import_key(private_key)
    hashed_message=SHA256.new(message.encode('utf-8'))
    encryptor=pkcs1_15.new(key)
    encrypted=encryptor.encrypt(hashed_message)