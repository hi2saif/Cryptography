import string

def main():
    ciphertext=read_file("my_cipher.txt")
    key=read_file("key.txt")
    plaintext=decrypt(ciphertext,key)
    text_file = open("my_plaintext.txt", "w")
    text_file.write(plaintext)
    text_file.close()
    print plaintext

def decrypt(ciphertext, key):
    keylength = len(key)
    plaintext = ''
    keyindex=0
    for i in range(len(ciphertext)):
        if ciphertext[i] in string.ascii_uppercase:
            value = (ord(ciphertext[i]) - ord(key[keyindex % keylength])) % 26
            keyindex+=1
            plaintext += chr(value + 65)
        else:
            plaintext+=ciphertext[i]
    return plaintext

def read_file(name):
    with open(name, 'r') as myfile:
        file=myfile.read().replace('\n', '')
    return file.upper()

if __name__=="__main__":
    main()
