def encrupt(text, S):
    result=""
    for i in range(len(text)):
        char=text[i]
        if char.isupper():
            result+=chr((ord(char) + S -65)%26+65)
        elif char.islower():
            result+=chr((ord(char) + S -97)%26+97)
        else:
            result+=char
    return result
