import random
import time
import math

from Contas import TspEle


def calcTotal(aux2, cidades):
    total = 0
    for i in range(len(aux2) - 1):
        city = cidades[aux2[i] - 1]
        total += city.calcDist(cidades[aux2[i + 1] - 1])
    else:
        city = cidades[aux2[len(aux2) - 1] - 1]
        total += city.calcDist(cidades[aux2[0] - 1])

    return total


def tweak(lista):
    fim = random.randint(1, 48)

    ini = random.randint(0, fim)
    new = []
    new += lista[0:ini]
    new += reversed(lista[ini:fim])
    new += lista[fim:len(lista)]
    return new


come = time.time()

ideal = 33061.62626367373
temp = 1000000

f = open("res.txt", "r")
aux2 = list(map(int, f.read().split("\n")))
f.close()
total = 0

f = open("coord.txt", "r")
aux = f.read().split("\n")
f.close()
cidades = []
for i in range(len(aux)):
    aux[i] = aux[i].split(" ")
    aux[i] = list(map(int, aux[i]))
    cidades.append(TspEle(aux[i][0], aux[i][1], aux[i][2]))
s = aux2
best = s
while temp > 0:
    r = tweak(s)
    distr = calcTotal(r, cidades)
    dists = calcTotal(s, cidades)
    if distr < dists or random.randint(0, 1000) / 1000 < math.e ** ((distr - dists) / temp):
        s = r
    temp -= 1

    if dists < calcTotal(best, cidades):
        best = s

for i in best:
    print(i)

print(calcTotal(best, cidades))
print(time.time() - come)
