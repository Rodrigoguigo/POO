from random import randint

lista = [x for x in range(48)]
fim = randint(1, 48)

ini = randint(0, fim)
new = []
new += lista[0:ini]
new += reversed(lista[ini:fim])
new += lista[fim:len(lista)]

print(new)
print(len(new))
print(str(((32198.787338796737/33061.62626367373)-1)*100)+"%")