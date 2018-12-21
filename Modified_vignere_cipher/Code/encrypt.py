import re

def main():
    plaintext=read_file("my_plaintext.txt")
    key=read_file("key.txt")
    cipher=encrypt(plaintext,key)
    print cipher

def encrypt(plaintext, key):
    keylength = len(key)
    ciphertext = ''
    for i in range(len(plaintext)):
            temp = (ord(plaintext[i]) + ord(key[i % keylength])) % 26
            ciphertext += chr(temp + 65)
    return ciphertext

def read_file(name):
    with open(name, 'r') as myfile:
        file=myfile.read().replace('\n', '')
    regex = re.compile('[^a-zA-Z]')
    file=regex.sub('', file)
    file=file.upper()
    return file

if __name__=="__main__":
    main()
