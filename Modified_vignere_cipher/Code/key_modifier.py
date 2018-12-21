key=raw_input("Enter the key :")
klen=len(key)
keylength=len(key)*25
index=0
TEMP=''
for i in range(keylength):

    if ord(key[i])+1>90:
        key+="A"
    else:
        key+=chr(ord(key[i])+1)

    print key[i],

    if (i+1)%klen==0:
        print ""



text_file = open("key.txt", "w")
text_file.write(key)
text_file.close()
