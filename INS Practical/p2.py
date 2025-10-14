from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import binascii
from Crpto.Signature import pkcs1_15
keypair=RSA.generate(1024)
pubkey=keypair.publickey()

pubkeypem=pubkey.exportKey()
print(pubkeypem.decode('ascii'))

print(f"Public Key: (n={hex(pubkey.n)}, e={hex(pubkey.e})")


privkeypem=keypair.exportKey()
print(privkeypem.decode('ascii'))

print(f"Private Key: (n={hex(pubkey.n)}, d={hex(keypair.d)})")

encryptor=PKCS1_OAEP.new(pubkey)
encrypted=encryptor.encrypt(msg)
print("Encrypted: ", binascii.hexlify(encrypted))
