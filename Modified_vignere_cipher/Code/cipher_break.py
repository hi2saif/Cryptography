# -*- coding: utf-8 -*-

import re,string

def main():

    #reading our cipher
    ciphertext=read_file("my_cipher.txt")

    #finding key length
    keylength=findkeylength(ciphertext)

    #reading dictionary file
    dict=read_file("dictionary.txt")

    #find frequency of letters in dictionary and our cipher
    dict_freq=find_freq(dict)

    #get key_length from user

    print "Possible key lengths :",keylength,"\n"
    for key_length in keylength:

        print "Attempting with keylength ",key_length
        #divide cipher base on key length in to array of string
        column_cipher=divide_cipher(ciphertext,key_length,len(ciphertext))

        #find each letter of key using columns using chi square
        key=""
        for column in column_cipher:
            key+=find_key_letter(column,dict_freq)

        print "Key :",key
        text_file = open("key.txt", "w")
        text_file.write(key)
        text_file.close()

        ciphertext=read_cipher("my_cipher.txt")
        plaintext=find_letter_from_vigenere(ciphertext.upper(),key)

        print "Plaintext :",plaintext
        text_file = open("my_plaintext.txt", "w")
        text_file.write(plaintext)
        text_file.close()
        option=input("\nIf you want to continue press 1 else 0 :")
        if(option==1):
            print ""
            continue
        else:
            break

def findkeylength(ciphertext):

    #finding repeated trigrams and the corresponding spaces
    maximum_keylength=260
    trigramspacing={}
    for i in range(len(ciphertext) - 3):
        trigram = ciphertext[i:i + 3]
        for j in range(i + 3, len(ciphertext) - 3):
                if ciphertext[j:j + 3] == trigram:
                    if trigram not in trigramspacing:
                        trigramspacing[trigram] = []
                    trigramspacing[trigram].append(j - i)

    #factorise each trigram spacing and make a list of factors and count for  trigram with freq > 3
    trigramspacingfactors={}
    for trigram in trigramspacing:
        if len(trigramspacing[trigram])>=3:
            for spacing in trigramspacing[trigram]:
                for i in range(2, maximum_keylength + 1):
                    if spacing % i == 0:
                        if i not in trigramspacingfactors.keys():
                            trigramspacingfactors[i]=0
                        trigramspacingfactors[i]+=1


    keylengths = []
    for factor in trigramspacingfactors:
        if(trigramspacingfactors[factor]>5):
            keylengths.append(factor)

    #sort in descending
    keylengths.sort(reverse=True)
    return keylengths

def read_file(name):
    with open(name, 'r') as myfile:
        file=myfile.read().replace('\n', '')

    regex = re.compile('[^a-zA-Z]')
    file=regex.sub('', file)
    file=file.upper()

    return file

def read_cipher(name):
    with open(name, 'r') as myfile:
        file=myfile.read().replace('\n', '')
    file=file.upper()

    return file

def divide_cipher(ciphertext,key_length,text_length):

    column = []
    for i in range(key_length):
        temp_string=""
        for j in range(text_length / key_length):
            temp_string+=ciphertext[(i + j * key_length)]
        column.append(temp_string)
    return column

def find_freq(dict):

    letter_freq={}
    for letter in string.ascii_uppercase:
        letter_freq[letter]=0
        letter_freq[letter]=(dict.count(letter)/float(len(dict)))
    return letter_freq

def find_key_letter(column,dict_freq):
    chi_value = {}

    min=100000000.0
    key_letter=''
    for letter in string.ascii_uppercase:

        shift = find_letter_from_vigenere(column, letter)
        chi_value[letter] = do_chi_square(shift, dict_freq)

        if chi_value[letter]<min:
            min=chi_value[letter]
            key_letter=letter

    return key_letter

def do_chi_square(text, dict_frq):
    text_length = len(text)

    sum = 0.0
    for i in range(len(text)):
        letter = text[i]
        count_of_letter = float(text.count(letter))

        expected_count_of_letter = dict_frq[letter] * text_length
        num = (count_of_letter - expected_count_of_letter)
        num = num*num
        num /= expected_count_of_letter
        sum += num
    return sum

def find_letter_from_vigenere(ciphertext, key):

    decrypt = ""
    index = 0
    for letter in ciphertext:
        if letter in string.ascii_uppercase:
            difference = (ord(letter) - ord(key[index]))
            if difference < 0:
                difference = 26 + difference
            elif difference + 65 > 90:
                difference -= 65
            decrypt+=chr(65 + difference)
            index += 1
            if index > len(key) - 1:
                index = 0
        else:
            decrypt+=letter
    return decrypt

if __name__=="__main__":
    main()

