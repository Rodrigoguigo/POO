from scripts.Contas import TspEle

f = open("ideal.txt", "r")
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

for i in range(len(aux2)-1):
    city = cidades[aux2[i]-1]
    total += city.calcDist(cidades[aux2[i+1]-1])
print(total)