from Crypto.PublicKey import RSA
from Crypto.Hash import SHA256
from Crypto import Random
from Crypto.Signature import pkcs1_15

def generate_signature(private_key, message):
    key=RSA.import_key(private_key)
    hashed_message=SHA256.new(message.encode('utf-8'))
    signer=pkcs1_15.new(key)
    signature=signer.sign(hashed_message)
    return signature

def verify_signature(public_key, message, signature):
    key=RSA.import_key(public_key)
    hashed_message=SHA256.new(message.encode('utf-8'))
    verifier=pkcs1_15.new(key)
    try:
        verifier.verify(hashed_message, signature)
        return True
    except (ValueError,TypeError):
        return False

random_generator=Random.new().read
key_pair=RSA.generate(1024, random_generator)
public_key=key_pair.publickey().export_key()
private_key=key_pair.export_key()

message="Hello, World!"

signature=generate_signature(private_key, message)
print("Generated Signature: ", signature)

is_valid = verify_signature(public_key, message, signature)
print("Signature Verification Result: ", is_valid)
